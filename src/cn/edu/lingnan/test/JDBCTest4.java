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

		// 按曲目名称查询--------------------------------------------------
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		v = l.findAllListenInfo();
		for (ListenDTO sd : v)
			System.out.println(sd.getMname());

		// 按曲目编号查询--------------------------------------------------
		Vector<ListenDTO> v1 = new Vector<ListenDTO>();
		v1 = l.findAllListenInfo();
		for (ListenDTO sd : v1)
			System.out.println(sd.getMnumber());

		// 查询特定音乐---------------------------------------------
		l.findAllListenByNameAndNumber("JULY", "M04");
		System.out.println("存在该音乐");

		// 删除--------------------------------------------------
		boolean flag = false;
//		flag = l.deleteListenById("M02");
//		if (flag)
//			System.out.println("删除成功");
//		else
//			System.out.println("删除失败");

		// 添加--------------------------------------------------
		flag = l.insertListenInfo1("M03", "歌名1", "U01", "0");
		if (flag)
			System.out.println("增加成功");
		else
			System.out.println("增加失败");		
	}
}