package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import cn.edu.lingnan.dto.MusicDTO;
import cn.edu.lingnan.dto.ListenDTO;
import cn.edu.lingnan.dto.UserDTO;

public class DataAccess {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/MusicList?useUnicode=true&amp;characterEncoding=gb2312";
	private static String user = "root";
	private static String password = "root";
	private static Connection conn = null;
//	private static String xmlPath = "database.conf.xml";
//	private static String xsdPath = "database.conf.xsd";
	
	public static Connection getConnection(){
//		if(XmlValidator.validator(xmlPath, xsdPath)){
//			HashMap<String,String> hm = XmlParser.parser(xmlPath);
//			driver = hm.get("driver");
//			url = hm.get("url");
//			user = hm.get("user");
//			password = hm.get("password");
//		}
		try {
			Class.forName(driver);//注册驱动
			conn = DriverManager.getConnection//获取数据库连接
					(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库jar包加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接获取失败");
			e.printStackTrace();
		}
		System.out.println("数据库连接获取成功");
		return conn;
	}
	
	public static void cloaseconn(Connection conn,Statement stmt,PreparedStatement prep,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(stmt!=null){
				stmt.close();
				stmt = null;
			}
			if(prep!=null){
				prep.close();
				prep = null;
			}
			if(conn!=null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
