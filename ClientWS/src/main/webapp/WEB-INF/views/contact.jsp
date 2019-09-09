<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
</head>
<body>

	<h1>Liste des contacts</h1>
	<table border="1">
		<TR>
			<c:if test="${contact == null}">
				<th></th>
			</c:if>
			<c:if test="${contact != null}">
				<th>Id</th>
				<th>Version</th>
			</c:if>
			<th>Prenom</th>
			<th>Nom</th>
			<th>Telephone</th>
			<th>Adresse</th>
			<th>Action</th>
		</TR>
		<c:if test="${contact != null}">
			<tr>
				<td>${contact.id}</td>
				<td>${contact.version}</td>
				<td>${contact.prenom}</td>
				<td>${contact.nom}</td>
				<td>${contact.telephone}</td>
				<td>${contact.adresse}</td>
				<td><a href="contact/modification/${contact.id}">Modifier</a> <a
					href="contact/suppression/${contact.id}">Supprimer</a></td>
			</tr>
		</c:if>
		
		<c:forEach var="c" items="${contacts}">
			<tr>
				<td><a href="contact/${c.id}">Détails</a></td>
				<td>${c.prenom}</td>
				<td>${c.nom}</td>
				<td>${c.telephone}</td>
				<td>${c.adresse}</td>
				<td><a href="contact/modification/${c.id}">Modifier</a> <a
					href="contact/suppression/${c.id}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>


	<h3>Ajout / Modif</h3>
	<form:form action="contact/inserer" method="post"
		modelAttribute="contactForm">
		<form:label path="prenom">Prénom :</form:label>
		<form:input path="prenom" />
		<br />
		<form:label path="nom">Nom : </form:label>
		<form:input path="nom" />
		<br />
		<form:label path="telephone">Téléphone : </form:label>
		<form:input path="telephone" />
		<br />
		<form:label path="adresse">Adresse :</form:label>
		<form:input path="adresse" />
		<br />
		<form:hidden path="id" />
		<form:hidden path="version" />
		<input type="submit" value="Sauvegarder" />
	</form:form>

	<p style="color: red;">${msg}</p>
</body>
</html>