<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h2>Formation JSP/Servlet (avec JPA)</h2>
	
	<h3>Q ${qst.ordre}) ${qst.enonce}</h3> 
	<c:choose>
		<c:when test="${qst.multiple}">
			<c:forEach var="rep" items="${lRep}">
				<input type="checkbox" name="rep[]"
						value="${rep.id}" />
				${rep.texte}
				<br />
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach var="rep" items="${lRep}">
				<input type="radio" name="rep"
						value="${rep.id}" />
				${rep.texte}
				<br />
			</c:forEach>
		</c:otherwise>
	
	</c:choose>
</body>
</html>
