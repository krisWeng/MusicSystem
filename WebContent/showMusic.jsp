<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MusicDTO,cn.edu.lingnan.dao.MusicDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>个人歌单</title>

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
		if(confirm("是否确认删除记录？"))
			location.href="deleteMusiccheckServlet?arr="+arr;
	}
	else 
		alert("至少选择一条记录进行删除");
}
</script>

</head>
<body>
<header>
	<p>音乐管理系统</p>
	<a href="logoutServlet">注销</a>
	<a href="sorry.jsp">后台</a>
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
	<form action="findMusicServlet">
		<input type="text" name="Musicname" placeholder="请输入曲目名称" required="">	
		<a href="http://localhost:8080/JavaWeb/findMusicServlet"><input type="submit" value="搜索"></a>				
	</form>
</div>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>我的歌单</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th></th>
						<th>歌曲编号</th>
						<th>歌曲名称</th>
						<th>歌手姓名</th>
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
						<td><a href="updateMusicInfo.jsp?Mnumber=<%=md.getMnumber() %>">修改</a></td>
					</tr>
					<%
						}}
					%>
					
			</table>
			<input type="button" id="btn1" value="全选" onClick="allcheck();"/>
			<input type="button" id="btn2" value="不选" onClick="allnotcheck();"/>
			<input type="button" id="btn3" value="反选" onClick="backcheck();"/>
			<input type="button" value="批量删除" onClick="deletecheck();"/>
			<a href="http://localhost:8080/JavaWeb/InsertListen.jsp"><input type="button" value="下载歌曲"/></a>
		</div>
	</section>
</section>
</body>
</html>