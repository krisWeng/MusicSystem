package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.UserDTO;

public class JDBCTest3 {

	public static void main(String[] args) {

		UserDAO u = new UserDAO();
		//-------------------------------------------------------
		System.out.println(u.findUserByNameAndPassword("U01", "aaa"));
	}
}