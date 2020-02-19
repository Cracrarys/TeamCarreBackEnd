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
<title>Utilisateur</title>
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
				style="color: black"><button type="button" class="btn btn-link">RÃ©servation</button></a></td>
			<td><a class="nav-link" href="/initClient" style="color: black"><button
						type="button" class="btn btn-link">Client</button></a></td>
			<td><a class="nav-link" href="/initUser" style="color: black"><button
						type="button" class="btn btn-link">CrÃ©er un utilisateur</button></a></td>
			<td><a class="nav-link" href="/initRole" style="color: black"><button
						type="button" class="btn btn-link">Assigner un rÃ´le</button></a></td>
			<td><a class="nav-link" href="/logout" style="color: black"><button
						type="button" class="btn btn-link">Logout</button></a></td>
		</tr>
	</table>

	<h3>Page accueil pour l'utilisateur</h3>
	<!-- 	<form action="Ajout" method="post"> -->
	<!-- 		<table> -->
	<!-- 			<tr> -->

	<!-- 				<td><input type="text" name="iduser" placeholder="Id"></td> -->
	<!-- 				<td><input type="text" name="username" placeholder="login"></td> -->
	<!-- 				<td><input type="text" name="password" placeholder="mdp"></td> -->
	<!-- 				<td><select class="custom-select" name="activated" multiple -->
	<!-- 					size="1"> -->
	<!-- 						<option>true</option> -->
	<!-- 						<option>false</option> -->
	<!-- 				</select></td> -->
	<!-- 				<td><input class="btn btn-primary" type="submit" -->
	<!-- 					value="Ajouter un utilisateur" name="action"></td> -->

	<!-- 			</tr> -->

	<!-- 		</table> -->
	<!-- 	</form> -->

	<form action="Ajout" method="post">
		<div class="row">

			<div class="form-group col-md-3">
				<label for="iduser">Le numÃ©ro identifiant</label><br> <input
					type="text" name="iduser" placeholder="Identifiant">
			</div>
			<div class="form-group col-md-3">
				<label for="iduser">Le login</label><br> <input type="text"
					name="username" placeholder="Login">
			</div>
			<div class="form-group col-md-3">
				<label for="iduser">Le mot de passe</label><br> <input
					type="text" name="password" placeholder="Mot de passe">
			</div>
			<div class="form-group">
				<label for="activated">Activation</label><br> <select
					class="form-control" id="activated" name="activated">
					<option>true</option>
					<option>false</option>
				</select>
			</div>
			<div class="form-group">
				<input class="btn btn-primary" type="submit"
					value="Ajouter un utilisateur" name="action">
			</div>
		</div>

	</form>
	<br>
	<form action="Supprimer" method="post">
		<table>
			<tr>

				<td><input type="text" name="iduser"
					placeholder="Identifiant Ã  supprimer"></td>
				<td><input class="btn btn-danger" type="submit"
					value="Supprimer un utilisateur" name="action"></td>
			</tr>
		</table>
	</form>
	<form action="Chercher" method="get">
		<table>
			<tr>
				<td><input type="text" placeholder="Identifiant Ã  chercher"
					name="idUser"></td>
				<td><input class="btn btn-secondary" type="submit"
					value="Chercher un utilisateur" name="action"></td>
		</table>
	</form>
	<br>
	<form action="All" method="get">
		<input class="btn btn-info" type="submit"
			value="Afficher tous les utilisateurs" name="action"><br>
		<b>Liste des utilisateurs</b>

		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Login</th>

			</tr>
			<c:forEach items="${listeDesUsers}" var="mat">
				<tr>
					<td>${mat.iduser}</td>
					<td>${mat.username}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>