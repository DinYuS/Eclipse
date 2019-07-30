package org.ali.bank.util;

import java.util.Scanner;

public class UserMenu {
	Scanner scanner = new Scanner(System.in);
	
	public void init(){
		System.out.println("此页面为网银页面");
		System.out.println("1.转账");
		System.out.println("请选择您要进行的操作：");
		String flag = this.inputString();
		switch (flag) {
		case "1":
			new BankMenu().transferMoney();
			break;
		default:
			this.init();
			break;
		}
	}
	/**
	 * 从键盘上接收一行字符串方法
	 * @return	返回从键盘上接收的一串字符串
	 */
	public String inputString(){
		return scanner.next();
	}
}
