<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<form action = "verifycredenial" method = "post">
		<table>
			<tr>
				<td>Id</td>
				<td><input type = "text" name = "id"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type = "text" name = "password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value = "login"/></td>
			</tr>
		</table>
	</form>
	
	<%
		if(request.getAttribute("error")!=null){
			out.println(request.getAttribute("error"));
		}
	%>
</body>
</html>