<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
</body>
</html>