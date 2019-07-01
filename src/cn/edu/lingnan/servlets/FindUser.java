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

public class FindUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		UserDAO ua = new UserDAO();
		Vector<UserDTO> v = new Vector<UserDTO>();
		v = ua.findUserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("user", v);
		resp.sendRedirect("showUser.jsp");
	}
}
