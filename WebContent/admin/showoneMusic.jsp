<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MusicDTO,cn.edu.lingnan.dao.MusicDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>������Ŀ</title>

<link rel="stylesheet" href="text.css">
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
<p>��ӭ�û�
	<%
		  String username = null;
		  username = (String)session.getAttribute("username");
		  out.println(username);  
	%>
</p> 
</aside>

<div class="search-box">
	<form action="findOneMusic">
		<input type="text" name="Musicname" placeholder="��������Ŀ����" required="">	
		<a href="findOneMusic"><input type="submit" value="����"></a>				
	</form>
</div>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>������Ŀ</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>�������</th>
						<th>��������</th>
						<th>��������</th>
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
						<td><a href="updateMusicInfo.jsp?Mnumber=<%=md.getMnumber() %>">�޸�</a></td>
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