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
<meta charset="ISO-8859-1">
<title>Display Customer</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email ID</th>
				<th scope="col">Phone Number</th>
				<th scope="col">Address</th>
				<th scope="col">Address 2</th>
				<th scope="col">City</th>
				<th scope="col">State</th>
				<th scope="col">Zip</th>
				<th scope="col">Creation Date</th>
				<th scope="col">Operator Name</th>
				<th scope="col">Retailer Name</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Eden</td>
				<td>Hazard</td>
				<td>EdenHazard_10@gmail.com</td>
				<td>(777) 777-7777</td>
				<td>Eden Hazard Way</td>
				<td></td>
				<td>Madrid</td>
				<td>Madrid</td>
				<td>77777</td>
				<td>7/7/7777</td>
				<td>Perez</td>
				<td>Zidane</td>
				<td class="noBorder">
					<!--  /Book calls a servlet to fetch book by ID and populate EditBook.jsp -->
					<a
					href="${pageContext.request.contextPath}/editCustomer.jsp"><button
							type="button" class="btn btn-primary">Edit</button></a>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>