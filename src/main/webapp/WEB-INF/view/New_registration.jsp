<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new Registration</title>
</head>

<body>
<%
	HttpSession s = request.getSession(false);
	if(s.getAttribute("id")!=null){
%>
	<h2>New Registration</h2>
	<form action = "newReg" method = "post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type = "text" name = "name"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type = "text" name = "city"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type = "text" name = "email"/></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type = "text" name = "mobile"/></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "Save"/></td>
			</tr>
		</table>
	</form>
	<%
		if(request.getAttribute("msg")!=null){
			out.println(request.getAttribute("msg"));
		}
	%>
	<%} else{
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}%>
</body>

</html>