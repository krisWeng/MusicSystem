package cn.edu.lingnan.dao;

import java.util.Scanner;

class Menu{
	public void loginmenu(){
		System.out.println("***************音乐管理系统************");
		System.out.println();
		System.out.println("1、登录");
		System.out.println("2、退出");
		System.out.println("请选择要进行操作的表");
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
					System.out.println("请输入用户名：");
					me1 = input.next();
					System.out.println("请输入密码：");
					me2 = input.next();
					if(me1.equalsIgnoreCase("admin") && me2.equalsIgnoreCase("0000")){
						System.out.println("@@登录成功：admin@@");
						flag = false;
					}
					else{
						System.out.println("@@登录失败@@");
					}
					break;
				case 2:
					System.out.println("退出");
					break;
			}
			System.out.println();
		}
	}
}
