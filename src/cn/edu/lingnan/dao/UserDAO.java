package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.lingnan.dto.UserDTO;
import cn.edu.lingnan.util.DataAccess;

public class UserDAO {
	
	// 全体查询--------------------------------------------------
	public Vector<UserDTO> findAllUserInfo(){
		Vector<UserDTO> v = new Vector<UserDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			System.out.println("编号"+"\t\t"+"姓名"+"\t\t"+"性别"+"\t\t"+"年龄"+"\t\t"+"权限");
			String sql = "select * from user where IsDelete = 1";
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				UserDTO u = new UserDTO();
				u.setUnumber(rs.getString("Unumber"));
				u.setUname(rs.getString("Uname"));
				u.setSex(rs.getString("Sex"));
				u.setAge(rs.getInt("Age"));
//				u.setPassword(rs.getString("Password"));
				u.setSuperuser(rs.getInt("Superuser"));
				System.out.println(u.getUnumber()+"\t\t"+u.getUname()+"\t\t"+u.getSex()+"\t\t"+u.getAge()+"\t\t"+u.getSuperuser());
				v.add(u);
			}
			System.out.println("-------------------------");
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
				}
					
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return v;
	}
	
	// 个人查询--------------------------------------------------
	public Vector<UserDTO> findUserInfo(){
		Vector<UserDTO> v = new Vector<UserDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select user.Unumber,Uname,Sex,Age,Password,Superuser from user where IsDelete = 1";
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				UserDTO u = new UserDTO();
				u.setUnumber(rs.getString("Unumber"));
				u.setUname(rs.getString("Uname"));
				u.setSex(rs.getString("Sex"));
				u.setAge(rs.getInt("Age"));
				u.setPassword(rs.getString("Password"));
				u.setSuperuser(rs.getInt("Superuser"));
				v.add(u);
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
				}
					
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return v;
	}
	
	// 通过用户编号查询查询--------------------------------------------------
	public Vector<UserDTO> findAllUserByNumber(String id){
		Vector<UserDTO> v1 = new Vector<UserDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from user where Unumber = '"+id+"' AND IsDelete = 1";
			System.out.println("编号"+"\t\t"+"姓名"+"\t\t"+"性别"+"\t\t"+"年龄"+"\t\t"+"权限");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				UserDTO u = new UserDTO();
				u.setUnumber(rs.getString("Unumber"));
				u.setUname(rs.getString("Uname"));
				u.setSex(rs.getString("Sex"));
				u.setAge(rs.getInt("Age"));
				u.setSuperuser(rs.getInt("Superuser"));
				System.out.println(u.getUnumber()+"\t\t"+u.getUname()+"\t\t"+u.getSex()+"\t\t"+u.getAge()+"\t\t"+u.getSuperuser());
				v1.add(u);
			}
			System.out.println("-------------------------");
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
				}
					
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		System.out.println();
		return v1;
	}
	
	// 通过用户姓名查询查询--------------------------------------------------
	public Vector<UserDTO> findAllUserByName(String name){
		Vector<UserDTO> v2 = new Vector<UserDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from user where Uname = '"+name+"' AND IsDelete = 1";
			System.out.println("用户编号"+"\t\t"+"用户姓名"+"\t\t"+"性别"+"\t\t"+"年龄");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				UserDTO u = new UserDTO();
				u.setUnumber(rs.getString("Unumber"));
				u.setUname(rs.getString("Uname"));
				u.setSex(rs.getString("Sex"));
				u.setAge(rs.getInt("Age"));
				v2.add(u);
				System.out.println(u.getUnumber()+"\t\t"+u.getUname()+"\t\t"+u.getSex()+"\t\t"+u.getAge());
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
				}
					
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		System.out.println();
		return v2;
	}
	
	// 查询特定用户---------------------------------------------
	public boolean findAllUserByNameAndNumber(String _name, String _number){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from user where Uname = ? AND Unumer = ?");
			prep.setString(1,_name);
			prep.setString(2,_number);
			prep.executeQuery();
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
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
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// 删除--------------------------------------------------
	public boolean deleteUserById(String id){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "delete from user where Unumber ='"+id+"'";
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {	
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// 多表删除--------------------------------------------------
	public boolean deleteUserByNumber(String Number){//根据number删除记录
		boolean flag = false;
		Connection conn = null;
		Statement stmt1 = null;
		Statement stmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			conn = DataAccess.getConnection();
			stmt1 = conn.createStatement();//创建SQL语句对象并执行
			stmt2 = conn.createStatement();//创建SQL语句对象并执行
			//怎么删除U01这一用户
			String sql1 = "select * from listen where Unumber = '"+Number+"' and Isdelete=1";
			String sql2 = null;
			rs1 = stmt1.executeQuery(sql1);
			String id = null;
			//int num = 0;
			HashSet<String> hs = new HashSet<String>(); 
			//找出需要删除的歌曲，记录ID
			while(rs1.next()){
				id = rs1.getString(2);
				sql2 = "select count(*) as num from listen where Mnumber = '"+id+"' and Isdelete=1";
				rs2 = stmt2.executeQuery(sql2);
				rs2.next();
				//num = Integer.parseInt(rs2.getString(num));
				//if(num==1)
					hs.add(id);
			}
			conn.setAutoCommit(false);
			//开始删除
			stmt1.executeUpdate("update listen set IsDelete= 0 where Unumber = '"+Number+"'");
			stmt1.executeUpdate("update user set IsDelete= 0 where Unumber = '"+Number+"'");
			Iterator<String> it = hs.iterator();
			while(it.hasNext()){
				stmt1.executeUpdate("update music set IsDelete= 0 where Mnumber = '"+id+"'");
				it.next();
			}
			conn.commit();
			conn.setAutoCommit(true);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {	
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean deleteAll(){
		boolean flag = false;
		
		return flag;
	}
	
	// 添加用户信息--------------------------------------------------
	public boolean insertAllUser(String id, String name, String sex, String age){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("insert into user values(?,?,?,?)");
			prep.setString(1,id);
			prep.setString(2,name);
			prep.setString(3, sex);
			prep.setString(4, age);
			prep.executeUpdate();
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
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
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// 添加--------------------------------------------------
	public boolean insertUserInfo(String id, String name, String sex, String age){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "insert into user values('"+id+"', '"+name+"', '"+sex+"', '"+age+"')";
			stmt.executeUpdate(sql);
			flag=true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {	
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}	
	
	// 注册添加--------------------------------------------------
	public boolean InsertUserInfo(UserDTO ut){
		boolean flag = false;
		String unumber = ut.getUnumber();
		String uname = ut.getUname();
		String sex = ut.getSex();
		int age = ut.getAge();
		String password = ut.getPassword();
		int superuser = 2;
		int isdelete = 1;
		String sql ="insert into user values('"+unumber+"','"+uname+"','"+sex+"','"+age+"','"+password+"','"+superuser+"','"+isdelete+"')";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {	
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// 更新--------------------------------------------------
	public boolean updateUserInfo(UserDTO ut){
		boolean flag = false;
		String Unumber = ut.getUnumber();
		String Uname = ut.getUname();
		String Sex = ut.getSex();
		int Age = ut.getAge();
		String Password = ut.getPassword();
		String sql ="update user set Uname='"+Uname+"', Sex='"+Sex+"', Age='"+Age+"', Password='"+Password+"' where Unumber='"+Unumber+"'";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {	
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 键盘输入更新用户编号--------------------------------------------------
	public boolean updateAllUserByNumber(String id, String id2){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("update user set Unumber= ? where Unumber= ?");
			prep.setString(1,id);
			prep.setString(2,id2);
			prep.executeUpdate();
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
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
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 键盘输入更新用户姓名---------------------------------------------------
	public boolean updateAllUserByName(String name, String name2){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("update user set Uname= ? where Uname= ?");
			prep.setString(1,name);
			prep.setString(2,name2);
			prep.executeUpdate();
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
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
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 更新用户编号--------------------------------------------------
	public boolean updateUserInfo(String id2, String id){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "update user set Unumber='"+id2+"' where Unumber='"+id+"'";
			stmt.executeUpdate(sql);
			flag=true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {	
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// 更新用户姓名--------------------------------------------------
	public boolean updateUserInfo1(String name2, String name){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "update user set Uname='"+name2+"' where Uname='"+name+"'";
			stmt.executeUpdate(sql);
			flag=true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {	
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
				if(conn!=null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 登录时判断该用户的账号密码是否正确---------------------------------------------
	public int findUserByNameAndPassword(String _name, String _password){
		int superValue = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from user where Unumber = ? and Password = ? and IsDelete = 1");
			prep.setString(1,_name);
			prep.setString(2,_password);
			rs = prep.executeQuery();
			if(rs.first()){
				superValue = Integer.parseInt(rs.getString("Superuser"));
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
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
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return superValue;
	}


	// 登录时判断该用户的账号是否存在---------------------------------------------
	public boolean findUserByNumber(String number){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from user where Unumber = ? and IsDelete = 1");
			prep.setString(1,number);
			rs = prep.executeQuery();
			if(rs.first())
				flag =  true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
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
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		return flag;
	}
}
