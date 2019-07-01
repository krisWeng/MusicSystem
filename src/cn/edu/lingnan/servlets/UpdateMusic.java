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

public class UpdateMusic extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String Mnumber = req.getParameter("Mnumber");
		String Mname = req.getParameter("Mname");
		String Singer = req.getParameter("Singer");
		System.out.println("修改后：");
		System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
		System.out.println(Mnumber+"\t\t"+Mname+"\t\t"+Singer);
		System.out.println("-------------------------");
		MusicDTO mt = new MusicDTO();
		MusicDAO ma = new MusicDAO();
		mt.setMnumber(Mnumber);
		mt.setMname(Mname);
		mt.setSinger(Singer);
		boolean flag = ma.updateMusicInfo(mt);
		Vector<MusicDTO> v = new Vector<MusicDTO>();
		v = ma.findAllMusicInfo();
		HttpSession s = req.getSession();
		s.setAttribute("musics", v);
		resp.sendRedirect("showMusics.jsp");
	}
}
