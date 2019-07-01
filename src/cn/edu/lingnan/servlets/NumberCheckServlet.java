package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.UserDAO;

public class NumberCheckServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String Unumber = req.getParameter("Unumber");
		System.out.println("Unumber:	"+Unumber);
		UserDAO ua = new UserDAO();
		boolean flag = ua.findUserByNumber(Unumber);
		if(flag)
			resp.getWriter().print("true");
	}
}
