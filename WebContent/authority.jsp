<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>普通用户首页</title>
<link rel="stylesheet" href="css/text1.css">

<script src="js/prefixfree.min.js"></script>
</head>
<body>
<header>
	<p>音乐管理系统</p>
	<a href="logoutServlet">注销</a>
	<a href="backstage.jsp">后台</a>
</header>
<aside>
	<ul>
		<li><a href="http://localhost:8080/JavaWeb/findMusic">我的歌单</a></li>
		<li><a href="sorry.jsp">用户歌单</a></li>
		<li><a href="http://localhost:8080/JavaWeb/findAllMusic">系统歌曲</a></li>
		<li><a href="http://localhost:8080/JavaWeb/findUser">我的信息</a></li>
		<li><a href="sorry.jsp">用户信息</a></li>
	</ul>
</aside>
<p style="text-align: center; font-size: 40px; margin-top: 160px;">欢迎普通用户
	<%
		  String username = null;
		  username = (String)session.getAttribute("username");
		  out.println(username);  
	%>
</p> 

</body>
</html>