<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Account Creation</title>
</head>
<body>
	<form action = "createNewAccountServlet" method="post">
		Account Name: <input type = "text" name = "ownershipName"><br />
		Owner Name: <input type = "text" name = "ownerName"><br />
		
		Available Animals: <br />
		<select name="allAnimalsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allAnimals}" var="currentanimal">
				<option value = "${currentanimal.id}">${currentanimal.name} | ${currentanimal.species} | ${currentanimal.condition}</option>
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Create Account and Add Animals">
	</form>
	<a href = "index.html">Go add new animals instead.</a>
</body>
</html>