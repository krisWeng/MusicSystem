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
		//1����ҳ���ȡ��Ҫ������,3��
		String mnumber = null;
		String mname = null;
		String unumber = null;
		int isdelete = 0;
		mnumber = req.getParameter("Mnumber");
		mname = req.getParameter("Mname");
		unumber = req.getParameter("Unumber");
		mname = new String(mname.getBytes("ISO-8859-1"),"GB2312");
		System.out.println("������Ŀ��");
		System.out.println("�������"+"\t\t"+"��������"+"\t\t"+"�û����");
		System.out.println(mnumber+"\t\t"+mname+"\t\t"+unumber);
		System.out.println("-------------------------");
		
		//2�����ú�̨��ҵ���߼�ȥ�ж�
		ListenDAO l = new ListenDAO();
		ListenDTO lt = new ListenDTO();
		lt.setMnumber(mnumber);
		lt.setMname(mname);
		lt.setUnumber(unumber);
		lt.setIsDeleted(isdelete);
		boolean flag = l.insertListenInfo(lt);
		
		//3�����ݽ��ȥ����Ӧ��ҳ��
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/findMusic");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}
