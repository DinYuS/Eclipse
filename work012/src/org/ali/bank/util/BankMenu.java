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
	//���й�Ա��֤
	@SuppressWarnings({ "static-access", "resource" })
	public void LogIn() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("�������˺ţ�");
		String aid = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
	
		Connection conn = new DataBaseConnection().getConnection();
		String sql = "SELECT * FROM admin WHERE Aid=? and Apassword=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, aid);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("----------------------------------\n");
			System.out.println("           ��½�ɹ�����ӭ�� ");
			System.out.println("----------------------------------\n");
			init();
		} else {
			System.out.println("�˻�������������µ�½��");
			LogIn();
		}
		conn.close();
	}
	
	
	
	
	//���й�Ա�˵�
	public void init() {
		System.out.println("\n------------��ӭ��ʹ�����й�Աϵͳ------------\n");
		System.out.println("1.����");
		System.out.println("2.��Ǯ");
		System.out.println("3.ȡǮ");
		System.out.println("4.ת��");
		System.out.println("5.��ͨ����");
		System.out.println("6.����");
		System.out.println("7.�������������˳�");
		System.out.println("��������Ҫ�����ı�ţ�");

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
			System.out.println("��������������˳�������");
			System.exit(0);
			//return;
		}
	}
	
	
	//����
	@SuppressWarnings("unused")
	public void openAccount() {
		System.out.println("���������֤���룺");

		// �ж���û�������
		UserDAO userDAO = new UserDAO();
		String uid = this.inputString();
		String cardId = null;
		boolean tag = userDAO.verifyUserFromUser(uid);

		if (tag == true) {
			// Ūһ��������������

			System.out.println("             ����Ϊ�����������Ժ󡣡���\n");
			String cid = new CardDAO().queryUnuseCard();
			if(!new CardDAO().openAccount(uid, cid)){
				System.out.println("����ʱ���ִ���");
				this.init();
			}
			
			System.out.println("�����ɹ����������п����ǣ�" + cid);
			
			init();
		} else {
			System.out.println("���޴��ˣ�");
			init();
		}

		// init();
	}

	
	//��Ǯ
	public void saveMoney(){
		this.verifyUserDate();
		System.out.println("��֤�ɹ�����ӭ�������Ǯҵ��");
		
		System.out.println("��������Ҫ��Ǯ�Ľ��:");
		double saveMoney = Double.parseDouble(this.inputString());
		
		if(!new CardDAO().saveMoney(uid, saveMoney)){
			System.out.println("Failing�������²�����");
			this.init();
		}
		
		double Money = new CardDAO().queryAccountMoney(uid);
		System.out.println("ҵ�����ɹ���������"+Money);
		this.init();
	}
	
	
	//ȡǮ
	public void takeMoney(){
		this.verifyUserDate();
		System.out.println("��֤�ɹ�����ӭ������ȡǮҵ��");
		
		//��ʾ�������
		double cMoney = new CardDAO().queryAccountMoney(uid);
		System.out.println("��ǰ������"+cMoney);
		
		System.out.println("��������Ҫȡ��Ǯ�Ľ��:");
		double takeMoney = Double.parseDouble(this.inputString());
		if(takeMoney>cMoney){
			System.out.println("Warning���������㣡");
			this.init();
		}
		//��ʼȡǮ
		if(!new CardDAO().takeMoney(uid, takeMoney)){
			System.out.println("Failing�������²�����");
			this.init();
		}
		System.out.println("ҵ�����ɹ�");
		this.init();
	}
	
	
	//��ͨ����
	public void openInterBank(){
		this.verifyUserDate();
		System.out.println("��֤�ɹ�����ӭ����������ҵ��");
		//������
		if(!new CardDAO().openInterBank(uid)){
			System.out.println("Failing�������²�����");
			this.init();
		}
		System.out.println("������ͨ�ɹ���");
		this.init();
	}
	
	
	//ת�˲���
	public void transferMoney() {
		this.verifyUserDate();
		System.out.println("��֤�ɹ�����ӭ������ת��ҵ��");
		//У����˻���û�п���
		if(!new CardDAO().verifyUserCardByCardId(uid)){
			System.out.println("���û���û�п���������ִ�п���������");
			this.init();
		}
		//ִ��ת��ҵ��
		System.out.println("��������Ҫת���û������п����ţ�");
		String otherCardId = this.inputString();
		//У���ת���˻��治����
		if(!new CardDAO().verifyUserCardByCardId(otherCardId)){
			System.out.println("���˻������ڣ�����");
			this.init();
		}
		//��ʾ�������
		double cMoney = new CardDAO().queryAccountMoney(uid);
		System.out.println("��ǰ�������Ϊ��"+cMoney);
		
		System.out.println("��������Ҫת�˵Ľ�");
		double transferMoney = Double.parseDouble(this.inputString());
		if(transferMoney>cMoney){
			System.out.println("�Բ����˻�����");
			this.init();
		}
		if(!new CardDAO().transferMoney(uid,otherCardId,transferMoney)){
			System.out.println("ת���ڼ���ִ���");
			this.init();
		}
		System.out.println("ת�˳ɹ�");
		this.init();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ��֤�û��Ƿ�Ϸ�����
	 */
	public void verifyUserDate(){
		System.out.println("�������������֤�ţ�");
		uid = this.inputString();
		//��֤�û���Ϣ
		if(!new UserDAO().verifyUserFromUser(uid)){
			System.out.println("���������µ�½��");
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
