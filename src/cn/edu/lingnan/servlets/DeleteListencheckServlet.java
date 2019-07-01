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

public class DeleteListencheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		ListenDAO la = new ListenDAO();
		for(String a : arr) {
			String[] b = a.split(",");
			for(String c : b)
				la.deleteListenByNumber(c);
			System.out.println("É¾³ý"+a+"³É¹¦");
			System.out.println("-------------------------");
		}
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		v = la.findAllListenInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alllistenServlet", v);
		resp.sendRedirect("showAllListenServlet.jsp");
	}
}
