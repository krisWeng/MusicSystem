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

public class FindUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1、从页面获取想要的数据
		String Unumber = null;
		Unumber = req.getParameter("usernumber");
		System.out.println("要查询的用户编号："+Unumber);
		UserDAO ua = new UserDAO();
		Vector<UserDTO> v = new Vector<UserDTO>();
		v = ua.findAllUserByNumber(Unumber);
		HttpSession s = req.getSession();
		s.setAttribute("oneuser", v);
		resp.sendRedirect("showUserServlet.jsp");
	}

}
