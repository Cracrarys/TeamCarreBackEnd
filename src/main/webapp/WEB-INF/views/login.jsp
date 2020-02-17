<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%> --%>
<%-- <%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-3.4.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>Login</title>
</head>

<body>


	<form action="login" method="post">
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="btnL" value="Login" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>

			<td><a class="nav-link" href="/initUser" style="color: black"><button
						type="button" class="btn btn-link">Créer un utilisateur</button></a></td>
			<td><a class="nav-link" href="/initRole" style="color: black"><button
						type="button" class="btn btn-link">Assigner un rôle</button></a></td>
		</tr>
	</table>




</body>
</html>