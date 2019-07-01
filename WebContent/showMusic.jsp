<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MusicDTO,cn.edu.lingnan.dao.MusicDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>���˸赥</title>

<link rel="stylesheet" href="css/text1.css">

<script>
function allcheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0; i<checkObj.length; i++)
		checkObj[i].checked = true;
}

function allnotcheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0; i<checkObj.length; i++)
		checkObj[i].checked = false;
}

function backcheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0; i<checkObj.length; i++)
		if(checkObj[i].checked == true)
			checkObj[i].checked = false;
		else
			checkObj[i].checked = true;
}
function deletecheck(){
	var checkObj = document.getElementsByName("check");
	var arr = [];
	var flag = false;
	for(var i=0; i<checkObj.length; i++){
		if(checkObj[i].checked == true){
			arr.push(checkObj[i].value);
			flag = true;
		}
	}
	alert(arr);
	if(flag=true){
		if(confirm("�Ƿ�ȷ��ɾ����¼��"))
			location.href="deleteMusiccheckServlet?arr="+arr;
	}
	else 
		alert("����ѡ��һ����¼����ɾ��");
}
</script>

</head>
<body>
<header>
	<p>���ֹ���ϵͳ</p>
	<a href="logoutServlet">ע��</a>
	<a href="sorry.jsp">��̨</a>
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
	<form action="findMusicServlet">
		<input type="text" name="Musicname" placeholder="��������Ŀ����" required="">	
		<a href="http://localhost:8080/JavaWeb/findMusicServlet"><input type="submit" value="����"></a>				
	</form>
</div>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>�ҵĸ赥</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th></th>
						<th>�������</th>
						<th>��������</th>
						<th>��������</th>
						<th></th>
					</tr>
				</thead>
				<%
					Vector<MusicDTO> v = new Vector<MusicDTO>();
					v = (Vector<MusicDTO>) session.getAttribute("music");
					Iterator i = v.iterator();
					MusicDTO md = null;
					while(i.hasNext()){
						md = (MusicDTO)i.next();
						if((md.getUnumber()).equals(username)){
				%>
					<tr>
						<td>
							<div align="center">
								<input type="checkbox" name="check" value=<%=md.getMnumber() %>>
							</div>
						</td>
						<td><%=md.getMnumber() %></td>
						<td><%=md.getMname() %></td>
						<td><%=md.getSinger() %></td>
						<td><a href="updateMusicInfo.jsp?Mnumber=<%=md.getMnumber() %>">�޸�</a></td>
					</tr>
					<%
						}}
					%>
					
			</table>
			<input type="button" id="btn1" value="ȫѡ" onClick="allcheck();"/>
			<input type="button" id="btn2" value="��ѡ" onClick="allnotcheck();"/>
			<input type="button" id="btn3" value="��ѡ" onClick="backcheck();"/>
			<input type="button" value="����ɾ��" onClick="deletecheck();"/>
			<a href="http://localhost:8080/JavaWeb/InsertListen.jsp"><input type="button" value="���ظ���"/></a>
		</div>
	</section>
</section>
</body>
</html>