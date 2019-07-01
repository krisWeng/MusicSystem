package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.MusicDAO;
import cn.edu.lingnan.dto.MusicDTO;

public class DeleteMusiccheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		MusicDAO ma = new MusicDAO();
		for(String a : arr) {
			String[] b = a.split(",");
			for(String c : b)
				ma.deleteMusicByNumber(c);
			System.out.println("É¾³ý"+a+"³É¹¦");
			System.out.println("-------------------------");
		}
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		v = ma.findMusicInfo();
		HttpSession s = req.getSession();
		s.setAttribute("music", v);
		resp.sendRedirect("showMusic.jsp");
	}
}
