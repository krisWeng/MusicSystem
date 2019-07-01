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

import cn.edu.lingnan.dto.MusicDTO;
import cn.edu.lingnan.util.DataAccess;

public class MusicDAO {

	// 全体查询--------------------------------------------------
	public Vector<MusicDTO> findAllMusicInfo() {
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from music where IsDelete = 1";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				MusicDTO m = new MusicDTO();
				m.setMnumber(rs.getString("Mnumber"));
				m.setMname(rs.getString("Mname"));
				m.setSinger(rs.getString("Singer"));
				System.out.println(m.getMnumber()+"\t\t"+m.getMname()+"\t\t"+m.getSinger());
//				m.setIsDeleted(rs.getInt("IsDeleted"));
				v.add(m);
			}
			System.out.println("-------------------------");
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
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
	
	// 查询--------------------------------------------------
	public Vector<MusicDTO> findMusicInfo() {
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select user.Unumber,music.Mnumber,music.Mname,Singer "
					+ "from music,listen,user "
					+ "where user.Unumber=listen.Unumber and listen.Mnumber=music.Mnumber and music.IsDelete = 1";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				MusicDTO m = new MusicDTO();
				m.setUnumber(rs.getString("Unumber"));
				m.setMnumber(rs.getString("Mnumber"));
				m.setMname(rs.getString("Mname"));
				m.setSinger(rs.getString("Singer"));
//				m.setIsDeleted(rs.getInt("IsDeleted"));
				v.add(m);
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
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
	
	// 全体查询--------------------------------------------------
	public Vector<MusicDTO> findMusicByNumber(String Number) {
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from music,listen where IsDelete = 1 and Mnumber='"+Number+"'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				MusicDTO m = new MusicDTO();
				m.setMnumber(rs.getString("Mnumber"));
				m.setMname(rs.getString("Mname"));
				m.setSinger(rs.getString("Singer"));
//				m.setIsDeleted(rs.getInt("IsDeleted"));
				v.add(m);
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
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
	public Vector<MusicDTO> findAllMusicByNumber(String id) {
		boolean flag = true;
		Vector<MusicDTO> v1 = new Vector<MusicDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from music where Mnumber = '"+id+"' AND IsDelete = 1";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				MusicDTO m = new MusicDTO();
				m.setMnumber(rs.getString("Mnumber"));
				m.setMname(rs.getString("Mname"));
				m.setSinger(rs.getString("Singer"));
				System.out.println(m.getMnumber()+"\t\t"+m.getMname()+"\t\t"+m.getSinger());
				v1.add(m);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		if(flag=false)
			System.out.println("查无此曲！");
		System.out.println();
		return v1;
	}

	// 通过曲目名称查询--------------------------------------------------
	public Vector<MusicDTO> findMusicByName(String Mname) {
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from music where IsDelete = 1 and Mname='"+Mname+"'";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				MusicDTO m = new MusicDTO();
				m.setMnumber(rs.getString("Mnumber"));
				m.setMname(rs.getString("Mname"));
				m.setSinger(rs.getString("Singer"));
				System.out.println(m.getMnumber()+"\t\t"+m.getMname()+"\t\t"+m.getSinger());
				v.add(m);
			}
			System.out.println("-------------------------");
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
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
	
	// 通过曲目名称查询--------------------------------------------------
	public boolean findAllMusicByName(String name) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from music where Mname = '"+name+"' AND IsDelete = 1";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				MusicDTO m = new MusicDTO();
				m.setMnumber(rs.getString("Mnumber"));
				m.setMname(rs.getString("Mname"));
				m.setSinger(rs.getString("Singer"));
				System.out.println(m.getMnumber()+"\t\t"+m.getMname()+"\t\t"+m.getSinger());
				flag = true;
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		}
		System.out.println();
		return flag;
	}
		
	// 通过歌手姓名查询--------------------------------------------------
	public Vector<MusicDTO> findAllMusicBySinger(String singer) {
		Vector<MusicDTO> v2 = new Vector<MusicDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "select * from music where Singer = '"+singer+"' AND IsDelete = 1";
			System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 处理结果集
				MusicDTO m = new MusicDTO();
				m.setMnumber(rs.getString("Mnumber"));
				m.setMname(rs.getString("Mname"));
				m.setSinger(rs.getString("Singer"));
				System.out.println(m.getMnumber()+"\t\t"+m.getMname()+"\t\t"+m.getSinger());
				v2.add(m);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
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
	
	// 查询特定曲目---------------------------------------------
	public boolean findAllMusicByNameAndNumber(String _name, String _number) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from music where Mname = ? and Mnumber = ?");
			prep.setString(1, _name);
			prep.setString(2, _number);
			rs = prep.executeQuery();
			if (rs.first())
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (prep != null) {
					prep.close();
					prep = null;
				}
				if (conn != null) {
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

	// 删除----------------------------------------------------------
	public boolean deleteMusicByName(String name) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();// 创建SQL语句对象并执行
			String sql = "update music set Isdelete=0 where Mname ='" + name + "'";
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
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
	public boolean deleteMusicByNumber(String Number){//根据number删除记录
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
			//怎么删除M01这首歌
			String sql1 = "select * from listen where Mnumber = '"+Number+"'";
			String sql2 = null;
			rs1 = stmt1.executeQuery(sql1);
			String id = null;
			//int num = 0;
			HashSet<String> hs = new HashSet<String>(); 
			//找出需要删除的用户，记录ID
			while(rs1.next()){
				id = rs1.getString(2);
				sql2 = "select count(*) as num from listen where Unumber = '"+id+"'";
				rs2 = stmt2.executeQuery(sql2);
				rs2.next();
				//num = Integer.parseInt(rs2.getString(num));
				//if(num==1)
					hs.add(id);
			}
			conn.setAutoCommit(false);
			//开始删除
			stmt1.executeUpdate("update listen set IsDelete= 0 where Mnumber = '"+Number+"'");
			//stmt1.executeUpdate("update user set IsDelete= 0 where Unumber = '"+id+"'");
			Iterator<String> it = hs.iterator();
			while(it.hasNext()){
				stmt1.executeUpdate("update music set IsDelete= 0 where Mnumber = '"+Number+"'");
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
	
	// 添加曲目信息--------------------------------------------------
	public boolean insertAllMusic(String id, String name, String singer){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("insert into music values(?,?,?)");
			prep.setString(1,id);
			prep.setString(2,name);
			prep.setString(3,singer);
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
	
	// 添加曲目--------------------------------------------------
	public boolean insertMusicInfo(MusicDTO mt){
		boolean flag = false;
		String mnumber = mt.getMnumber();
		String mname = mt.getMname();
		String singer = mt.getSinger();
		int isdelete = 1;
		String sql ="insert into music values('"+mnumber+"','"+mname+"','"+singer+"','"+isdelete+"')";
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
	public boolean updateMusicByNumber(String id, String id2) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("update music set Mnumber= ? where Mnumber= ?");
			prep.setString(1, id);
			prep.setString(2, id2);
			prep.executeUpdate();
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (prep != null) {
					prep.close();
					prep = null;
				}
				if (conn != null) {
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
	public boolean updateMusicByName(String name, String name2) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("update music set Mname= ? where Mname= ?");
			prep.setString(1, name);
			prep.setString(2, name2);
			prep.executeUpdate();
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (prep != null) {
					prep.close();
					prep = null;
				}
				if (conn != null) {
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

	// 更新歌手姓名---------------------------------------------
	public boolean updateMusicBySinger(String singer, String singer2) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("update music set Singer= ? where Singer= ?");
			prep.setString(1, singer);
			prep.setString(2, singer2);
			prep.executeUpdate();
				flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}

				if (prep != null) {
					prep.close();
					prep = null;
				}
				if (conn != null) {
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
	public boolean updateMusicInfo(MusicDTO mt){
		boolean flag = false;
		String Mnumber = mt.getMnumber();
		String Mname = mt.getMname();
		String Singer = mt.getSinger();
		String sql ="update music set Mname='"+Mname+"', Singer='"+Singer+"' where Mnumber='"+Mnumber+"'";
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