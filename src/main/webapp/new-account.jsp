<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Account Creation</title>
</head>
<body>
	<form action = "createNewAccountServlet" method="post" onsubmit="return validateInfo(this);">
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
	
		<script>
		let errors = [];
		let re = /^[\w -]+$/;
		
		function validateInfo(form) {
			if(form.ownershipName.value == "") {
				errors.push("Account Name is empty.");
			} else if(!re.test(form.name.value)) {
				errors.push("Account Name contains invalid characters.");
			}
			if(form.ownerName.value == "") {
				errors.push("Owner Name is empty.");
			} else if(!re.test(form.species.value)) {
				errors.push("Owner Name contains invalid characters.");
			}
						
			if(errors.length > 0) {
				var errorMessage = "ERRORS:\n\n";
				for (let i=0; i<errors.length; i++) {
					errorMessage+=errors[i] + "\n";
				}
				errors = [];
				alert(errorMessage);
				return false;
			}
			return true;
		}
		
	</script>
	
</body>
</html>