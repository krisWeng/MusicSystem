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

public class UpdateListenServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mnumber = req.getParameter("Mnumber");
		String Mname = req.getParameter("Mname");
		String Unumber = req.getParameter("Unumber");
		System.out.println(Mnumber+"	"+Mname+"	"+Unumber);
		ListenDTO lt = new ListenDTO();
		ListenDAO la = new ListenDAO();
		lt.setMnumber(Mnumber);
		lt.setMname(Mname);
		lt.setUnumber(Unumber);
		boolean flag = la.updateListenInfo(lt);
		Vector<ListenDTO> v = new Vector<ListenDTO>();
		v = la.findAllListenInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alllisten", v);
		resp.sendRedirect("showAllListen.jsp");
	}
}
