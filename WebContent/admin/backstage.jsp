<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>后台页面</title>
<link rel="stylesheet" href="text.css">

<script src="js/prefixfree.min.js"></script>
</head>
<body>
	
<header>
	<p>音乐管理系统</p>
	<a href="logoutServlet">注销</a>
	<a href="admin.jsp">前台</a>
</header>
<aside>
	<ul>
		<li><a href="http://localhost:8080/JavaWeb/admin/showMusics">系统歌曲</a></li>
		<li><a href="http://localhost:8080/JavaWeb/admin/showUsers">用户信息</a></li>
	</ul>
</aside>
<p style="text-align: center; font-size: 40px; margin-top: 160px;">欢迎超级用户
	<%
		  String username = null;
		  username = (String)session.getAttribute("username");
		  out.println(username);  
	%>
</p> 
</html>