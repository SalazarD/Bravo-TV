<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat, java.util.*"%>
<!DOCTYPE html>
<%
	String pattern = "yyyy-MM-dd HH:mm:ss";
SimpleDateFormat dateCreation = new SimpleDateFormat(pattern);
String date = dateCreation.format(new Date());

String pattern2 = "yyyy-MM-dd";
SimpleDateFormat startTime = new SimpleDateFormat(pattern2);
String shift = startTime.format(new Date());
%>
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
<title>Customer Registration</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="customerReg"
		action="${pageContext.request.contextPath}/Customer/Add" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Customer Registration</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">First Name</label> <input
							type="text" class="form-control" name="firstname"
							aria-describedby="emailHelp" placeholder="Enter First Name"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Last Name</label> <input
							type="text" class="form-control" name="lastname"
							aria-describedby="emailHelp" placeholder="Enter Last Name"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email ID</label> <input
							type="text" class="form-control" name="email"
							aria-describedby="emailHelp" placeholder="Enter Email ID"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Phone Number</label> <input
							type="text" class="form-control" name="phone"
							aria-describedby="emailHelp" placeholder="Enter Phone Number"
							required>
					</div>

					<div class="form-group">
						<label for="inputAddress">Address</label> <input type="text"
							class="form-control" name="address_1" id="inputAddress"
							placeholder="1234 Main St">
					</div>
					<div class="form-group">
						<label for="inputAddress2">Address 2</label> <input type="text"
							class="form-control" name="address_2" id="inputAddress2"
							placeholder="Apartment, studio, or floor">
					</div>
					<div class="form-group">
						<label for="inputLandmark">Landmark</label> <input type="text"
							class="form-control" name="landmark" id="inputLandmark"
							placeholder="Landmark near address">
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCity">City</label> <input type="text"
								class="form-control" name="city" id="inputCity">
						</div>
						<div class="col-md-3 mb-3">
							<label for="validationCustom04">State</label> <input type="text"
								class="form-control" name="state" id="validationCustom04"
								placeholder="State" required>
							<div class="invalid-feedback">Please provide a valid state.
							</div>
						</div>
						<div class="form-group col-md-2">
							<label for="inputZip">Zip</label> <input type="text"
								class="form-control" name="zip" id="inputZip">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Creation
							Date</label>
						<div class="col-10">
							<input class="form-control" type="text" name="date"
								value="<%=shift%>" id="example-date-input" readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="prePaid">Pre-paid?</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="prePaidTrue" name="prePaid"
							type="radio" value="true" required> <label
							class="form-check-label" for="prePaidTrue">Yes</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="prePaidFalse" name="prePaid"
							type="radio" value="false" required> <label
							class="form-check-label" for="prePaidFalse">No</label>
					</div>
					<br></br>
					<div class="form-group">
						<label for="exampleInputBalance">Balance</label> <input
							type="text" class="form-control" name="balance"
							aria-describedby="emailHelp" placeholder="" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Operator Id</label> <input
							type="text" class="form-control" name="O_name"
							aria-describedby="emailHelp" placeholder="" required>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Retailer Id</label> <input
							type="text" class="form-control" name="R_name"
							aria-describedby="emailHelp" placeholder="" required>
					</div>
					<input type="hidden" name="customerId" value="${customer.customer_id}"><br />
					<input type="hidden" name="action" value="add" />
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>