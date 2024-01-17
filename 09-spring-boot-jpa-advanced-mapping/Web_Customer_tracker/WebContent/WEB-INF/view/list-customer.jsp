
<%@ page contentType="text/html;charset=UTF-8" language="java"
	import="javax.servlet.jsp.PageContext"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>

<html>
<head>
<title>CRM</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/style.css" />






</head>


<body>

	<div id="wrapper">

		<div id="header">

			<h2>CRM - Customer Relationship Manager</h2>


		</div>
		<div id="container">
			<div id="conetent">

				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button">




				<!-- 		===================search ===================================== -->

				<!--  add a search box -->
				<form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />

					<input type="submit" value="Search" class="add-button" />
				</form:form>



				<!-- ========================================================================================	 -->




				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>

					<c:forEach var="tempCustomer" items="${customers}">

						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>

						</c:url>

						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>





						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td><a href="${updateLink}">Update </a> | <a
								href="${deleteLink}">Delete</a></td>
						</tr>
					</c:forEach>

				</table>

			</div>
		</div>

	</div>
</body>
</html>