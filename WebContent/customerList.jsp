<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Display Customer</title>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'|| user_type == 'customer'}">
	<jsp:include page="./menu.jsp" />
	<div class="card-body">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email ID</th>
					<th scope="col">Phone Number</th>
					<th scope="col">Address</th>
					<th scope="col">Address 2</th>
					<th scope="col">Landmark</th>
					<th scope="col">City</th>
					<th scope="col">State</th>
					<th scope="col">Zip</th>
					<th scope="col">Creation Date</th>
					<th scope="col">Pre Paid</th>
					<th scope="col">Balance</th>
					<th scope="col">Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td><c:out value="${customer.first_name}" /></td>
						<td><c:out value="${customer.last_name}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td><c:out value="${customer.phone}" /></td>
						<td><c:out value="${customer.address_1}" /></td>
						<td><c:out value="${customer.address_2}" /></td>
						<td><c:out value="${customer.land_mark}" /></td>
						<td><c:out value="${customer.city}" /></td>
						<td><c:out value="${customer.state_province}" /></td>
						<td><c:out value="${customer.zip_code}" /></td>
						<td><c:out value="${customer.customer_creation_date}" /></td>
						<td><c:out value="${customer.pre_paid}" /></td>
						<td><c:out value="${customer.balance}" /></td>
						<td class="noBorder">
							<!--  /Book calls a servlet to fetch book by ID and populate EditBook.jsp -->
							<a class="button"
							href="${pageContext.request.contextPath}/Customer/List?id=${customer.customer_id}"><svg
									width="1em" height="1em" viewBox="0 0 16 16"
									class="bi bi-pencil-square" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
  <path
										d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
  <path fill-rule="evenodd"
										d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
</svg></a>
						</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
		</c:when>
  		<c:otherwise>
			<jsp:include page="./menu.jsp" />
  		</c:otherwise>
	</c:choose>
</body>
</html>