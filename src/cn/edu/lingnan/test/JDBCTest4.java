package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dao.ListenDAO;
import cn.edu.lingnan.dto.ListenDTO;

public class JDBCTest4 {

	public static void main(String[] args) {

		ListenDAO l = new ListenDAO();

		// ����Ŀ���Ʋ�ѯ--------------------------------------------------
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		v = l.findAllListenInfo();
		for (ListenDTO sd : v)
			System.out.println(sd.getMname());

		// ����Ŀ��Ų�ѯ--------------------------------------------------
		Vector<ListenDTO> v1 = new Vector<ListenDTO>();
		v1 = l.findAllListenInfo();
		for (ListenDTO sd : v1)
			System.out.println(sd.getMnumber());

		// ��ѯ�ض�����---------------------------------------------
		l.findAllListenByNameAndNumber("JULY", "M04");
		System.out.println("���ڸ�����");

		// ɾ��--------------------------------------------------
		boolean flag = false;
//		flag = l.deleteListenById("M02");
//		if (flag)
//			System.out.println("ɾ���ɹ�");
//		else
//			System.out.println("ɾ��ʧ��");

		// ���--------------------------------------------------
		flag = l.insertListenInfo1("M03", "����1", "U01", "0");
		if (flag)
			System.out.println("���ӳɹ�");
		else
			System.out.println("����ʧ��");		
	}
}