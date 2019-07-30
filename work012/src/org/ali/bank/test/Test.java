package org.ali.bank.test;

import java.util.Scanner;

import org.ali.bank.util.BankMenu;
import org.ali.bank.util.UserMenu;

public class Test {
	public static void main(String[] args) {
//		new Menu().init();
//		
//		Scanner scanner=new Scanner(System.in);
//		scanner.next();
//		scanner.nextInt();
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----------------------------------\n");
		System.out.println("请选择您的身份：");
		System.out.println("1.柜员");
		System.out.println("2.客户\n");
		String flag;
		flag=scanner.next();
		switch (flag) {
		case "1":
			try {
				new BankMenu().LogIn();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			break;
		case "2":
			new UserMenu().init();
			break;
		default:
			System.out.println("您输入的序号有误");
			break;
		}
	}

}
