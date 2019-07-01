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

public class DeleteUsercheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		UserDAO ua = new UserDAO();
		for(String a : arr) {
			String[] b = a.split(",");
			for(String c : b)
				ua.deleteUserByNumber(c);
			System.out.println("É¾³ý"+a+"³É¹¦");
			System.out.println("-------------------------");
		}
		Vector<UserDTO> v = new Vector<UserDTO>();
		v = ua.findAllUserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("users", v);
		resp.sendRedirect("showUsers.jsp");
	}
}
