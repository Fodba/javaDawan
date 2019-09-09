<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
</head>
<body>


	<h3>Calculette</h3>
	<form:form action="calculette/addition" method="post"
		modelAttribute="addition-form">
		<form:label path="a">nombre a :</form:label>
		<form:input path="a" />
		<br />
		<form:label path="b">nombre b : </form:label>
		<form:input path="b" />
		<input type="submit" value="Sauvegarder" />
	</form:form>

<h3>${msg}</h3>

</body>
</html>