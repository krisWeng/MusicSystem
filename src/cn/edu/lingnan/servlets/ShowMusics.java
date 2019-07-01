package cn.edu.lingnan.servlets;

import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.MusicDAO;
import cn.edu.lingnan.dto.MusicDTO;

public class ShowMusics extends HttpServlet {
	
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		MusicDAO m = new MusicDAO();
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		v = m.findAllMusicInfo();
		HttpSession s = req.getSession();
		s.setAttribute("musics", v);
		resp.sendRedirect("showMusics.jsp");
	}
}
