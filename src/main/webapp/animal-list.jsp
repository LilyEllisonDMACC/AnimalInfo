<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animal List</title>
</head>
<body>

<form method = "post" action = "navigationServlet">
<table>
	<c:forEach items="${requestScope.allAnimals}" var="currentanimal">
		<tr>
			<td><input type="radio" name="id" value="${currentanimal.id}"></td>
			<td>${currentanimal.name}</td>
			<td>${currentanimal.species}</td>
			<td>${currentanimal.condition}</td>
		</tr>
	</c:forEach>
</table>
<input type = "submit" value = "edit" name = "doThisToAnimal">
<input type = "submit" value = "delete" name = "doThisToAnimal">
<input type = "submit" value = "add" name = "doThisToAnimal">
</form>

</body>
</html>