package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		//1����ҳ���ȡ��Ҫ������
		String name = null;
		String password = null;
		name = req.getParameter("username");//username��Unumber
		password = req.getParameter("password");
		System.out.println("�˺�"+"\t\t"+"����");
		System.out.println(name+"\t\t"+password);
		System.out.println("-------------------------");
		
		//2�����ú�̨��ҵ���߼�ȥ�ж�����˺ź������Ƿ�����Ҷ�Ӧ
		UserDAO u = new UserDAO();
		int superValue = u.findUserByNameAndPassword(name, password);
		System.out.println("Ȩ��");
		System.out.println(superValue);
		System.out.println("-------------------------");
		HttpSession s = req.getSession();
		s.setAttribute("superValue", superValue);
		s.setAttribute("username",name);
		
		//3�����ݽ��ȥ����Ӧ��ҳ��
		if(superValue==1)
			resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/other/authority.jsp");
	}
}