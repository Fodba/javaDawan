<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr">FR</a>
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en">EN</a>
	<h3><spring:message code="message.show" /> : ${msg}</h3>

	<h2>${msg}</h2>
	<form:form
		action="${pageContext.request.contextPath}/authentication/authentication"
		method="post" modelAttribute="monForm">
		<form:errors path="email" />
		<form:input path="email" placeholder="email" />
		<form:errors path="password" />
		<form:password path="password" placeholder="password" />
		<input type="submit" value="Login">
	</form:form>

	<div>
		<h4>${ user.email }</h4>
		<h4>${ user.password }</h4>
	</div>

	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
