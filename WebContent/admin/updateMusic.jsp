<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MusicDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�޸ĸ�����Ϣ</title>
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
<p>��ӭ�û�
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
				<h1>�޸ĸ�����Ϣ</h1>
			</hgroup>
		</header>
		<div class="content">
			<form action="updateMusic">
				<table id="myTable" border="0" width="100%">
					<thead>
						<tr>
							<th>�������</th>
							<th>��������</th>
							<th>��������</th>
							<th></th>
						</tr>
					</thead>
						<%
							String Mnumber = request.getParameter("Mnumber");
							Vector<MusicDTO> v = new Vector<MusicDTO>();
							v = (Vector<MusicDTO>) session.getAttribute("musics");
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
							<td><input type="submit" value="ȷ���޸�"></div></td>
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