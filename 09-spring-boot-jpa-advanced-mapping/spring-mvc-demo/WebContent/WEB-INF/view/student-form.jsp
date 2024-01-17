<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>

<html>

<body>
	<%-- <form:form action="processForm" modelAttribute="student"> --%>

	<form:form action="processForm" modelAttribute="student">
	 
	First Name : <form:input path="firstName" />
		Last Name : <form:input path="lastName" />

		<input type="submit" value="submit">


	</form:form>

</body>
</html>