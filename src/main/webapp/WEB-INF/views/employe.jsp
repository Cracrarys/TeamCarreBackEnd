<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Employe</title>
</head>

<!-- <nav id="navbar-example3" class="navbar navbar-light bg-dark"> -->
<!--   <a class="navbar-brand" href="#">Navbar</a> -->
  <nav class="nav nav-pills flex-column">
    <a class="nav-link" href="#item-1">Ressources humaines</a>
    <nav class="nav nav-pills flex-column">
      <a class="nav-link ml-3 my-1" href="Employe">Modification Employé</a>
      <a class="nav-link ml-3 my-1" href="Employe">Liste des employés</a>
    </nav>
    <a class="nav-link" href="#item-2">Fournitures</a>
    <nav class="nav nav-pills flex-column">
      <a class="nav-link ml-3 my-1" href="#item-1-1">Formulaire d'emprunt</a>
      <a class="nav-link ml-3 my-1" href="#item-1-2">Liste des fournitures</a>
      </nav>
    <a class="nav-link" href="#item-3">Document RH</a>
    <nav class="nav nav-pills flex-column">
    </nav>
  </nav>
</nav>

<div data-spy="scroll" data-target="#navbar-example3" data-offset="0">
  <h4 id="item-1">Ressources humaines</h4>
  <p>...</p>
  <h5 id="item-1-1">Item 1-1</h5>
  <p>...</p>
  <h5 id="item-1-2">Item 2-2</h5>
  <p>...</p>
  <h4 id="item-2">Item 2</h4>
  <p>...</p>
  <h4 id="item-3">Item 3</h4>
  <p>...</p>
  <h5 id="item-3-1">Item 3-1</h5>
  <p>...</p>
  <h5 id="item-3-2">Item 3-2</h5>
  <p>...</p>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-dark"> <a
	class="navbar-brand" href="/index" style="color: lime">Gestion de salle</a>
<button class="navbar-toggler" type="button" data-toggle="collapse"
	data-target="#navbarSupportedContent"
	aria-controls="navbarSupportedContent" aria-expanded="false"
	aria-label="Toggle navigation">
	<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a class="nav-link" href="/index"
			style="color: green">Accueil <span class="sr-only">(current)</span></a>
		</li>
		<li class="nav-item"><a class="nav-link" href="/User/all"
			style="color: green">User</a></li>
	<li class="nav-item"><a class="nav-link" href="/client1/all"
			style="color: green">Clients</a></li>
		<li class="nav-item"><a class="nav-link" href="/plat1/all"
			style="color: green">Plats</a></li>
		<li class="nav-item"><a class="nav-link" href="/menu1/all"
			style="color: green">Menus</a></li>
		<li class="nav-item"><a class="nav-link" href="/resa1/all"
			style="color: green">Reservations</a></li>


	</ul>
	<form class="form-inline my-2 my-lg-0">
		<input class="form-control mr-sm-2" type="search" placeholder="Search"
			aria-label="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>
</div>
</nav>
<body>

</body>
</html>