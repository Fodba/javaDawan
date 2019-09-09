<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Formulaire avec Scriplets</h1>

<form action="ScripletsServlet" method="post">

	<% 
		String prenomValue= (String) request.getAttribute("prenom");
		String nomValue= (String) request.getAttribute("nom");
	%>



	<input type="text" placeholder="Entrez votre nom" name="prenom"/>
	<input type="text" placeholder="Entrez votre nom" name="nom"/>
	<input type="submit" value="Envoyer requête"/>
</form>

<!-- readonly pour empêcher la saisie dans le champ -->
<input type="text" readonly="readonly" value= <%= prenomValue==null? "": prenomValue %>/>
<input type="text" readonly="readonly" value= <%= nomValue==null? "": nomValue %> />

<%
		String msgNom = (String) request.getAttribute("msgErrorNom");
		Boolean errNom = (Boolean) request.getAttribute("errorNom");
		
		if(msgNom != null && errNom != null) {
%>

<p> <%= errNom ? "class=\"alert-danger\"" : "class=\"alert-success\"" %>
	<%= msgNom %>
</p>

<%
		}
%>

<%
		String msgPrenom = (String) request.getAttribute("msgErrorPrenom");
		Boolean errPrenom = (Boolean) request.getAttribute("errorPrenom");
		
		if(msgPrenom != null && errPrenom != null) {
%>

<p> <%= errPrenom ? "class=\"alert-danger\"" : "class=\"alert-success\"" %>
	<%= msgPrenom %>
</p>

<%
		}
%>

</body>
</html>