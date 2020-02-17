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
<title>Plat</title>
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
	<h1>Page accueil pour le plat</h1>
	<form action="Ajout" method="post">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idPlat"></td>
				<td><input type="text" placeholder="Nom" name="nomPlat"></td>
				<td><select class="custom-select" name="vegan" size="2">
						<option>true</option>
						<option>false</option>
				</select></td>
				<td><input type="text" placeholder="Prix" name="prixPlat"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter un plat" name="action"></td>
		</table>
	</form>

	<form action="All" method="get">

		<table>
			<tr>
				<td><input class="btn btn-info" type="submit"
					value="Liste des plats" name="action"></td>
		</table>
	</form>

	<form action="Supprimer" method="post">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idPlat"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-danger" type="submit"
					value="Supprimer un plat" name="action"></td>
		</table>
	</form>
	<form action="Chercher" method="get">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idPlat"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-secondary" type="submit"
					value="Chercher un plat" name="action"></td>
		</table>
	</form>
	<h1>Liste des plats</h1>
	<table class="table table-striped">
		<tr>
			<th>Id du plat</th>
			<th>Nom du plat</th>
			<th>Vegan</th>
			<th>Prix</th>


		</tr>
		<c:forEach items="${listePlat}" var="cl">
			<tr>
				<td>${cl.idPlat}</td>
				<td>${cl.nomPlat}</td>
				<td>${cl.vegan}</td>
				<td>${cl.prixPlat}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>