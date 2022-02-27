<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<%--Bootstrap--%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
	<link rel="stylesheet" href="./css/style.css" type="text/css">
	
	<%--JQuery--%>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

</head>
<body>

	<div>
		<a href="./departamentos?accion=listar">Ir a lista Departamentos</a><br>
		<a href="./carreras?accion=listar">Ir a lista Carreras</a> <br>
		<a href="./provincias?accion=listar">Ir a lista Provincias</a><br>
		<a href="./tutores?accion=listar">Ir a lista Tutores</a><br>
	</div>

</body>
</html>