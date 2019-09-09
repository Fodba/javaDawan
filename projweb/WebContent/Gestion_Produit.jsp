<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="WEB-INF/template/header.jsp"%>

<body>

	<form action="GestionProduitsServlet?action=insert" method="post"
		style="width: 100px; position: relative; left: 48%;">
		<div style="margin-top: 10px;">
			<label for="DAchat">Date Achat</label> <input type="date"
				name="DAchat" id="DAchat">
		</div>
		<div style="margin-top: 10px;">
			<label for="desc">Description :</label> <input type="text"
				name="desc" id="desc" placeholder="Description...">
		</div>
		<div style="margin-top: 10px;">
			<label for="etat"><strong>Etat :</strong></label> <select name="etat">
				<c:forEach var="item" items="${etatProduitValues}">
					<option value="${item}">${item}</option>
				</c:forEach>
			</select>
		</div>
		<div style="margin-top: 10px;">
			<label for="prix">Prix :</label> <input type="number" name="prix"
				id="prix" placeholder="Prix...">
		</div>
		<input type="submit" value="Valider" style="margin-top: 10px;">
	</form>




	<div>
	
	<hr>
	<hr>
		<c:if test="${indice > 1}">
			<a href="GestionProduitsServlet?action=''&indice=${indice - 1}">Précédent</a>
		</c:if>

		<c:forEach begin="1" end="${produitCount / 10 +1}" var="i" step="1">
			<c:if test="${i == indice }">
				<strong>${i}</strong>
			</c:if>
			<c:if test="${i != indice}">
				<a href="GestionProduitsServlet?action=''&indice=${i}">${i}</a>
			</c:if>
		</c:forEach>

		<c:if test="${produitCount > indice*10}">
			<a href="GestionProduitsServlet?action=''&indice=${indice + 1}">Suivant</a>
		</c:if>

	</div>




	<table id="table">
		<thead>
			<tr>
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
				<tr>
					<td>${produit.id}</td>
					<td>${produit.description}</td>
					<td>${produit.prix}</td>
					<td>${produit.dateAchat}</td>
					<td>${produit.etat}</td>
					<td><a
						href="GestionProduitsServlet?action=update&id=${produit.id}&indice=${indice}">Modifier</a>
						|| <a
						href="GestionProduitsServlet?action=delete&id=${produit.id}&indice=${indice}">Supprimer</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>

<%@include file="WEB-INF/template/footer.jsp"%>

