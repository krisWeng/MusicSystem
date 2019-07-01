<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MusicDTO,cn.edu.lingnan.dao.MusicDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>搜索曲目</title>

<link rel="stylesheet" href="text.css">
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
<p>欢迎用户
	<%
		  String username = null;
		  username = (String)session.getAttribute("username");
		  out.println(username);  
	%>
</p> 
</aside>

<div class="search-box">
	<form action="findOneMusic">
		<input type="text" name="Musicname" placeholder="请输入曲目名称" required="">	
		<a href="findOneMusic"><input type="submit" value="搜索"></a>				
	</form>
</div>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>搜索曲目</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>歌曲编号</th>
						<th>歌曲名称</th>
						<th>歌手姓名</th>
						<th></th>
					</tr>
				</thead>
				<%
					Vector<MusicDTO> v = new Vector<MusicDTO>();
					v = (Vector<MusicDTO>) session.getAttribute("amusic");
					Iterator i = v.iterator();
					MusicDTO md = null;
					while(i.hasNext()){
						md = (MusicDTO)i.next();
				%>
					<tr>
						<td><%=md.getMnumber() %></td>
						<td><%=md.getMname() %></td>
						<td><%=md.getSinger() %></td>
						<td><a href="updateMusicInfo.jsp?Mnumber=<%=md.getMnumber() %>">修改</a></td>
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