<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.UserDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>������Ϣ</title>

<link rel="stylesheet" href="css/text1.css">

<script src="js/prefixfree.min.js"></script>

</head>
<body>

<header>
	<p>���ֹ���ϵͳ</p>
	<a href="logoutServlet">ע��</a>
	<a href="backstage.jsp">��̨</a>
</header>
<aside>
	<ul>
		<li><a href="http://localhost:8080/JavaWeb/findMusic">�ҵĸ赥</a></li>
		<li><a href="http://localhost:8080/JavaWeb/admin/findAllListen">�û��赥</a></li>
		<li><a href="http://localhost:8080/JavaWeb/findAllMusic">ϵͳ����</a></li>
		<li><a href="http://localhost:8080/JavaWeb/findUser">�ҵ���Ϣ</a></li>
		<li><a href="http://localhost:8080/JavaWeb/admin/findAllUser">�û���Ϣ</a></li>
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
				<h1>�ҵ���Ϣ</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>���</th>
						<th>����</th>
						<th>�Ա�</th>
						<th>����</th>
						<th>����</th>
						<th>Ȩ��</th>
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
						<td><a href="updateUserInfo.jsp?Unumber=<%=ud.getUnumber() %>">�޸�</a></td>
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