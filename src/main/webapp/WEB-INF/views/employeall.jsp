<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Liste employe</title>
</head>
<body>


	<h1>Liste des employés</h1>

	<br>
	<table class="table table-striped table-dark">
		<tr>
			<th scope="col">id employe</th>
			<th scope="col">nom employé</th>
			<th scope="col">prenom employé</th>
			<th scope="col">sexe employé</th>
			<th scope="col">adresse employé</th>
			<th scope="col">statut employé</th>
			<th scope="col">salaire employé</th>
			<th scope="col">type de contrat</th>
			<th scope="col">date d'entrée</th>
			<th scope="col">date de sortie</th>

		</tr>
		<c:forEach items="${listeEmploye}" var="cl">
			<tr>
				<td>${cl.idEmploye}</td>
				<td>${cl.nomEmploye}</td>
				<td>${cl.prenomEmploye}</td>
				<td>${cl.sexeEmploye}</td>
				<td>${cl.adresseEmploye}</td>
				<td>${cl.statutEmploye}</td>
				<td>${cl.salaireEmploye}</td>
				<td>${cl.typeContratEmploye}</td>
				<td>${cl.dateEntreeEmploye}</td>
				<td>${cl.dateSortieEmploye}</td>

			</tr>
		</c:forEach>
	</table>
	<a class="nav-link" href="/Employe/init" style="color: white"><button
			type="button" class="btn btn-secondary">Modification des
			employés</button></a>
	<a class="nav-link" href="/Employe/Chercher" style="color: white"><button
			type="button" class="btn btn-secondary">Trouver un employé</button></a>
	<a class="nav-link" href="/" style="color: white"><button
			type="button" class="btn btn-Dark">Accueil</button></a>
</body>
</html>