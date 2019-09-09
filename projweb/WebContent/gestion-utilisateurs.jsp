<%@include file="/WEB-INF/template/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label>${msg}</label>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Email</th>
				<th>Mot de passe</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${utilisateurs}" var="utilisateur">
				<tr>
					<td>${utilisateur.id}</td>
					<td>${utilisateur.nom}</td>
					<td>${utilisateur.email}</td>
					<td>${utilisateur.password}</td>
					<td><a href="GestionUtilisateurServlet?action=modification&utilisateurId=${utilisateur.id}">Modifier</a> | <a href="GestionUtilisateurServlet?action=suppression&utilisateurId=${utilisateur.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form action=GestionUtilisateurServlet?action=insertion method="post">
		<label for="id"><strong>Id :</strong></label>
		<input type="text" readonly="readonly" placeholder="Id..." name="idTest" id="idTest" value="${userToModify.id}">
		<label for="nom"><strong>Nom :</strong></label>
		<input type="text" placeholder="Nom..." name="nom" value="${userToModify.nom}">>
		<label for="email"><strong>Email :</strong></label>
		<input type="email" placeholder="Email..." name="email" value="${userToModify.email}">>
		<label for="password"><strong>Password :</strong></label>
		<input type="password" placeholder="Mot de passe..." name="password" value="${userToModify.password}">>
		
		<input type="submit" value="Création utilisateur">

	</form>

</body>
</html>
<%@include file="/WEB-INF/template/footer.jsp"%>