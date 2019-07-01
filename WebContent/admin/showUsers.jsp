<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.UserDTO,cn.edu.lingnan.dao.UserDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB2312">
<title>所有用户信息</title>

<link rel="stylesheet" href="text.css">

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
			location.href="deleteUsercheckServlet?arr="+arr;
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
	<form action="findOneUser">
		<input type="text" name="usernumber" placeholder="请输入用户编号" required="">	
		<a href="findOneUser"><input type="submit" value="搜索"></a>				
	</form>
</div>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>用户信息</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th></th>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>权限</th>
					</tr>
				</thead>
					<%
						Vector<UserDTO> v = new Vector<UserDTO>();
						v = (Vector<UserDTO>) session.getAttribute("users");
						Iterator i = v.iterator();
						UserDTO ud = null;
						while(i.hasNext()){
							ud = (UserDTO)i.next();
					%>
					<tr>
						<td>
							<div align="center">
								<input type="checkbox" name="check" value=<%=ud.getUnumber() %>>
							</div>
						</td>
						<td><%=ud.getUnumber() %></td>
						<td><%=ud.getUname() %></td>
						<td><%=ud.getSex() %></td>
						<td><%=ud.getAge() %></td>
						<td><%=ud.getSuperuser() %></td>
					</tr>
					<%
						}
					%>
			</table>
			<input type="button" id="btn1" value="全选" onClick="allcheck();"/>
			<input type="button" id="btn2" value="不选" onClick="allnotcheck();"/>
			<input type="button" id="btn3" value="反选" onClick="backcheck();"/>
			<input type="button" value="批量删除" onClick="deletecheck();"/>
		</div>
	</section>
</section>

</body>
</html>