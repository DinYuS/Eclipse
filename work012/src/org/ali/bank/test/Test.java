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
		System.out.println("��ѡ��������ݣ�");
		System.out.println("1.��Ա");
		System.out.println("2.�ͻ�\n");
		String flag;
		flag=scanner.next();
		switch (flag) {
		case "1":
			try {
				new BankMenu().LogIn();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			break;
		case "2":
			new UserMenu().init();
			break;
		default:
			System.out.println("��������������");
			break;
		}
	}

}
