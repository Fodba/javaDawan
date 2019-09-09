<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Home</title>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
</head>
<body>


	<h3>Ajout / Modif</h3>
	<form:form action="saveProduct" method="post"
		modelAttribute="productForm">
		<form:label path="description">Description :</form:label>
		<form:input path="description" />
		<br />
		<form:label path="price">Prix : </form:label>
		<form:input path="price" />
		<br />
		<form:label path="purchaseDate">Date d'achat : </form:label>
		<form:input path="purchaseDate" />
		<br />
		<form:label path="state">Etat (VG,G,B) :</form:label>
		<form:input path="state" />
		<br />
		<form:hidden path="id" />
		<form:hidden path="version" />
		<input type="submit" value="Sauvegarder" />
	</form:form>



	<h3>Claculette</h3>
	<a href="calculette/testsoap">Appel de service web</a>
	<h3>CONTACTS</h3>
	<a href="contact">Liste des contacts</a>

	<h1>Liste des produits</h1>
	<table border="1">
		<TR>
			<th>Description</th>
			<th>Prix</th>
			<th>Date d'achat</th>
			<th>Action</th>
		</TR>
		<c:forEach var="p" items="${products}">
			<tr>
				<td>${p.description}</td>
				<td><fmt:formatNumber value="${p.price}" maxFractionDigits="2" />
				</td>
				<td><fmt:formatDate value="${p.purchaseDate}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="modification/${p.id}">Modifier</a> <a
					href="suppression/${p.id}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

	<p style="color: red;">${msg}</p>
</body>
</html>