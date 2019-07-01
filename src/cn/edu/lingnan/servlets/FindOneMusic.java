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

public class FindOneMusic extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1����ҳ���ȡ��Ҫ������
		String Mname = null;
		Mname = req.getParameter("Musicname");
		System.out.println("Ҫ��ѯ�ĸ������ƣ�"+Mname);
		MusicDAO ma = new MusicDAO();
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		v = ma.findMusicByName(Mname);
		HttpSession s = req.getSession();
		s.setAttribute("amusic", v);
		resp.sendRedirect("showoneMusic.jsp");
	}

}
