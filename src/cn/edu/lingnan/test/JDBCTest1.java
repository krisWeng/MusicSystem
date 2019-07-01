package cn.edu.lingnan.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.ListenDAO;
import cn.edu.lingnan.dao.LoginDAO;
//import cn.edu.lingnan.dao.Menu;
import cn.edu.lingnan.dao.MusicDAO;
import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.ListenDTO;
import cn.edu.lingnan.dto.MusicDTO;
import cn.edu.lingnan.dto.UserDTO;

class Menu {
	Scanner input = new Scanner(System.in);
	public void loginmenu(){
		System.out.println("***************音乐管理系统************");
		System.out.println();
		System.out.println("1、登录");
		System.out.println("2、退出");
		System.out.println("请选择要进行操作的序号");
//		String s1, s2;
//		boolean flag = true;
//			Scanner input = new Scanner(System.in);
//			int choose = input.nextInt();
//			switch(choose){
//				case 1:
//					System.out.println("请输入用户名：");
//					s1 = input.next();
//					System.out.println("请输入密码：");
//					s2 = input.next();
//					if(s1.equalsIgnoreCase(s1) && s2.equalsIgnoreCase(s2)){
//						System.out.println("@@登录成功：admin@@");
//						flag = false;
//					}
//					else{
//						System.out.println("@@登录失败@@");
//					}
//					break;
//					
//				case 2:
//					System.out.println("退出");
//					break;
//			}
	}

	public void mainmenu() {
		System.out.println("***************主菜单************");
		System.out.println();
		System.out.println("1、用户表");
		System.out.println("2、专辑表");
		System.out.println("3、音乐表");
		System.out.println("0、返回上一级");
		System.out.println("请选择要进行操作的表");
	}

	//菜单---------------------------------------------------------------------------
	public void usermenu() {
		System.out.println("**************User表*****************");
		System.out.println();
		System.out.println("1、查询");
		System.out.println("2、更新");
		System.out.println("3、删除");
		System.out.println("4、增加");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
	}

	public void musicmenu() {
		System.out.println("**************Music表****************");
		System.out.println();
		System.out.println("1、查询");
		System.out.println("2、更新");
		System.out.println("3、删除");
		System.out.println("4、增加");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
	}

	public void listenmenu() {
		System.out.println("***************Listen表****************");
		System.out.println();
		System.out.println("1、查询");
		System.out.println("2、更新");
		System.out.println("3、删除");
		System.out.println("4、增加");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
	}
	
	//查询---------------------------------------------------------------------------
	public void selectu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User表查询菜单*****************");
		System.out.println();
		System.out.println("1、查询所有用户");
		System.out.println("2、按用户编号查询");
		System.out.println("3、按用户姓名查询");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				Vector<UserDTO> v = new Vector<UserDTO>();
				v = u.findAllUserInfo();
				System.out.println("用户编号"+"\t\t"+"用户姓名"+"\t\t"+"性别"+"\t\t"+"年龄");
				for (UserDTO sd : v)
					System.out.println(sd.getUnumber()+"\t\t"+sd.getUname()+"\t\t"+sd.getSex()+"\t\t"+sd.getAge());
				System.out.println();
				break;
			
			case 2:
				Vector<UserDTO> v1 = new Vector<UserDTO>();
				System.out.println("输入你需要查询的用户编号：");
				Scanner input = new Scanner(System.in);
				String findnumber = input.nextLine();
				v1 = u.findAllUserByNumber(findnumber);
				break;
				
			case 3:
				Vector<UserDTO> v2 = new Vector<UserDTO>();
				System.out.println("输入你需要查询的用户姓名");
				Scanner input1 = new Scanner(System.in);
				String findname = input1.nextLine();
				v2 = u.findAllUserByName(findname);
				break;
//			
//			case 0:
//				this.usermenu();
//				break;
			}
	}
	
	public void selectm() {
		MusicDAO m = new MusicDAO();
		System.out.println("**************Music表查询菜单*****************");
		System.out.println();
		System.out.println("1、查询所有曲目");
		System.out.println("2、按曲目编号查询");
		System.out.println("3、按曲目名称查询");
		System.out.println("4、按歌手姓名查询");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				Vector<MusicDTO> v = new Vector<MusicDTO>();
				v = m.findAllMusicInfo();
				System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
				for (MusicDTO sd : v)
					System.out.println(sd.getMnumber()+"\t\t"+sd.getMname()+"\t\t"+sd.getSinger());
				System.out.println();
				break;
		
			case 2:
				Vector<MusicDTO> v1 = new Vector<MusicDTO>();
				System.out.println("输入你需要查询的曲目编号：");
				Scanner input = new Scanner(System.in);
				String findnumber = input.nextLine();
				v1 = m.findAllMusicByNumber(findnumber);
				break;
			
			case 3:
				Vector<MusicDTO> v2 = new Vector<MusicDTO>();
				System.out.println("输入你需要查询的曲目名称");
				Scanner input1 = new Scanner(System.in);
				String findname = input1.nextLine();
				//v2 = m.findAllMusicByName(findname);
				break;
				
			case 4:
				Vector<MusicDTO> v3 = new Vector<MusicDTO>();
				System.out.println("输入你需要查询的歌手姓名");
				Scanner input2 = new Scanner(System.in);
				String findsinger = input2.nextLine();
				v2 = m.findAllMusicBySinger(findsinger);
				break;
			
			case 0:
//				me.musicmenu();
				break;
		}
	}
	
	public void selectl() {
		ListenDAO l = new ListenDAO();
		System.out.println("**************Listen表查询菜单*****************");
		System.out.println();
		System.out.println("1、查询所有歌单");
		System.out.println("2、按曲目编号查询");
		System.out.println("3、按曲目名称查询");
		System.out.println("4、按用户编号查询");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				Vector<ListenDTO> v = new Vector<ListenDTO>();
				v = l.findAllListenInfo();
				System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"用户编号");
				for (ListenDTO sd : v)
					System.out.println(sd.getMnumber()+"\t\t"+sd.getMname()+"\t\t"+sd.getUnumber());
				System.out.println();
				break;
		
			case 2:
				Vector<ListenDTO> v1 = new Vector<ListenDTO>();
				System.out.println("输入你需要查询的曲目编号：");
				Scanner input = new Scanner(System.in);
				String findMnumber = input.nextLine();
				v1 = l.findAllListenByMnumber(findMnumber);
				break;
			
			case 3:
				Vector<ListenDTO> v2 = new Vector<ListenDTO>();
				System.out.println("输入你需要查询的曲目名称");
				Scanner input1 = new Scanner(System.in);
				String findname = input1.nextLine();
				v2 = l.findAllListenByName(findname);
				break;
				
			case 4:
				Vector<ListenDTO> v3 = new Vector<ListenDTO>();
				System.out.println("输入你需要查询的用户编号");
				Scanner input2 = new Scanner(System.in);
				String findUnumber = input2.nextLine();
				v2 = l.findAllListenByUnumber(findUnumber);
				break;
				
			case 0:
//				me.listenmenu();
				break;
		}
	}
	
	//更新---------------------------------------------------------------------------	
	public void updateu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User表更新菜单*****************");
		System.out.println();
		System.out.println("1、更新用户编号");
		System.out.println("2、更新用户姓名");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("输入需要更新的用户编号：");
				String id = input.nextLine();
				System.out.println("请输入更新后的用户编号：");
				String id2 = input.nextLine();
				flag = u.updateAllUserByNumber(id2, id);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
			
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("输入需要更新的用户姓名：");
				String name = input1.nextLine();
				System.out.println("请输入更新后的用户姓名：");
				String name2 = input1.nextLine();
				flag = u.updateAllUserByName(name2, name);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
		}
	}
	
	public void updatem() {
		MusicDAO m = new MusicDAO();
		System.out.println("**************Music表更新菜单*****************");
		System.out.println();
		System.out.println("1、更新曲目编号");
		System.out.println("2、更新曲目名称");
		System.out.println("3、更新歌手姓名");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("请输入需要更新的曲目编号：");
				String id = input.nextLine();
				System.out.println("请输入需要更新后的曲目编号：");
				String id2 = input.nextLine();
				flag = m.updateMusicByNumber(id2, id);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
				
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("请输入需要更新的曲目名称：");
				String name = input1.nextLine();
				System.out.println("请输入需要更新后的曲目名称：");
				String name2 = input1.nextLine();
				flag = m.updateMusicByName(name2, name);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
			
			case 3:
				boolean flag2 = false;
				Scanner input2 = new Scanner(System.in);
				System.out.println("请输入需要更新的歌手姓名：");
				String singer = input2.nextLine();
				System.out.println("请输入需要更新后的歌手姓名：");
				String singer2 = input2.nextLine();
				flag = m.updateMusicBySinger(singer2, singer);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
		}
	}
	
	public void updatel() {
		ListenDAO l = new ListenDAO();
		System.out.println("**************Listen表更新菜单*****************");
		System.out.println();
		System.out.println("1、更新曲目编号");
		System.out.println("2、更新曲目名称");
		System.out.println("3、更新曲目编号");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("请输入需要更新的曲目编号：");
				String id = input.nextLine();
				System.out.println("请输入需要更新后的曲目编号：");
				String id2 = input.nextLine();
				flag = l.updateListenByid(id2, id);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
				
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("请输入需要更新的曲目名称：");
				String name = input1.nextLine();
				System.out.println("请输入需要更新后的曲目名称：");
				String name2 = input1.nextLine();
				flag = l.updateListenByName(name2, name);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
			
			case 3:
				boolean flag2 = false;
				Scanner input2 = new Scanner(System.in);
				System.out.println("请输入需要更新的用户编号：");
				String number = input2.nextLine();
				System.out.println("请输入需要更新后的用户编号：");
				String number2 = input2.nextLine();
				flag = l.updateListenByNumber(number2, number);
				if(flag)
					System.out.println("更新成功");
				else
					System.out.println("更新失败");
				break;
		}
	}
	
	//删除---------------------------------------------------------------------------
	public void deleteu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User表删除菜单*****************");
		System.out.println();
		System.out.println("1、按用户编号删除");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("输入需要删除的用户编号：");
				String id = input.nextLine();
				flag = u.deleteUserByNumber(id);
				if(flag)
					System.out.println("删除成功");
				else
					System.out.println("删除失败");
				break;
			
			case 0:
				break;
		}
	}
	
	public void deletem() {
		MusicDAO m = new MusicDAO();
		System.out.println("**************Music表删除菜单*****************");
		System.out.println();
		System.out.println("1、按曲目编号删除");
		System.out.println("2、按曲目名称删除");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("输入需要删除的曲目编号：");
				String id = input.nextLine();
				flag = m.deleteMusicByNumber(id);
				if(flag)
					System.out.println("删除成功");
				else
					System.out.println("删除失败");
				break;
			
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("输入需要删除的曲目名称：");
				String name = input1.nextLine();
				//flag = m.deleteMusicByName(name);
				//if(flag)
					System.out.println("删除成功");
				//else
					System.out.println("删除失败");
		}
	}
	
	public void deletel() {
		ListenDAO l = new ListenDAO();
		System.out.println("**************Listen表删除菜单*****************");
		System.out.println();
		System.out.println("1、按曲目编号删除");
		System.out.println("2、按曲目名称删除");
		System.out.println("3、按用户编号删除");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("输入需要删除的曲目编号：");
				String id = input.nextLine();
				flag = l.deleteListenByNumber(id);
				if(flag)
					System.out.println("删除成功");
				else
					System.out.println("删除失败");
				break;
			
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("输入需要删除的曲目编号：");
				String name = input1.nextLine();
				flag = l.deleteListenByName(name);
				if(flag)
					System.out.println("删除成功");
				else
					System.out.println("删除失败");
				break;
			
			case 3:
				boolean flag2 = false;
				Scanner input2 = new Scanner(System.in);
				System.out.println("输入需要删除的用户编号：");
				String id1 = input2.nextLine();
				flag = l.deleteListenByID(id1);
				if(flag)
					System.out.println("删除成功");
				else
					System.out.println("删除失败");
				break;
		}
	}
	
	//增加---------------------------------------------------------------------------	
	public void insertu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User表增加菜单*****************");
		System.out.println();
		System.out.println("1、增加用户");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt(); 
		
		switch(choose){
			case 1:
				boolean flag = false;
				Vector<UserDTO> v = new Vector<UserDTO>();
				Scanner input = new Scanner(System.in);
				System.out.println("请输入需要添加的用户编号：");
				String id = input.nextLine();
				System.out.println("请输入需要添加的用户姓名：");
				String name = input.nextLine();
				System.out.println("请输入需要添加的用户性别：");
				String sex = input.nextLine();
				System.out.println("请输入需要添加的用户年龄：");
				String age = input.nextLine();
				flag = u.insertAllUser(id, name, sex, age);
				if (flag)
					System.out.println("增加成功");
				else
					System.out.println("增加失败");
				break;
			
			case 0:
				break;
		}
	}	
	
	public void insertm() {
		System.out.println("**************Music表增加菜单*****************");
		System.out.println();
		System.out.println("1、增加曲目");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt(); 
		
		switch(choose){
			case 1:
				MusicDAO m = new MusicDAO();
				boolean flag = false;
				Vector<UserDTO> v = new Vector<UserDTO>();
				Scanner input = new Scanner(System.in);
				System.out.println("请输入需要添加的曲目编号：");
				String id = input.nextLine();
				System.out.println("请输入需要添加的曲目名称：");
				String name = input.nextLine();
				System.out.println("请输入需要添加的歌手姓名：");
				String singer = input.nextLine();
				flag = m.insertAllMusic(id, name, singer);
				if (flag)
					System.out.println("增加成功");
				else
					System.out.println("增加失败");
				break;
				
			case 0:
				break;
		}
	}
	
	public void insertl() {
		ListenDAO l = new ListenDAO();
		System.out.println("**************Listen表增加菜单*****************");
		System.out.println();
		System.out.println("1、增加歌单");
		System.out.println("0、返回上一级");
		System.out.println("请选择需要操作的序号：");
		int choose = input.nextInt(); 
		
		switch(choose){
			case 1:
				boolean flag = false;
				Vector<UserDTO> v = new Vector<UserDTO>();
				Scanner input = new Scanner(System.in);
				System.out.println("请输入需要添加的曲目编号：");
				String id = input.nextLine();
				System.out.println("请输入需要添加的曲目名称：");
				String name = input.nextLine();
				System.out.println("请输入需要添加的用户编号：");
				String id2 = input.nextLine();
				flag = l.insertAllListen(id, name, id2);
				if (flag)
					System.out.println("增加成功");
				else
					System.out.println("增加失败");
				break;
		}
	}
}

public class JDBCTest1 {
	public static void main(String[] args){
		int n=0, a=0, b=0, c=0, d=0, e=0;
		LoginDAO l = new LoginDAO();
		Menu me = new Menu();
		me.loginmenu();
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		do{
			switch(n){
				case 1:do{
					me.mainmenu();
					a = input.nextInt();
			
					switch(a){
						case 1:do{
							me.usermenu();
							b = input.nextInt();
							
							switch(b){
								case 1:
									me.selectu();
									break;
								case 2:
									me.updateu();
									break;
								case 3:
									me.deleteu();
									break;
								case 4:
									me.insertu();
									break;
//								default:
//									me.usermenu();
//									break;
								}
						}while(b!=0);
							break;
				
						case 2:do{
							me.musicmenu();
							c = input.nextInt();
							switch(c){
								case 1:
									me.selectm();
									break;
								case 2:
									me.updatem();
									break;
								case 3:
									me.deletem();
									break;
								case 4:
									me.insertm();
									break;
//								default:
//									me.musicmenu();
//									break;
								}
						}while(c!=0);
							break;
				
						case 3:do{
							me.listenmenu();
							d = input.nextInt();
							switch(d){
								case 1:
									me.selectl();
									break;
								case 2:
									me.updatel();
									break;
								case 3:
									me.deletel();
									break;
								case 4:
									me.insertl();
									break;
//								default:
//									me.listenmenu();
//									break;
								}
						}while(d!=0);
							break;
					}
				}while(a!=0);
					break;
					
				case 2:
					System.out.println("退出");
					break;
			}
		}while(n!=0);
	}
}
