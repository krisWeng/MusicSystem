package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.ListenDAO;
import cn.edu.lingnan.dto.ListenDTO;

public class InsertListenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1、从页面获取想要的数据,3个
		String mnumber = null;
		String mname = null;
		String unumber = null;
		int isdelete = 0;
		mnumber = req.getParameter("Mnumber");
		mname = req.getParameter("Mname");
		unumber = req.getParameter("Unumber");
		mname = new String(mname.getBytes("ISO-8859-1"),"GB2312");
		System.out.println("下载曲目：");
		System.out.println("歌曲编号"+"\t\t"+"歌曲名称"+"\t\t"+"用户编号");
		System.out.println(mnumber+"\t\t"+mname+"\t\t"+unumber);
		System.out.println("-------------------------");
		
		//2、调用后台的业务逻辑去判断
		ListenDAO l = new ListenDAO();
		ListenDTO lt = new ListenDTO();
		lt.setMnumber(mnumber);
		lt.setMname(mname);
		lt.setUnumber(unumber);
		lt.setIsDeleted(isdelete);
		boolean flag = l.insertListenInfo(lt);
		
		//3、根据结果去到相应的页面
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/findMusic");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}
