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
				<th>ID</th>
				<th>DESCRIPTION</th>
				<th>PRIX</th>
				<th>DATE D'ACHAT</th>
				<th>ETAT</th>
				<th>ACTIONS</th>
			</tr>
		</thead>


		<tbody>
			<c:forEach items="${users}" var="produit">
				<tr style="border: 1px solid black; padding: 30px;">
					<td style="border: 1px solid black;">${produit.id}</td>
					<td style="border: 1px solid black;">${produit.description}</td>
					<td style="border: 1px solid black;">${produit.prix}</td>
					<td style="border: 1px solid black;">${produit.dateAchat}</td>
					<td style="border: 1px solid black;">${produit.etat}</td>
					<td style="border: 1px solid black;"><a
						href="CrudServlet?action=update&id=${produit.id}">Modifier</a> || <a
						href="CrudServlet?action=delete&id=${produit.id}">Supprimer</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>