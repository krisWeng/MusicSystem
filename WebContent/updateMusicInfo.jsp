<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MusicDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>修改歌曲信息</title>
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
				<h1>修改歌曲信息</h1>
			</hgroup>
		</header>
		<div class="content">
			<form action="updateMusicServlet">
				<table id="myTable" border="0" width="100%">
					<thead>
						<tr>
							<th>歌曲编号</th>
							<th>歌曲名称</th>
							<th>歌手姓名</th>
							<th></th>
						</tr>
					</thead>
						<%
							String Mnumber = request.getParameter("Mnumber");
							Vector<MusicDTO> v = new Vector<MusicDTO>();
							v = (Vector<MusicDTO>) session.getAttribute("music");
							Iterator i = v.iterator();
							MusicDTO md = null;
							while(i.hasNext()){
								md = (MusicDTO)i.next();
								if((md.getMnumber()).equals(Mnumber)){
						%>						
						<tr>
							<td><input type="text" readOnly="true" name="Mnumber" value=<%=md.getMnumber() %>></td>
							<td><input type="text" name="Mname" value=<%=md.getMname() %>></td>
							<td><input type="text" name="Singer" value=<%=md.getSinger() %>></td>
							<td><input type="submit" value="确认修改"></div></td>
						</tr>
						<%
							}} 
						%>
				</table>
			</form>
		</div>
	</section>
</section>

</body>
</html>