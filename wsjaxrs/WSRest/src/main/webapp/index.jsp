<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<base href="<%=request.getScheme()+"://"
                + request.getServerName() + ":" 
                + request.getServerPort() 
                + request.getContextPath() + "/"%>" />
	<title>Web Service JAX-RS RI (JERSEY)</title>
</head>
<body>
	<h1>Mes méthodes du WS</h1>
	<a href="api/bases/hello1">hello1</a> 
	<br>
	<a href="api/bases/hello2/Web Service">Utilisation de PathParam</a> 
	<br>
	<a href="api/bases/hello3?msg=Java et moi">Utilisation de QueryParam</a> 
	<br>
	<a href="api/bases/hello4;msg=Java et moi;nom=Fef le D">Utilisation de MatrixParam</a>
	<br>
	<a href="api/bases/hello5?msg=Java et moi&nom=Fef&nom=Fodé">Utilisation de QueryParam avec plusieurs valeurs pour la même clé</a>
	<br>
	<a href="api/bases/navigateur">Utilisation de HeaderParam</a> 
	<br>
	<a href="api/bases/headers">Utilisation de HeaderParam pour tous les headers</a> 
</body>
</html>
