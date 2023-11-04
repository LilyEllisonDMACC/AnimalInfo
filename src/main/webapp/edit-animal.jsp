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
	<form action = "editAnimalServlet" method = "post" onsubmit = "return validateInfo(this);">
		Animal Name:<input type="text" name = "name" value = "${animalToEdit.name}">
		Species:<input type = "text" name = "species" value = "${animalToEdit.species}">
		Condition:<input type = "text" name = "condition" value = "${animalToEdit.condition}">
		<input type = "hidden" name = "id" value = "${animalToEdit.id}">
	<input type = "submit" value = "Save Edited Animal">
	</form>
	<a href = "index.html">Return to Home</a>
	
	<script>
		let errors = [];
		let re = /^[\w -]+$/;
		
		function validateInfo(form) {
			if(form.name.value == "") {
				errors.push("Animal Name is empty.");
			} else if(!re.test(form.name.value)) {
				errors.push("Animal Name contains invalid characters.");
			}
			if(form.species.value == "") {
				errors.push("Species is empty.");
			} else if(!re.test(form.species.value)) {
				errors.push("Species contains invalid characters.");
			}
			if(form.condition.value == "") {
				errors.push("Condition is empty.");
			} else if(!re.test(form.condition.value)) {
				errors.push("Condition contains invalid characters.");
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