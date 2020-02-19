<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="jquery-3.4.1.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>Trouver un formulaire</title>
</head>
<span class="border-top">
<nav class="navbar navbar-expand-lg navbar-light bg-dark"> <a
	class="navbar-brand" href="" style="color: white">Gestion des ressources humaines</a>
<button class="navbar-toggler" type="button" data-toggle="collapse"
	data-target="#navbarSupportedContent"
	aria-controls="navbarSupportedContent" aria-expanded="false"
	aria-label="Toggle navigation">
	<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a class="nav-link" href="/"
			style="color: white">Accueil <span class="sr-only">(current)</span></a>
		</li>
		 <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
          Secteur Employés
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Employe/init">Modification</a>
          <a class="dropdown-item" href="/Employe/All">Liste des Employés</a>
          <a class="dropdown-item" href="/Employe/find">Trouver un Employé</a>
        </div>
      </li>

				 <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
          Fournitures
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Fourniture/init">Demande d'emprunt</a>
          <a class="dropdown-item" href="/Fourniture/All">Liste des Fournitures</a>
          <a class="dropdown-item" href="/Fourniture/find">Trouver une Fourniture</a>
        </div>
      </li>
				 <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
          Document RH
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Document/init">Demande de Document</a>
      <a class="dropdown-item" href="/Document/All">Liste des demandes acceptées </a>
            <a class="dropdown-item" href="/Document/All2">Liste des demandes en cours </a>
          <a class="dropdown-item" href="/Document/find">Trouver une demande</a>
        </div>
      </li>

	 <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
         Utilisateur
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/User/init">Modification</a>
          <a class="dropdown-item" href="/User/All">Liste des Utilisateurs</a>
          <a class="dropdown-item" href="/User/find">Trouver un Utilisateur</a>
        </div>
      </li>


	</ul>
	<form class="form-inline my-2 my-lg-0">
		<input class="form-control mr-sm-2" type="search" placeholder="Search"
			aria-label="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>
</div>
</nav>
</span>
<body>

<h1>Recherche de formulaire</h1>

<form action="Chercher" method="get">
		<table class="table table-striped table-dark">
			<tr>
				<td><input type="text" placeholder="Id" name="idEmploye"></td>
		</table>
		<table>
			<tr>
				<td><input class="btn btn-info" type="submit"
					value="Chercher un forumulaire" name="action"></td>
		</table>
	</form>
</body>
</html>