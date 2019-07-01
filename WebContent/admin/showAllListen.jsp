<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ListenDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�����û��赥</title>

<link rel="stylesheet" href="text.css">

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

<div class="search-box">
	<form action="findListenServlet">
		<input type="text" name="Listenname" placeholder="�������û����" required="">	
		<a href="http://localhost:8080/JavaWeb/findListenServlet"><input type="submit" value="����"></a>				
	</form>
</div>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>�û��赥</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>�������</th>
						<th>��������</th>
						<th>�û����</th>
					</tr>
				</thead>
						<%
							Vector<ListenDTO> v = new Vector<ListenDTO>();
							v = (Vector<ListenDTO>) session.getAttribute("alllisten");
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