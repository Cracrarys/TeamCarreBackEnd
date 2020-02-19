<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Menu</title>
</head>
<body>
	<table>
		<tr>
			<td><a class="nav-link" href="/" style="color: black"><button
						type="button" class="btn btn-link">Home</button></a></td>
			<td><a class="nav-link" href="/initPlat" style="color: black"><button
						type="button" class="btn btn-link">Plat</button></a></td>
			<td><a class="nav-link" href="/initMenu" style="color: black"><button
						type="button" class="btn btn-link">Menu</button></a></td>
			<td><a class="nav-link" href="/initReservation"
				style="color: black"><button type="button" class="btn btn-link">Réservation</button></a></td>
			<td><a class="nav-link" href="/initClient" style="color: black"><button
						type="button" class="btn btn-link">Client</button></a></td>
			<td><a class="nav-link" href="/initUser" style="color: black"><button
						type="button" class="btn btn-link">Créer un utilisateur</button></a></td>
			<td><a class="nav-link" href="/initRole" style="color: black"><button
						type="button" class="btn btn-link">Assigner un rôle</button></a></td>
			<td><a class="nav-link" href="/logout" style="color: black"><button
						type="button" class="btn btn-link">Logout</button></a></td>
		</tr>
	</table>

	<h3>Le menu recherché</h3>
	<table class="table table-striped">
		<tr>
			<th>Id du menu</th>
			<th>Nom du menu</th>
			<th>Prix</th>
			<th>Plats</th>
		</tr>

		<tr>
			<td>${leMenu.idMenu}</td>
			<td>${leMenu.nomMenu}</td>
			<td>${leMenu.prixMenu}</td>
			<td>${leMenu.plat}</td>
		</tr>
	</table>
</body>
</html>