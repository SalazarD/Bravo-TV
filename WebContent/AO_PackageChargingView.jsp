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
<title>View Bill For Post Paid Customer</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="P_SetupBoxT"
		action="${pageContext.request.contextPath}/P_SetupBoxT" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">View Bill For Post Paid
							Customer</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">Bill Number</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Customer Name</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Type</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div>
						<h5 style="text-align: center">Package Details</h5>
					</div>

					<table class="table table-striped">
						<thead style="background-color: #e3f2fd;">
							<tr>
								<th scope="col">Package Name</th>
								<th scope="col">Package Cost</th>
							</tr>
						</thead>
						<tbody>
							<!-- Mock data to display (lines 61 to 65) -->
							<tr>
								<td>HBO</td>
								<td>15</td>
							</tr>
							<tr>
								<td>Netflix</td>
								<td>10</td>
							</tr>
							<c:forEach var="customer" items="${customers}">
								<tr>
									<td><c:out value="${customer.packageName}" /></td>
									<td><c:out value="${customer.packageCost}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="form-group">
						<label for="exampleInputEmail1">Other Chargers</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Tax</label> <input type="text"
							class="form-control" aria-describedby="emailHelp" placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Total Amount</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Bill
							Generation Day</label>
						<div class="col-10">
							<input class="form-control" type="date" id="example-date-input">
						</div>
					</div>

					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Bill
							Payment Day</label>
						<div class="col-10">
							<input class="form-control" type="date" id="example-date-input">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>