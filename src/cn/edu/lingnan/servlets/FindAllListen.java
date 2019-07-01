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

public class FindAllListen extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ListenDAO l = new ListenDAO();
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		v = l.findAllListenInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alllisten", v);
		resp.sendRedirect("showAllListen.jsp");
	}
}
