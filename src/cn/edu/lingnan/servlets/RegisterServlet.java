package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.UserDTO;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、从页面获取想要的数据,6个
		String unumber = null;
		String uname = null;
		String sex = null;
		int age = 0;
		String password = null;
		int superuser = 2;
		int isdelete = 1;
		unumber = req.getParameter("Unumber");
		uname = req.getParameter("username");
		sex = req.getParameter("sex");
		age = Integer.parseInt(req.getParameter("age"));
		password = req.getParameter("password");
		System.out.println("用户编号"+"\t"+"用户姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"密码"+"\t"+"权限"+"\t"+"删除标识");
		System.out.println(unumber+"\t"+uname+"\t"+sex+"\t"+age+"\t"+password+"\t"+superuser+"\t"+isdelete);
		System.out.println("-------------------------");
		
		//2、调用后台的业务逻辑去判断这个账号和密码是否存在且对应
		UserDAO u = new UserDAO();
		UserDTO ut = new UserDTO();
		ut.setUnumber(unumber);
		ut.setUname(uname);
		ut.setSex(sex);
		ut.setAge(age);
		ut.setPassword(password);
		ut.setSuperuser(superuser);
		ut.setIsDeleted(isdelete);
		boolean flag = u.InsertUserInfo(ut);
		
		//3、根据结果去到相应的页面
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/index.html");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}
}
