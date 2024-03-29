<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.UserDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>个人信息</title>

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
		<li><a href="http://localhost:8080/JavaWeb/admin/findAllListen">用户歌单</a></li>
		<li><a href="http://localhost:8080/JavaWeb/findAllMusic">系统歌曲</a></li>
		<li><a href="http://localhost:8080/JavaWeb/findUser">我的信息</a></li>
		<li><a href="http://localhost:8080/JavaWeb/admin/findAllUser">用户信息</a></li>
	</ul>
<p>欢迎用户
	<%
		  String username = null;
		  username = (String)session.getAttribute("username");
		  out.println(username);  
	%>
</p> 
</aside>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>我的信息</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>密码</th>
						<th>权限</th>
						<th></th>
					</tr>
				</thead>
				<%
					Vector<UserDTO> v = new Vector<UserDTO>();
					v = (Vector<UserDTO>) session.getAttribute("user");
					Iterator i = v.iterator();
					UserDTO ud = null;
					while(i.hasNext()){
						ud = (UserDTO)i.next();
						if((ud.getUnumber()).equals(username)){
				%>
					<tr>
						<td><%=ud.getUnumber() %></td>
						<td><%=ud.getUname() %></td>
						<td><%=ud.getSex() %></td>
						<td><%=ud.getAge() %></td>
						<td><%=ud.getPassword() %></p></td>
						<td><%=ud.getSuperuser() %></td>
						<td><a href="updateUserInfo.jsp?Unumber=<%=ud.getUnumber() %>">修改</a></td>
					</tr>
				<%
					}}
				%>		
			</table>
		</div>
	</section>
</section>
</body>
</html>