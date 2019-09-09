<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="MyFirstServlet">requête GET vers ma premiere Servlet</a>
	</div>

	<div>
		<a href="MyFirstServlet?prenom=Valérie&nom=Dupont">requête GET
			avec des paramètres</a>
	</div>

	<div>
		<a href="TestConfigServlet?prenom=&nom=">requête GET avec
			initialisation des paramètres par défaut</a>
	</div>

	<!-- Premier exemple d'une requête de type POST avec envoie d'un formulaire -->
	<div>
		<form action="TestConfigServlet" method="post">
			<label for="nom">Nom :</label> <input type="text" name="nom" id="nom"
				placeholder="Saisir le nom"> <label for="prenom">Prénom
				:</label> <input type="text" name="prenom" id="prenom"
				placeholder="Saisir le prenom"> <input type="submit"
				value="Envoyer la requête">
		</form>
	</div>

	<div>
		<a href="RedirectionServlet?login=tutu">requête GET avec
			redirection vers une page statique non protégée via une Servlet (avec
			param)</a>
	</div>
	<div>
		<a href="RedirectionServlet">requête GET avec redirection vers une
			page statique non protégée via une Servlet (sans param)</a>
	</div>
	<div>
		<a href="exempleRedirectionStatique.jsp">requête GET avec
			redirection vers une page statique non protégée via url direct</a>
	</div>
	<a href="LoadDataServlet">Load Data Servlet</a>
	<div>
		<a href="RedirectionDynamiqueServlet?login=Arnaud">requête GET
			avec redirection vers une page dynamique avec injection de valeur
			dans la page</a>
	</div>
	<!-- On ne peut pas rediriger directement vers une page protégée sans passer par la servlet -->
	<div>
		<a href="WEB-INF/exempleRedirectionDynamique.jsp">requête GET avec
			redirection vers une page dynamique avec injection de valeur dans la
			page</a>
	</div>

	<!-- Premier exemple d'une requête de type POST avec envoie d'un formulaire -->
	<div>
		<label style="color: red">${msgError}</label>
		<form action="RedirectionDynamiqueServlet" method="post">
			<label for="login">Login :</label> <input type="text" name="login"
				id="login" placeholder="Saisir le login"> <label
				for="password">Password :</label> <input type="" name="password"
				id="password" placeholder="Saisir le mot de passe"> <input
				type="submit" value="Envoyer la requête">
		</form>
	</div>
	<div>
		<a href="AuthentificationServlet">Authentification</a>
	</div>
	<div></div>
	<h2>Les Scriplets</h2>
	<a href="scripletsFormulaires.jsp">Lien vers un formulaire qui
		utilise les scriplets</a>
</body>
</html>