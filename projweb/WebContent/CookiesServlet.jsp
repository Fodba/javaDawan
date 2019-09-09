<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table
		style="border: 1px solid black; border-collapse: collapse; margin: 10px;">
		<thead>
			<tr style="border: 1px solid black;">
				<th>Id</th>
				<th>Nom</th>
				<th>Email</th>
				<th>Mot de passe</th>
				<th>Actions</th>
			</tr>
		</thead>


		<tbody>
			<c:forEach items="${cookies}" var="user">
				<tr style="border: 1px solid black; padding: 30px;">
					<td style="border: 1px solid black;">${user}</td>
<%-- 					<td style="border: 1px solid black;">${user.id}</td> --%>
<%-- 					<td style="border: 1px solid black;">${user.nom}</td> --%>
<%-- 					<td style="border: 1px solid black;">${user.email}</td> --%>
<%-- 					<td style="border: 1px solid black;">${user.password}</td> --%>
<!-- 					<td style="border: 1px solid black;"><a -->
<%-- 						href="CrudServlet?action=update&id=${user.id}">Modifier</a> || <a --%>
<%-- 						href="CrudServlet?action=delete&id=${user.id}">Supprimer</a></td> --%>
				</tr>
			</c:forEach>

		</tbody>
		
		<div>${cook}</div>

	</table>
</body>
</html>