<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animals By Owner</title>
</head>
<body>
	<form method = "post" action = "animalNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allAnimals}" var="currentanimal">
				<tr>
					<td><input type="radio" name="id" value="${currentanimal.id}"></td>
					<td><h2>${currentanimal.ownershipName}</h2></td>
				</tr>
				<tr>
					<td colspan="2">Owner: ${currentanimal.owner.ownerName}</td>
				</tr>
				<c:forEach var = "animalVal" items = "${currentanimal.listOfAnimals}">
					<tr>
						<td></td><td colspan="3">${animalVal.name}, ${animalVal.species}, has ${animalVal.condition}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<br />
		<input type = "submit" value = "edit" name="doThisToAnimal">
		<input type = "submit" value = "delete" name="doThisToAnimal">
		<input type = "submit" value = "add" name="doThisToAnimal">
	</form>
	<a href="addAnimalsForOwnerServlet">Create a new account</a>
	<a href="index.html">Add a new animal</a>
</body>
</html>