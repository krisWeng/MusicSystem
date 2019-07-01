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
		//1、从页面获取想要的数据
		String name = null;
		String password = null;
		name = req.getParameter("username");//username是Unumber
		password = req.getParameter("password");
		System.out.println("账号"+"\t\t"+"密码");
		System.out.println(name+"\t\t"+password);
		System.out.println("-------------------------");
		
		//2、调用后台的业务逻辑去判断这个账号和密码是否存在且对应
		UserDAO u = new UserDAO();
		int superValue = u.findUserByNameAndPassword(name, password);
		System.out.println("权限");
		System.out.println(superValue);
		System.out.println("-------------------------");
		HttpSession s = req.getSession();
		s.setAttribute("superValue", superValue);
		s.setAttribute("username",name);
		
		//3、根据结果去到相应的页面
		if(superValue==1)
			resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/other/authority.jsp");
	}
}