package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.MusicDAO;
import cn.edu.lingnan.dto.MusicDTO;

public class FindMusic extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		MusicDAO ma = new MusicDAO();
		MusicDTO mt = new MusicDTO();
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		v = ma.findMusicInfo();
		HttpSession s = req.getSession();
		s.setAttribute("music", v);
		resp.sendRedirect("showMusic.jsp");
	}
}
