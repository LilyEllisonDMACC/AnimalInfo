<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Animal</title>
</head>
<body>
	<form action = "editAnimalServlet" method = "post">
		Animal Name:<input type="text" name = "name" value = "${animalToEdit.name}">
		Species:<input type = "text" name = "species" value = "${animalToEdit.species}">
		Condition:<input type = "text" name = "condition" value = "${animalToEdit.condition}">
		<input type = "hidden" name = "id" value = "${animalToEdit.id}">
	<input type = "submit" value = "Save Edited Animal">
	</form>
</body>
</html>