<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ListenDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>搜索用户歌单</title>

<link rel="stylesheet" href="text.css">

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

<div class="search-box">
	<form action="findListenServlet">
		<input type="text" name="Listenname" placeholder="请输入曲目名称" required="">	
		<a href="http://localhost:8080/JavaWeb/findListenServlet"><input type="submit" value="搜索"></a>				
	</form>
</div>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>用户歌单</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>歌曲编号</th>
						<th>歌曲名称</th>
						<th>用户编号</th>
					</tr>
				</thead>
						<%
							Vector<ListenDTO> v = new Vector<ListenDTO>();
							v = (Vector<ListenDTO>) session.getAttribute("onelisten");
							Iterator i = v.iterator();
							ListenDTO ld = null;
							while(i.hasNext()){
								ld = (ListenDTO)i.next();
						%>
					<tr>
						<td><%=ld.getMnumber() %></td>
						<td><%=ld.getMname() %></td>
						<td><%=ld.getUnumber() %></td>
					</tr>
					<%
						}
					%>
			</table>
		</div>
	</section>
</section>
</body>
</html>