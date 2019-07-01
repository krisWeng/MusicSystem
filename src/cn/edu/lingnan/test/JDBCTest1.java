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
		System.out.println("***************���ֹ���ϵͳ************");
		System.out.println();
		System.out.println("1����¼");
		System.out.println("2���˳�");
		System.out.println("��ѡ��Ҫ���в��������");
//		String s1, s2;
//		boolean flag = true;
//			Scanner input = new Scanner(System.in);
//			int choose = input.nextInt();
//			switch(choose){
//				case 1:
//					System.out.println("�������û�����");
//					s1 = input.next();
//					System.out.println("���������룺");
//					s2 = input.next();
//					if(s1.equalsIgnoreCase(s1) && s2.equalsIgnoreCase(s2)){
//						System.out.println("@@��¼�ɹ���admin@@");
//						flag = false;
//					}
//					else{
//						System.out.println("@@��¼ʧ��@@");
//					}
//					break;
//					
//				case 2:
//					System.out.println("�˳�");
//					break;
//			}
	}

	public void mainmenu() {
		System.out.println("***************���˵�************");
		System.out.println();
		System.out.println("1���û���");
		System.out.println("2��ר����");
		System.out.println("3�����ֱ�");
		System.out.println("0��������һ��");
		System.out.println("��ѡ��Ҫ���в����ı�");
	}

	//�˵�---------------------------------------------------------------------------
	public void usermenu() {
		System.out.println("**************User��*****************");
		System.out.println();
		System.out.println("1����ѯ");
		System.out.println("2������");
		System.out.println("3��ɾ��");
		System.out.println("4������");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
	}

	public void musicmenu() {
		System.out.println("**************Music��****************");
		System.out.println();
		System.out.println("1����ѯ");
		System.out.println("2������");
		System.out.println("3��ɾ��");
		System.out.println("4������");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
	}

	public void listenmenu() {
		System.out.println("***************Listen��****************");
		System.out.println();
		System.out.println("1����ѯ");
		System.out.println("2������");
		System.out.println("3��ɾ��");
		System.out.println("4������");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
	}
	
	//��ѯ---------------------------------------------------------------------------
	public void selectu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User���ѯ�˵�*****************");
		System.out.println();
		System.out.println("1����ѯ�����û�");
		System.out.println("2�����û���Ų�ѯ");
		System.out.println("3�����û�������ѯ");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				Vector<UserDTO> v = new Vector<UserDTO>();
				v = u.findAllUserInfo();
				System.out.println("�û����"+"\t\t"+"�û�����"+"\t\t"+"�Ա�"+"\t\t"+"����");
				for (UserDTO sd : v)
					System.out.println(sd.getUnumber()+"\t\t"+sd.getUname()+"\t\t"+sd.getSex()+"\t\t"+sd.getAge());
				System.out.println();
				break;
			
			case 2:
				Vector<UserDTO> v1 = new Vector<UserDTO>();
				System.out.println("��������Ҫ��ѯ���û���ţ�");
				Scanner input = new Scanner(System.in);
				String findnumber = input.nextLine();
				v1 = u.findAllUserByNumber(findnumber);
				break;
				
			case 3:
				Vector<UserDTO> v2 = new Vector<UserDTO>();
				System.out.println("��������Ҫ��ѯ���û�����");
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
		System.out.println("**************Music���ѯ�˵�*****************");
		System.out.println();
		System.out.println("1����ѯ������Ŀ");
		System.out.println("2������Ŀ��Ų�ѯ");
		System.out.println("3������Ŀ���Ʋ�ѯ");
		System.out.println("4��������������ѯ");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				Vector<MusicDTO> v = new Vector<MusicDTO>();
				v = m.findAllMusicInfo();
				System.out.println("��Ŀ���"+"\t\t"+"��Ŀ����"+"\t\t"+"��������");
				for (MusicDTO sd : v)
					System.out.println(sd.getMnumber()+"\t\t"+sd.getMname()+"\t\t"+sd.getSinger());
				System.out.println();
				break;
		
			case 2:
				Vector<MusicDTO> v1 = new Vector<MusicDTO>();
				System.out.println("��������Ҫ��ѯ����Ŀ��ţ�");
				Scanner input = new Scanner(System.in);
				String findnumber = input.nextLine();
				v1 = m.findAllMusicByNumber(findnumber);
				break;
			
			case 3:
				Vector<MusicDTO> v2 = new Vector<MusicDTO>();
				System.out.println("��������Ҫ��ѯ����Ŀ����");
				Scanner input1 = new Scanner(System.in);
				String findname = input1.nextLine();
				//v2 = m.findAllMusicByName(findname);
				break;
				
			case 4:
				Vector<MusicDTO> v3 = new Vector<MusicDTO>();
				System.out.println("��������Ҫ��ѯ�ĸ�������");
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
		System.out.println("**************Listen���ѯ�˵�*****************");
		System.out.println();
		System.out.println("1����ѯ���и赥");
		System.out.println("2������Ŀ��Ų�ѯ");
		System.out.println("3������Ŀ���Ʋ�ѯ");
		System.out.println("4�����û���Ų�ѯ");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				Vector<ListenDTO> v = new Vector<ListenDTO>();
				v = l.findAllListenInfo();
				System.out.println("��Ŀ���"+"\t\t"+"��Ŀ����"+"\t\t"+"�û����");
				for (ListenDTO sd : v)
					System.out.println(sd.getMnumber()+"\t\t"+sd.getMname()+"\t\t"+sd.getUnumber());
				System.out.println();
				break;
		
			case 2:
				Vector<ListenDTO> v1 = new Vector<ListenDTO>();
				System.out.println("��������Ҫ��ѯ����Ŀ��ţ�");
				Scanner input = new Scanner(System.in);
				String findMnumber = input.nextLine();
				v1 = l.findAllListenByMnumber(findMnumber);
				break;
			
			case 3:
				Vector<ListenDTO> v2 = new Vector<ListenDTO>();
				System.out.println("��������Ҫ��ѯ����Ŀ����");
				Scanner input1 = new Scanner(System.in);
				String findname = input1.nextLine();
				v2 = l.findAllListenByName(findname);
				break;
				
			case 4:
				Vector<ListenDTO> v3 = new Vector<ListenDTO>();
				System.out.println("��������Ҫ��ѯ���û����");
				Scanner input2 = new Scanner(System.in);
				String findUnumber = input2.nextLine();
				v2 = l.findAllListenByUnumber(findUnumber);
				break;
				
			case 0:
//				me.listenmenu();
				break;
		}
	}
	
	//����---------------------------------------------------------------------------	
	public void updateu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User����²˵�*****************");
		System.out.println();
		System.out.println("1�������û����");
		System.out.println("2�������û�����");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("������Ҫ���µ��û���ţ�");
				String id = input.nextLine();
				System.out.println("��������º���û���ţ�");
				String id2 = input.nextLine();
				flag = u.updateAllUserByNumber(id2, id);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
			
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("������Ҫ���µ��û�������");
				String name = input1.nextLine();
				System.out.println("��������º���û�������");
				String name2 = input1.nextLine();
				flag = u.updateAllUserByName(name2, name);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
		}
	}
	
	public void updatem() {
		MusicDAO m = new MusicDAO();
		System.out.println("**************Music����²˵�*****************");
		System.out.println();
		System.out.println("1��������Ŀ���");
		System.out.println("2��������Ŀ����");
		System.out.println("3�����¸�������");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("��������Ҫ���µ���Ŀ��ţ�");
				String id = input.nextLine();
				System.out.println("��������Ҫ���º����Ŀ��ţ�");
				String id2 = input.nextLine();
				flag = m.updateMusicByNumber(id2, id);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
				
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("��������Ҫ���µ���Ŀ���ƣ�");
				String name = input1.nextLine();
				System.out.println("��������Ҫ���º����Ŀ���ƣ�");
				String name2 = input1.nextLine();
				flag = m.updateMusicByName(name2, name);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
			
			case 3:
				boolean flag2 = false;
				Scanner input2 = new Scanner(System.in);
				System.out.println("��������Ҫ���µĸ���������");
				String singer = input2.nextLine();
				System.out.println("��������Ҫ���º�ĸ���������");
				String singer2 = input2.nextLine();
				flag = m.updateMusicBySinger(singer2, singer);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
		}
	}
	
	public void updatel() {
		ListenDAO l = new ListenDAO();
		System.out.println("**************Listen����²˵�*****************");
		System.out.println();
		System.out.println("1��������Ŀ���");
		System.out.println("2��������Ŀ����");
		System.out.println("3��������Ŀ���");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("��������Ҫ���µ���Ŀ��ţ�");
				String id = input.nextLine();
				System.out.println("��������Ҫ���º����Ŀ��ţ�");
				String id2 = input.nextLine();
				flag = l.updateListenByid(id2, id);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
				
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("��������Ҫ���µ���Ŀ���ƣ�");
				String name = input1.nextLine();
				System.out.println("��������Ҫ���º����Ŀ���ƣ�");
				String name2 = input1.nextLine();
				flag = l.updateListenByName(name2, name);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
			
			case 3:
				boolean flag2 = false;
				Scanner input2 = new Scanner(System.in);
				System.out.println("��������Ҫ���µ��û���ţ�");
				String number = input2.nextLine();
				System.out.println("��������Ҫ���º���û���ţ�");
				String number2 = input2.nextLine();
				flag = l.updateListenByNumber(number2, number);
				if(flag)
					System.out.println("���³ɹ�");
				else
					System.out.println("����ʧ��");
				break;
		}
	}
	
	//ɾ��---------------------------------------------------------------------------
	public void deleteu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User��ɾ���˵�*****************");
		System.out.println();
		System.out.println("1�����û����ɾ��");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("������Ҫɾ�����û���ţ�");
				String id = input.nextLine();
				flag = u.deleteUserByNumber(id);
				if(flag)
					System.out.println("ɾ���ɹ�");
				else
					System.out.println("ɾ��ʧ��");
				break;
			
			case 0:
				break;
		}
	}
	
	public void deletem() {
		MusicDAO m = new MusicDAO();
		System.out.println("**************Music��ɾ���˵�*****************");
		System.out.println();
		System.out.println("1������Ŀ���ɾ��");
		System.out.println("2������Ŀ����ɾ��");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("������Ҫɾ������Ŀ��ţ�");
				String id = input.nextLine();
				flag = m.deleteMusicByNumber(id);
				if(flag)
					System.out.println("ɾ���ɹ�");
				else
					System.out.println("ɾ��ʧ��");
				break;
			
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("������Ҫɾ������Ŀ���ƣ�");
				String name = input1.nextLine();
				//flag = m.deleteMusicByName(name);
				//if(flag)
					System.out.println("ɾ���ɹ�");
				//else
					System.out.println("ɾ��ʧ��");
		}
	}
	
	public void deletel() {
		ListenDAO l = new ListenDAO();
		System.out.println("**************Listen��ɾ���˵�*****************");
		System.out.println();
		System.out.println("1������Ŀ���ɾ��");
		System.out.println("2������Ŀ����ɾ��");
		System.out.println("3�����û����ɾ��");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt();
		
		switch(choose){
			case 1:
				boolean flag = false;
				Scanner input = new Scanner(System.in);
				System.out.println("������Ҫɾ������Ŀ��ţ�");
				String id = input.nextLine();
				flag = l.deleteListenByNumber(id);
				if(flag)
					System.out.println("ɾ���ɹ�");
				else
					System.out.println("ɾ��ʧ��");
				break;
			
			case 2:
				boolean flag1 = false;
				Scanner input1 = new Scanner(System.in);
				System.out.println("������Ҫɾ������Ŀ��ţ�");
				String name = input1.nextLine();
				flag = l.deleteListenByName(name);
				if(flag)
					System.out.println("ɾ���ɹ�");
				else
					System.out.println("ɾ��ʧ��");
				break;
			
			case 3:
				boolean flag2 = false;
				Scanner input2 = new Scanner(System.in);
				System.out.println("������Ҫɾ�����û���ţ�");
				String id1 = input2.nextLine();
				flag = l.deleteListenByID(id1);
				if(flag)
					System.out.println("ɾ���ɹ�");
				else
					System.out.println("ɾ��ʧ��");
				break;
		}
	}
	
	//����---------------------------------------------------------------------------	
	public void insertu() {
		UserDAO u = new UserDAO();
		System.out.println("**************User�����Ӳ˵�*****************");
		System.out.println();
		System.out.println("1�������û�");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt(); 
		
		switch(choose){
			case 1:
				boolean flag = false;
				Vector<UserDTO> v = new Vector<UserDTO>();
				Scanner input = new Scanner(System.in);
				System.out.println("��������Ҫ��ӵ��û���ţ�");
				String id = input.nextLine();
				System.out.println("��������Ҫ��ӵ��û�������");
				String name = input.nextLine();
				System.out.println("��������Ҫ��ӵ��û��Ա�");
				String sex = input.nextLine();
				System.out.println("��������Ҫ��ӵ��û����䣺");
				String age = input.nextLine();
				flag = u.insertAllUser(id, name, sex, age);
				if (flag)
					System.out.println("���ӳɹ�");
				else
					System.out.println("����ʧ��");
				break;
			
			case 0:
				break;
		}
	}	
	
	public void insertm() {
		System.out.println("**************Music�����Ӳ˵�*****************");
		System.out.println();
		System.out.println("1��������Ŀ");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt(); 
		
		switch(choose){
			case 1:
				MusicDAO m = new MusicDAO();
				boolean flag = false;
				Vector<UserDTO> v = new Vector<UserDTO>();
				Scanner input = new Scanner(System.in);
				System.out.println("��������Ҫ��ӵ���Ŀ��ţ�");
				String id = input.nextLine();
				System.out.println("��������Ҫ��ӵ���Ŀ���ƣ�");
				String name = input.nextLine();
				System.out.println("��������Ҫ��ӵĸ���������");
				String singer = input.nextLine();
				flag = m.insertAllMusic(id, name, singer);
				if (flag)
					System.out.println("���ӳɹ�");
				else
					System.out.println("����ʧ��");
				break;
				
			case 0:
				break;
		}
	}
	
	public void insertl() {
		ListenDAO l = new ListenDAO();
		System.out.println("**************Listen�����Ӳ˵�*****************");
		System.out.println();
		System.out.println("1�����Ӹ赥");
		System.out.println("0��������һ��");
		System.out.println("��ѡ����Ҫ��������ţ�");
		int choose = input.nextInt(); 
		
		switch(choose){
			case 1:
				boolean flag = false;
				Vector<UserDTO> v = new Vector<UserDTO>();
				Scanner input = new Scanner(System.in);
				System.out.println("��������Ҫ��ӵ���Ŀ��ţ�");
				String id = input.nextLine();
				System.out.println("��������Ҫ��ӵ���Ŀ���ƣ�");
				String name = input.nextLine();
				System.out.println("��������Ҫ��ӵ��û���ţ�");
				String id2 = input.nextLine();
				flag = l.insertAllListen(id, name, id2);
				if (flag)
					System.out.println("���ӳɹ�");
				else
					System.out.println("����ʧ��");
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
					System.out.println("�˳�");
					break;
			}
		}while(n!=0);
	}
}
