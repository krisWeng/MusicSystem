<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.UserDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>ϵͳ��Ӹ���</title>
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
				<h1>��Ӹ���</h1>
			</hgroup>
		</header>
		<div class="content">
			<form action="insertMusicServlet" name="form">
				<table id="myTable" border="0" width="100">
					<thead>
						<tr>
							<th>�������</th>
							<th>��������</th>
							<th>��������</th>
							<th></th>
						</tr>
					</thead>
						<tr>
							<td><input type="text" id="Mnumber" name="Mnumber" placeholder="��Ŀ���" required="required" onBlur="numberCheck()"/></td>
							<td><input type="text" id="Mname" name="Mname" placeholder="��Ŀ����" required="required" /></td>
							<td><input type="text" id="Singer" name="Singer" placeholder="��������" required="required" /></td>
							<td><button type="submit" onClick="return check();" class="btn btn-primary btn-block btn-large">ȷ�����</button></td>
						</tr>
				</table>
			</form>
		</div>
	</section>
</section>

</body>
</html>