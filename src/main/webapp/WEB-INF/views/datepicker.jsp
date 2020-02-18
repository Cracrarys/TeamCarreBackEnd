<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
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
<title>Client</title>
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
						type="button" class="btn btn-link">CrÃ©er un utilisateur</button></a></td>
			<td><a class="nav-link" href="/initRole" style="color: black"><button
						type="button" class="btn btn-link">Assigner un rÃ´le</button></a></td>
			<td><a class="nav-link" href="/logout" style="color: black"><button
						type="button" class="btn btn-link">Logout</button></a></td>
		</tr>
	</table>
	<h1>Page accueil pour l'employe</h1>
	<form action="Ajout" method="post">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idClient"></td>
				<td><input type="text" placeholder="Nom" name="nomClient"></td>
				<td><input type="text" placeholder="Telephone" name="numClient"></td>
				<td>RÃ©servation<select name="revID" multiple="multiple">
						<c:forEach items="${listeReservation}" var="id">
							<option value="${id.idReservation}">${id.idReservation}</option>
						</c:forEach>
				</select></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-primary" type="submit"
					value="Ajouter un employe" name="action"></td>
		</table>
	</form>
	<form action="Update" method="post">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idClient"></td>
				<td><input type="text" placeholder="Nom" name="nomClient"></td>
				<td><input type="text" placeholder="Telephone" name="numClient"></td>
				<td>RÃ©servation<select name="revID" multiple="multiple">
						<c:forEach items="${listeReservation}" var="id">
							<option value="${id.idReservation}">${id.idReservation}</option>
						</c:forEach>
				</select></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-success" type="submit"
					value="Editer un employe" name="action"></td>
		</table>
	</form>
	<form action="All" method="get">

		<table>
			<tr>
				<td><input class="btn btn-info" type="submit"
					value="Liste des employes" name="action"></td>
		</table>
	</form>

	<form action="Supprimer" method="post">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idClient"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-danger" type="submit"
					value="Supprimer un employe" name="action"></td>
		</table>
	</form>

	<form action="Chercher" method="get">
		<table>
			<tr>
				<td><input type="text" placeholder="Id" name="idClient"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-secondary" type="submit"
					value="Chercher un employe" name="action"></td>
		</table>
	</form>

	<form action="ChercherNom" method="get">
		<table>
			<tr>
				<td><input type="text" placeholder="nom" name="nomClient"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-secondary" type="submit"
					value="Chercher un employe par nom" name="action"></td>
		</table>
	</form>
	<h1>Liste des employes</h1>
	<table class="table table-striped">
		<tr>
			<th>Id du employe</th>
			<th>Nom du employe</th>
			<th>NumÃ©ro</th>
			<th>RÃ©servation</th>


		</tr>
		<c:forEach items="${listeClient}" var="cl">
			<tr>
				<td>${cl.idClient}</td>
				<td>${cl.nomClient}</td>
				<td>${cl.numClient}</td>
				<td>${cl.reservation}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>