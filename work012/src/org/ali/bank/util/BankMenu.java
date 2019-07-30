package org.ali.bank.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.lang.System;

import org.ali.bank.common.DataBaseConnection;
import org.ali.bank.dao.AdminDAO;
import org.ali.bank.dao.CardDAO;
import org.ali.bank.dao.UserDAO;
import org.ali.bank.vo.Card;
import org.ali.bank.vo.User;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class BankMenu {
	Scanner scanner = new Scanner(System.in);
	String uid;	
	//银行柜员认证
	@SuppressWarnings({ "static-access", "resource" })
	public void LogIn() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入账号：");
		String aid = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
	
		Connection conn = new DataBaseConnection().getConnection();
		String sql = "SELECT * FROM admin WHERE Aid=? and Apassword=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, aid);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("----------------------------------\n");
			System.out.println("           登陆成功！欢迎！ ");
			System.out.println("----------------------------------\n");
			init();
		} else {
			System.out.println("账户密码错误，请重新登陆！");
			LogIn();
		}
		conn.close();
	}
	
	
	
	
	//银行柜员菜单
	public void init() {
		System.out.println("\n------------欢迎您使用银行柜员系统------------\n");
		System.out.println("1.开户");
		System.out.println("2.存钱");
		System.out.println("3.取钱");
		System.out.println("4.转账");
		System.out.println("5.开通网银");
		System.out.println("6.返回");
		System.out.println("7.输入其他数字退出");
		System.out.println("请输入你要操作的编号：");

		String tag = inputString();
		switch (tag) {
		case "1":
			this.openAccount();
			break;
		case "2":
			this.saveMoney();
			break;
		case "3":
			this.takeMoney();
			break;
		case "4":
			this.transferMoney();
			break;
		case "5":
			this.openInterBank();
			break;	
		case "0":
			this.init();
			break;	
		default:
			System.out.println("程序结束，正在退出。。。");
			System.exit(0);
			//return;
		}
	}
	
	
	//开户
	@SuppressWarnings("unused")
	public void openAccount() {
		System.out.println("请输入身份证号码：");

		// 判断有没有这个人
		UserDAO userDAO = new UserDAO();
		String uid = this.inputString();
		String cardId = null;
		boolean tag = userDAO.verifyUserFromUser(uid);

		if (tag == true) {
			// 弄一个卡过来，开户

			System.out.println("             正在为您开户，请稍后。。。\n");
			String cid = new CardDAO().queryUnuseCard();
			if(!new CardDAO().openAccount(uid, cid)){
				System.out.println("开户时出现错误");
				this.init();
			}
			
			System.out.println("开户成功！您的银行卡号是：" + cid);
			
			init();
		} else {
			System.out.println("查无此人！");
			init();
		}

		// init();
	}

	
	//存钱
	public void saveMoney(){
		this.verifyUserDate();
		System.out.println("认证成功！欢迎您办理存钱业务！");
		
		System.out.println("请输入您要存钱的金额:");
		double saveMoney = Double.parseDouble(this.inputString());
		
		if(!new CardDAO().saveMoney(uid, saveMoney)){
			System.out.println("Failing！请重新操作！");
			this.init();
		}
		
		double Money = new CardDAO().queryAccountMoney(uid);
		System.out.println("业务办理成功。卡上余额："+Money);
		this.init();
	}
	
	
	//取钱
	public void takeMoney(){
		this.verifyUserDate();
		System.out.println("认证成功！欢迎您办理取钱业务！");
		
		//显示卡中余额
		double cMoney = new CardDAO().queryAccountMoney(uid);
		System.out.println("当前卡上余额："+cMoney);
		
		System.out.println("请输入您要取出钱的金额:");
		double takeMoney = Double.parseDouble(this.inputString());
		if(takeMoney>cMoney){
			System.out.println("Warning！卡上余额不足！");
			this.init();
		}
		//开始取钱
		if(!new CardDAO().takeMoney(uid, takeMoney)){
			System.out.println("Failing！请重新操作！");
			this.init();
		}
		System.out.println("业务办理成功");
		this.init();
	}
	
	
	//开通网银
	public void openInterBank(){
		this.verifyUserDate();
		System.out.println("认证成功！欢迎您办理网银业务！");
		//开网银
		if(!new CardDAO().openInterBank(uid)){
			System.out.println("Failing！请重新操作！");
			this.init();
		}
		System.out.println("网银开通成功！");
		this.init();
	}
	
	
	//转账操作
	public void transferMoney() {
		this.verifyUserDate();
		System.out.println("认证成功！欢迎您办理转账业务！");
		//校验该账户有没有开户
		if(!new CardDAO().verifyUserCardByCardId(uid)){
			System.out.println("该用户尚没有开户，请先执行开户手续！");
			this.init();
		}
		//执行转账业务
		System.out.println("请输入您要转账用户的银行卡卡号：");
		String otherCardId = this.inputString();
		//校验该转账账户存不存在
		if(!new CardDAO().verifyUserCardByCardId(otherCardId)){
			System.out.println("该账户不存在！！！");
			this.init();
		}
		//显示卡中余额
		double cMoney = new CardDAO().queryAccountMoney(uid);
		System.out.println("当前卡上余额为："+cMoney);
		
		System.out.println("请输入您要转账的金额：");
		double transferMoney = Double.parseDouble(this.inputString());
		if(transferMoney>cMoney){
			System.out.println("对不起，账户余额不足");
			this.init();
		}
		if(!new CardDAO().transferMoney(uid,otherCardId,transferMoney)){
			System.out.println("转账期间出现错误");
			this.init();
		}
		System.out.println("转账成功");
		this.init();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 验证用户是否合法函数
	 */
	public void verifyUserDate(){
		System.out.println("请输入您的身份证号：");
		uid = this.inputString();
		//验证用户信息
		if(!new UserDAO().verifyUserFromUser(uid)){
			System.out.println("错误！请重新登陆：");
			this.init();
		}
	}
	
	public String inputString() {

		return scanner.next();
	}

	public int inputInt() {

		return scanner.nextInt();
	}

}
