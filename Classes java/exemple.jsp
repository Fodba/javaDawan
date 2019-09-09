<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${msg}</h1>
	
	<div>
		<a href="${pageContext.request.contextPath}/exemples/exemple1">Mon Exemple 1 : injection d'un message dans la jsp</a>
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/exemples/exemple2/coucou/4">Mon Exemple 2 : avec passage de paramètres dans l'URL</a>
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/exemples/exemple3/coucou/cheminQuelconque/1/2">Mon Exemple 3 : récupération des params dans une map</a>
	</div>
	
	<form action="${pageContext.request.contextPath}/exemples/exemple4" method="post">
		<input type="text" name="description">
		<input type="submit" value="Envoyer">
	</form>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
