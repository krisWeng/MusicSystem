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

import cn.edu.lingnan.dto.ListenDTO;
import cn.edu.lingnan.dto.MusicDTO;
import cn.edu.lingnan.util.DataAccess;

public class ListenDAO {
	
	// 全体查询--------------------------------------------------
	public Vector<ListenDTO> findAllListenInfo(){
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"用户编号");
			String sql = "select * from listen where IsDelete = 1";
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				ListenDTO l = new ListenDTO();
				l.setMnumber(rs.getString("Mnumber"));
				l.setMname(rs.getString("Mname"));
				l.setUnumber(rs.getString("Unumber"));
				System.out.println(l.getMnumber()+"\t\t"+l.getMname()+"\t\t"+l.getUnumber());
				v.add(l);
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
	
	// 通过曲目编号查询--------------------------------------------------
	public Vector<ListenDTO> findAllListenByMnumber(String Mnumber){
		Vector<ListenDTO> v1 = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from listen where Mnumber = '"+Mnumber+"' AND IsDelete = 1";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"用户编号");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				ListenDTO l = new ListenDTO();
				l.setMnumber(rs.getString("Mnumber"));
				l.setMname(rs.getString("Mname"));
				l.setUnumber(rs.getString("Unumber"));
				System.out.println(l.getMnumber()+"\t\t"+l.getMname()+"\t\t"+l.getUnumber());
				v1.add(l);
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
		return v1;
	}
		
	// 通过曲目名称查询--------------------------------------------------
	public Vector<ListenDTO> findAllListenByName(String name){
		Vector<ListenDTO> v2 = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from listen where Mname = '"+name+"' AND IsDelete = 1";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"用户编号");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				ListenDTO l = new ListenDTO();
				l.setMnumber(rs.getString("Mnumber"));
				l.setMname(rs.getString("Mname"));
				l.setUnumber(rs.getString("Unumber"));
				System.out.println(l.getMnumber()+"\t\t"+l.getMname()+"\t\t"+l.getUnumber());
				v2.add(l);
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
		return v2;
	}
	
	// 通过用户编号查询--------------------------------------------------
	public Vector<ListenDTO> findAllListenByUnumber(String Unumber){
		Vector<ListenDTO> v2 = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from listen where Unumber = '"+Unumber+"' AND IsDelete = 1";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"用户编号");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//处理结果集
				ListenDTO l = new ListenDTO();
				l.setMnumber(rs.getString("Mnumber"));
				l.setMname(rs.getString("Mname"));
				l.setUnumber(rs.getString("Unumber"));
				System.out.println(l.getMnumber()+"\t\t"+l.getMname()+"\t\t"+l.getUnumber());
				v2.add(l);
			}
			System.out.println("-------------------------");
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
	
	// 查询特定歌单---------------------------------------------
	public boolean findAllListenByNameAndNumber(String _name, String _number){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from listen where Mname = ? and Mnumber = ?");
			prep.setString(1,_name);
			prep.setString(2,_number);
			rs = prep.executeQuery();
			if(rs.first())
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
	
	// 通过曲目编号删除--------------------------------------------------
	public boolean deleteListenByNumber(String id){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "update listen set IsDelete= 1 where Mnumber = '"+id+"'";
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

	// 通过曲目名称删除--------------------------------------------------
	public boolean deleteListenByName(String name){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "update listen set IsDelete= 1 where Mname = '"+name+"'";
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

	// 通过用户编号删除--------------------------------------------------
	public boolean deleteListenByID(String id1){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "update listen set IsDelete= 1 where Mname = '"+id1+"'";
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
	public boolean updateListenInfo(ListenDTO lt){
		boolean flag = false;
		String Mnumber = lt.getUnumber();
		String Mname = lt.getMname();
		String Unumber = lt.getUnumber();
		String sql ="update listen set Mname='"+Mname+"', Unumber='"+Unumber+"' where Mnumber='"+Mnumber+"'";
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
	
	// 更新曲目编号---------------------------------------------
	public boolean updateListenByid(String id, String id2){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("udate listen set Mnumber = ? where Mnumber");
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
	
	// 更新曲目名称---------------------------------------------
	public boolean updateListenByName(String name, String name2){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("udate listen set Mname = ? where Mname = ?");
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

	// 更新用户编号---------------------------------------------
	public boolean updateListenByNumber(String number, String number2){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("udate listen set Unumber = ? where Unumber = ?");
			prep.setString(1,number);
			prep.setString(2,number2);
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
	
	// 添加曲目---------------------------------------------
	public boolean insertAllListen(String id, String name, String id2){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("insert into listen values(?,?,?)");
			prep.setString(1,id);
			prep.setString(2,name);
			prep.setString(3, id2);
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
	public boolean insertListenInfo1(String id, String name, String number, String cancel){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//创建SQL语句对象并执行
			String sql = "insert into listen values('"+id+"', '"+name+"', '"+number+"','"+cancel+"')";
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
	
	// 添加曲目--------------------------------------------------
	public boolean insertListenInfo(ListenDTO lt){
		boolean flag = false;
		String mnumber = lt.getMnumber();
		String mname = lt.getMname();
		String unumber = lt.getUnumber();
		int isdelete = 1;
		String sql ="insert into listen values('"+mnumber+"','"+mname+"','"+unumber+"','"+isdelete+"')";
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
}
