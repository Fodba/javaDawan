<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'authentification</title>
</head>
<body
	style="margin: 0; padding: 0; text-align: center; box-sizing: border-box;">
	<div>
	<%
		String msgError = (String) request.getAttribute("msgError");
		Boolean error = (Boolean) request.getAttribute("error");
		
		if(msgError != null && error != null) {
%>
		<h3
			style="color: black; background: #FF2F2F; height: 75px; padding-top: 50px; text-align: center;margin-top:0;">${msgError}</h3>

<%
		}
%>
		<form action="AuthentificationServlet" method="post" style="width: 100px;position:relative; left: 48%; ">
			<div style = "margin-top: 10px;">
				<label for="Email" >Email :</label> 
				<input type="email" name="email" id="email" placeholder="Saisir votre email" >
			</div>
			<div style = "margin-top: 10px;">
				<label for="password">Password :</label> 
				<input type="password" name="password" id="password" placeholder="Saisir le mot de passe">
			</div>
			<input type="submit" value="Envoyer la requête" style ="margin-top: 10px;">
		</form>
		<hr>
		<hr>
Date

	</div>
	<hr>
	<hr>
	<h2>Modifier vos informations</h2>
	<div>
	<form action="CrudServlet?action=updateDone&id=${user.id}" method="post" style="width: 100px;position:relative; left: 48%; ">
			<div style = "margin-top: 10px;">
				<label for="updateMail" >Email :</label> 
				<input type="email" name="updateMail" id="updateMail" placeholder="Modifier votre email" value="${user.email}" >
			</div>
			<div style = "margin-top: 10px;">
				<label for="updateNom" >Nom :</label> 
				<input type="text" name="updateNom" id="updateNom" placeholder="Modifier votre nom" value="${user.nom}" >
			</div>
			<div style = "margin-top: 10px;">
				<label for="updatePwd">Password :</label> 
				<input type="password" name="updatePwd" id="updatePwd" placeholder="Changez votre mot de passe" value="${user.password}" >
			</div>
			<input type="submit" value="Envoyer la requête" style ="margin-top: 10px;">
		</form>

	</div>
	
	<table style ="border: 1px solid black; border-collapse: collapse; margin: 10px;">
        <thead>
            <tr style ="border: 1px solid black;">
                <th>Id</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Mot de passe</th>
                <th>Actions</th>
            </tr>
        </thead>


        <tbody>
            <c:forEach items="${users}" var="user">
                <tr style ="border: 1px solid black; padding: 30px;">
                    <td style ="border: 1px solid black;">${user.id} </td>
                    <td style ="border: 1px solid black;">${user.nom} </td>
                    <td style ="border: 1px solid black;">${user.email}</td>
                    <td style ="border: 1px solid black;">${user.password}</td>
                    <td style ="border: 1px solid black;">
	                    <a href="CrudServlet?action=update&id=${user.id}">Modifier</a> || 
						<a href="CrudServlet?action=delete&id=${user.id}">Supprimer</a>
					</td>
                </tr>
            </c:forEach>
            
        </tbody>

    </table>
</body>
</html>