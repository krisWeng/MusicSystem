<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��̨ҳ��</title>
<link rel="stylesheet" href="text.css">

<script src="js/prefixfree.min.js"></script>
</head>
<body>
	
<header>
	<p>���ֹ���ϵͳ</p>
	<a href="logoutServlet">ע��</a>
	<a href="admin.jsp">ǰ̨</a>
</header>
<aside>
	<ul>
		<li><a href="http://localhost:8080/JavaWeb/admin/showMusics">ϵͳ����</a></li>
		<li><a href="http://localhost:8080/JavaWeb/admin/showUsers">�û���Ϣ</a></li>
	</ul>
</aside>
<p style="text-align: center; font-size: 40px; margin-top: 160px;">��ӭ�����û�
	<%
		  String username = null;
		  username = (String)session.getAttribute("username");
		  out.println(username);  
	%>
</p> 
</html>