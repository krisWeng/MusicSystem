package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ListenDAO;
import cn.edu.lingnan.dto.ListenDTO;

public class FindListenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1、从页面获取想要的数据
		String Unumber = null;
		Unumber = req.getParameter("Listenname");
		System.out.println("要查询的用户编号："+Unumber);
		ListenDAO la = new ListenDAO();
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		v = la.findAllListenByUnumber(Unumber);
		HttpSession s = req.getSession();
		s.setAttribute("onelisten", v);
		resp.sendRedirect("showListenServlet.jsp");
	}

}
