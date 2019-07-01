<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,cn.edu.lingnan.dto.ListenDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateListenServlet">
	<table border=1>
		<tr>
			<td>Mnumber</td><td>Mname</td><td>Unumber</td><td></td>
		</tr>
	
		<%
			String Mnumber = request.getParameter("Mnumber");
			Vector<ListenDTO> v = new Vector<ListenDTO>();
			v = (Vector<ListenDTO>) session.getAttribute("alllisten");
			Iterator i = v.iterator();
			ListenDTO ld = null;
			while(i.hasNext()){
				ld = (ListenDTO)i.next();
				if((ld.getMnumber()).equals(Mnumber)){
		%>
		<tr>
			<td><input type="text" readOnly="true" name="Mnumber" value=<%=ld.getMnumber() %>></td>
			<td><input type="text" name="Mname" value=<%=ld.getMname() %>></td>
			<td><input type="text" name="Unumber" value=<%=ld.getUnumber() %>></td>
			<td><input type="submit" value="确认修改"></td>
		</tr>
		<%
				}
			}
		%>
	
	</table>
	
</form>
</body>
</html>