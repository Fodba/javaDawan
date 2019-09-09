<%@include file="WEB-INF/template/header.jsp"%>

<html>
<body style = "margin: 0; padding: 0; text-align: center;box-sizing:border-box;">
	<h2>Formation JSP/Servlet (avec JPA)</h2>
	<%
		String msgSuccess = (String) request.getAttribute("msgSuccess");
		
		
		if(msgSuccess != null) {
%>
	<h3 style="color: black; background: #93FF72; height: 75px;padding-top:50px;  ">${msgSuccess}</h3>
	<%
		}
%>
	<div>
		<a href="AdminQcm?action=demarrer&idqcm=2">Lancer le Qcm JAVA</a>
	</div>
	<div>
		<a href="exemples.jsp">Exemples</a>
	</div>
	<div>
		<a href="LoadDataProduitServlet">Chargements des produits</a>
	</div>
	<div>
		<a href="GestionProduitsServlet?action=read&indice=1">CRUD Produits</a>
	</div>
</body>
</html>

<%@include file="WEB-INF/template/footer.jsp"%>