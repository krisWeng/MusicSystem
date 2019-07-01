<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="aa" uri="/testtags" %>
<%@ taglib prefix="c" uri="/jstlc" %>
<%@ taglib prefix="sql" uri="/jstlsql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<aa:hello/>
	<br><!-- 换行符 -->
	
	<c:set var="a" value="aaa"/>
	<c:out value="${a}"/>
	
	<c:remove var="a"/>
	<c:out value="${a}"/>
	<br>

	<c:catch var="b">
		<%=9/0 %><!-- 异常 -->
	</c:catch>
	<c:out value="${b}"/><!-- 这句话是对异常的反应 -->
	<br>
	
	<%
		String[] str = new String[5];
		str[0] = "aaaaa";
		str[1] = "bbbbb";
		str[2] = "ccccc";
		str[3] = "eeeee";
		str[4] = "fffff";
		request.setAttribute("st", str);
	%>
	<c:out value="${st[2]}"/>
	<br>
	<c:if test="${st[2]='ccccc'}">
		相等！！！（{}放在后面）
	</c:if>
	<br>
	<c:choose>
		<c:when test="${st[2]='ccdcc'}">
			如果相等，出现这句话！！！
		</c:when>
		<c:otherwise>
			如果不等，则出现这句话！！！
		</c:otherwise>
	</c:choose>
	<br>
	<!-- 输出以上变量 -->
	<c:forEach var="c" items="${st}">
		<c:out value="${c}"/>
	</c:forEach>
	<br>
	<c:forEach var="d" begin="1" end="4">
		<c:out value="${d}"/>
	</c:forEach>
	<br>

	<!-- 用一个指定的分隔符对一个字符串进行分割 -->
	<!-- 第一个是要进行分割的字符串，第二个是用什么分割 -->
	<c:forTokens var="e" items="aaa,bbb,ccc,ddd" delims=",">
		<c:out value="${e}"></c:out>
	</c:forTokens>
	<br>
	
	<a href="<c:url value="http://www.qq.com"/>">
		用这个字符串返回
	</a>
	<br>
	
	<c:url var="f" value="http://www.qq.com">
		<c:param name="uname" value="CHEN"></c:param><!-- 可以加参数 -->
	</c:url>
	<a href="${f}">
		用这句话返回
	</a>
	<br>
	
	<c:import url="/ok.html"/>
	<br>
	
	<sql:setDataSource
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/musiclist"
		user="root"
		password="root"
		var="aaa"
	/>
	<sql:query var="result" dataSource="${aaa}" sql="select * from user"/>
	<table border="1"><!-- 按照字段名称取出列的内容 -->
		<c:forEach var="g" items="${result.rows}">
			<tr>
				<td><c:out value="${g.Unumber}"/></td>
				<td><c:out value="${g.Uname}"/></td>
				<td><c:out value="${g.Sex}"/></td>
				<td><c:out value="${g.Age}"/></td>
				<td><c:out value="${g.Password}"/></td>
				<td><c:out value="${g.Superuser}"/></td>
				<td><c:out value="${g.IsDelete}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
	<sql:update dataSource="${aaa}" sql="update user set Password='qwe' where Unumber='U01'"></sql:update>
	<sql:query var="result" dataSource="${aaa}" sql="select * from user"/>
	<table border="1"><!-- 按照字段名称取出列的内容 -->
		<c:forEach var="h" items="${result.rows}">
			<tr>
				<td><c:out value="${h.Unumber}"/></td>
				<td><c:out value="${h.Uname}"/></td>
				<td><c:out value="${h.Sex}"/></td>
				<td><c:out value="${h.Age}"/></td>
				<td><c:out value="${h.Password}"/></td>
				<td><c:out value="${h.Superuser}"/></td>
				<td><c:out value="${h.IsDelete}"/></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>