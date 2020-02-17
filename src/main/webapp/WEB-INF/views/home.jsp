<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<title>Home</title>
</head>
<body>

	<table>
		<tr>
			<td><a class="nav-link" href="/" style="color: black"><button
						type="button" class="btn btn-link">Home</button></a></td>
			<td><a class="nav-link" href="/initEmploye" style="color: black"><button
						type="button" class="btn btn-link">Employe</button></a></td>
			<td><a class="nav-link" href="/initDocument"
				style="color: black"><button type="button" class="btn btn-link">Document</button></a></td>
			<td><a class="nav-link" href="/initFourniture"
				style="color: black"><button type="button" class="btn btn-link">Fourniture</button></a></td>
			<td><a class="nav-link" href="/initFormulaire"
				style="color: black"><button type="button" class="btn btn-link">Formulaire</button></a></td>
			<td><a class="nav-link" href="/initUser" style="color: black"><button
						type="button" class="btn btn-link">Créer un utilisateur</button></a></td>
			<td><a class="nav-link" href="/initRole" style="color: black"><button
						type="button" class="btn btn-link">Assigner un rôle</button></a></td>
			<td><a class="nav-link" href="/logout" style="color: black"><button
						type="button" class="btn btn-link">Logout</button></a></td>
		</tr>
	</table>
	<br>
	<P>Il est: ${serverTime}.</P>
	<p>Bienvenue sur le site de réservation de salle</p>
</body>
</html>
