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

public class ShowUsers extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserDAO u = new UserDAO();
		Vector<UserDTO> v = new Vector<UserDTO>();
		v = u.findAllUserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("users", v);
		resp.sendRedirect("showUsers.jsp");
	}
}
