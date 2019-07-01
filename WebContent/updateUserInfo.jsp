<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,cn.edu.lingnan.dto.UserDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
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
				<h1>修改个人信息</h1>
			</hgroup>
		</header>
		<div class="content">
			<form action="updateUserServlet">
				<table id="myTable" border="0" width="100%">
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
							String Unumber = request.getParameter("Unumber");
							Vector<UserDTO> v = new Vector<UserDTO>();
							v = (Vector<UserDTO>) session.getAttribute("user");
							Iterator i = v.iterator();
							UserDTO ud = null;
							while(i.hasNext()){
								ud = (UserDTO)i.next();
								if((ud.getUnumber()).equals(Unumber)){
						%>
						<tr>
							<td><input style="width: 100px;" type="text" readOnly="true" name="Unumber" value=<%=ud.getUnumber() %>></td>
							<td><input style="width: 100px;" type="text" name="Uname" value=<%=ud.getUname() %>></td>
							<td><input style="width: 100px;" type="text" name="Sex" value=<%=ud.getSex() %>></td>
							<td><input style="width: 100px;" type="text" name="Age" value=<%=ud.getAge() %>></td>
							<td><input style="width: 100px;" type="text" name="Password" value=<%=ud.getPassword() %>></td>
							<td><input style="width: 100px;" type="text" readOnly="true" name="Superuser" value=<%=ud.getSuperuser() %>></td>
							<td><input type="submit" value="确认修改"></div></td>
						</tr>
						<%}} %>
				</table>
			</form>
		</div>
	</section>
</section>


</body>
</html>