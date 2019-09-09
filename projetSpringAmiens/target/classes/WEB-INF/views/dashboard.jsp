<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	DASHBOARD  
</h1>

<div>
<h4>${ user.email }</h4>
<h4>${ user.password }</h4>
</div>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
