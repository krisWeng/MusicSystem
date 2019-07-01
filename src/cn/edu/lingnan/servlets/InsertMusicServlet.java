package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.MusicDAO;
import cn.edu.lingnan.dto.MusicDTO;

public class InsertMusicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、从页面获取想要的数据,3个
		String mnumber = null;
		String mname = null;
		String singer = null;
		int isdelete = 0;
		mnumber = req.getParameter("Mnumber");
		mname = req.getParameter("Mname");
		mname = new String(mname.getBytes("ISO-8859-1"),"GB2312");
		singer = req.getParameter("Singer");
		System.out.println("上传曲目：");
		System.out.println("曲目编号"+"\t\t"+"曲目名称"+"\t\t"+"歌手姓名");
		System.out.println(mnumber+"\t\t"+mname+"\t\t"+singer);
		System.out.println("-------------------------");
		
		//2、调用后台的业务逻辑去判断
		MusicDAO m = new MusicDAO();
		MusicDTO mt = new MusicDTO();
		mt.setMnumber(mnumber);
		mt.setMname(mname);
		mt.setSinger(singer);
		mt.setIsDeleted(isdelete);
		boolean flag = m.insertMusicInfo(mt);
		
		//3、根据结果去到相应的页面
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/findAllMusic");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}
