package cn.edu.lingnan.dao;

import java.util.Scanner;

class Menu{
	public void loginmenu(){
		System.out.println("***************���ֹ���ϵͳ************");
		System.out.println();
		System.out.println("1����¼");
		System.out.println("2���˳�");
		System.out.println("��ѡ��Ҫ���в����ı�");
	}
}

public class LoginDAO {
	public static void main(String[] args){
		Menu me = new Menu();
		String me1, me2;
		boolean flag = true;
		while(flag){
			me.loginmenu();
			Scanner input = new Scanner(System.in);
			int choose = input.nextInt();
			switch(choose){
				case 1:
					System.out.println("�������û�����");
					me1 = input.next();
					System.out.println("���������룺");
					me2 = input.next();
					if(me1.equalsIgnoreCase("admin") && me2.equalsIgnoreCase("0000")){
						System.out.println("@@��¼�ɹ���admin@@");
						flag = false;
					}
					else{
						System.out.println("@@��¼ʧ��@@");
					}
					break;
				case 2:
					System.out.println("�˳�");
					break;
			}
			System.out.println();
		}
	}
}
