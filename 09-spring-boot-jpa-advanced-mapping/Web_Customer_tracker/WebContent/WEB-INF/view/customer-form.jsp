<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="javax.servlet.jsp.JspException"%>

<!-- Your JSP code here -->

<!DOCTYPE HTML>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/style.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Save the Details</h2>
		</div>
	</div>
	<div>
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">

			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label for="firstName">First Name</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label for="firstName">Last Name</label></td>
						<td><form:input path="lastName" /></td>

					</tr>
					<tr>
						<td><label for="firstName">Email</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save"></td>

					</tr>
				</tbody>
			</table>

		</form:form>

		<div style="">

			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</div>


	</div>
</body>
</html>
