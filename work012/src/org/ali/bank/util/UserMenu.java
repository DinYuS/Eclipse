package org.ali.bank.util;

import java.util.Scanner;

public class UserMenu {
	Scanner scanner = new Scanner(System.in);
	
	public void init(){
		System.out.println("��ҳ��Ϊ����ҳ��");
		System.out.println("1.ת��");
		System.out.println("��ѡ����Ҫ���еĲ�����");
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
	 * �Ӽ����Ͻ���һ���ַ�������
	 * @return	���شӼ����Ͻ��յ�һ���ַ���
	 */
	public String inputString(){
		return scanner.next();
	}
}
