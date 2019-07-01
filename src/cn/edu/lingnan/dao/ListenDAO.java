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
	
	// ȫ���ѯ--------------------------------------------------
	public Vector<ListenDTO> findAllListenInfo(){
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			System.out.println("��Ŀ���"+"\t\t"+"��Ŀ����"+"\t\t"+"�û����");
			String sql = "select * from listen where IsDelete = 1";
			rs = stmt.executeQuery(sql);
			while(rs.next()){//��������
				ListenDTO l = new ListenDTO();
				l.setMnumber(rs.getString("Mnumber"));
				l.setMname(rs.getString("Mname"));
				l.setUnumber(rs.getString("Unumber"));
				System.out.println(l.getMnumber()+"\t\t"+l.getMname()+"\t\t"+l.getUnumber());
				v.add(l);
			}
			System.out.println("-------------------------");
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return v;
	}
	
	// ͨ����Ŀ��Ų�ѯ--------------------------------------------------
	public Vector<ListenDTO> findAllListenByMnumber(String Mnumber){
		Vector<ListenDTO> v1 = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			String sql = "select * from listen where Mnumber = '"+Mnumber+"' AND IsDelete = 1";
			System.out.println("��Ŀ���"+"\t\t"+"��Ŀ����"+"\t\t"+"�û����");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//��������
				ListenDTO l = new ListenDTO();
				l.setMnumber(rs.getString("Mnumber"));
				l.setMname(rs.getString("Mname"));
				l.setUnumber(rs.getString("Unumber"));
				System.out.println(l.getMnumber()+"\t\t"+l.getMname()+"\t\t"+l.getUnumber());
				v1.add(l);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		System.out.println();
		return v1;
	}
		
	// ͨ����Ŀ���Ʋ�ѯ--------------------------------------------------
	public Vector<ListenDTO> findAllListenByName(String name){
		Vector<ListenDTO> v2 = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			String sql = "select * from listen where Mname = '"+name+"' AND IsDelete = 1";
			System.out.println("��Ŀ���"+"\t\t"+"��Ŀ����"+"\t\t"+"�û����");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//��������
				ListenDTO l = new ListenDTO();
				l.setMnumber(rs.getString("Mnumber"));
				l.setMname(rs.getString("Mname"));
				l.setUnumber(rs.getString("Unumber"));
				System.out.println(l.getMnumber()+"\t\t"+l.getMname()+"\t\t"+l.getUnumber());
				v2.add(l);
			}
			System.out.println("-------------------------");
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		System.out.println();
		return v2;
	}
	
	// ͨ���û���Ų�ѯ--------------------------------------------------
	public Vector<ListenDTO> findAllListenByUnumber(String Unumber){
		Vector<ListenDTO> v2 = new Vector<ListenDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			String sql = "select * from listen where Unumber = '"+Unumber+"' AND IsDelete = 1";
			System.out.println("��Ŀ���"+"\t\t"+"��Ŀ����"+"\t\t"+"�û����");
			rs = stmt.executeQuery(sql);
			while(rs.next()){//��������
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
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		System.out.println();
		return v2;
	}
	
	// ��ѯ�ض��赥---------------------------------------------
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
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// ͨ����Ŀ���ɾ��--------------------------------------------------
	public boolean deleteListenByNumber(String id){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			String sql = "update listen set IsDelete= 1 where Mnumber = '"+id+"'";
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// ͨ����Ŀ����ɾ��--------------------------------------------------
	public boolean deleteListenByName(String name){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			String sql = "update listen set IsDelete= 1 where Mname = '"+name+"'";
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// ͨ���û����ɾ��--------------------------------------------------
	public boolean deleteListenByID(String id1){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			String sql = "update listen set IsDelete= 1 where Mname = '"+id1+"'";
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// ����--------------------------------------------------
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
			stmt = conn.createStatement();//����SQL������ִ��
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// ������Ŀ���---------------------------------------------
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
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// ������Ŀ����---------------------------------------------
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
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}

	// �����û����---------------------------------------------
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
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// �����Ŀ---------------------------------------------
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
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// ���--------------------------------------------------
	public boolean insertListenInfo1(String id, String name, String number, String cancel){
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();//����SQL������ִ��
			String sql = "insert into listen values('"+id+"', '"+name+"', '"+number+"','"+cancel+"')";
			stmt.executeUpdate(sql);
			flag=true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	// �����Ŀ--------------------------------------------------
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
			stmt = conn.createStatement();//����SQL������ִ��
			stmt.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}
}
