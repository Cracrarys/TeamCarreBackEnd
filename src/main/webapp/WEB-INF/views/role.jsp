<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>
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
<title>Role</title>
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
	<h1>Page accueil pour le rôle</h1>
	<form action="Ajout" method="post">

		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idrole"></td>
				<td><select class="custom-select" name="rolename" multiple
					size="1">
						<option>ROLE_Admin</option>
						<option>ROLE_User</option>
				</select></td>
				<td>User<select name="utiID" multiple="multiple">
						<c:forEach items="${listeDesUsers}" var="id">
							<option value="${id.iduser}">${id.username}</option>
						</c:forEach>
				</select></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter un role à ce user" name="action"></td>
		</table>
	</form>

	<form action="All" method="get">

		<table>
			<tr>
				<td><input class="btn btn-info" type="submit"
					value="Liste des roles" name="action"></td>
		</table>
	</form>

	<form action="Supprimer" method="post">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idTache"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-danger" type="submit"
					value="Supprimer une tache" name="action"></td>
		</table>
	</form>
	<form action="Chercher" method="get">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idRole"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-secondary" type="submit"
					value="Chercher un rôle" name="action"></td>
		</table>
	</form>
	<h3>Liste des rôles</h3>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Role</th>
			<th>User</th>


		</tr>
		<c:forEach items="${listeDesRoles}" var="cl">
			<tr>
				<td>${cl.idrole}</td>
				<td>${cl.rolename}</td>
				<td>${cl.user}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>