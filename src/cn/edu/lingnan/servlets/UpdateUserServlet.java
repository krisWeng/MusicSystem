package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.UserDTO;

public class UpdateUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String Unumber = req.getParameter("Unumber");
		String Uname = req.getParameter("Uname");
		String Sex = req.getParameter("Sex");
		String Age = req.getParameter("Age");
		String Password = req.getParameter("Password");
		String Superuser = req.getParameter("Superuser");
		System.out.println("�޸ĺ�");
		System.out.println("���"+"\t"+"����"+"\t"+"�Ա�"+"\t"+"����"+"\t"+"����"+"\t"+"Ȩ��");
		System.out.println(Unumber+"\t"+Uname+"\t"+Sex+"\t"+Age+"\t"+Password+"\t"+Superuser);
		System.out.println("-------------------------");
		
		UserDTO ut = new UserDTO();
		UserDAO ua = new UserDAO();
		ut.setUnumber(Unumber);
		ut.setUname(Uname);
		ut.setSex(Sex);
		ut.setAge(Integer.parseInt(Age));
		ut.setPassword(Password);
		ut.setSuperuser(Integer.parseInt(Superuser));
		boolean flag = ua.updateUserInfo(ut);
		Vector<UserDTO> v = new Vector<UserDTO>();
		v = ua.findUserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("user", v);
		resp.sendRedirect("showUser.jsp");
	}
}
