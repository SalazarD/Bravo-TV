<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<title>Update Customer</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="customerReg"
		action="${pageContext.request.contextPath}/Customer/Add" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Update Customer</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">First Name</label> <input
							type="text" class="form-control" name="firstname"
							aria-describedby="emailHelp" value="${customer.first_name}"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Last Name</label> <input
							type="text" class="form-control" name="lastname"
							aria-describedby="emailHelp" value="${customer.last_name}"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email ID</label> <input
							type="text" class="form-control" name="email"
							aria-describedby="emailHelp" value="${customer.email}" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Phone Number</label> <input
							type="text" class="form-control" name="phone"
							aria-describedby="emailHelp" value="${customer.phone}" required>
					</div>

					<div class="form-group">
						<label for="inputAddress">Address</label> <input type="text"
							class="form-control" name="address_1" id="inputAddress"
							value="${customer.address_1}">
					</div>
					<div class="form-group">
						<label for="inputAddress2">Address 2</label> <input type="text"
							class="form-control" name="address_2" id="inputAddress2"
							value="${customer.address_2}">
					</div>
					<div class="form-group">
						<label for="inputLandmark">Landmark</label> <input type="text"
							class="form-control" name="landmark" id="inputLandmark"
							value="${customer.land_mark}">
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCity">City</label> <input type="text"
								class="form-control" name="city" id="inputCity"
								value="${customer.city}">
						</div>
						<div class="col-md-3 mb-3">
							<label for="validationCustom04">State</label> <input type="text"
								class="form-control" name="state" id="validationCustom04"
								value="${customer.state_province}" required>
							<div class="invalid-feedback">Please provide a valid state.
							</div>
						</div>
						<div class="form-group col-md-2">
							<label for="inputZip">Zip</label> <input type="text"
								class="form-control" name="zip" id="inputZip"
								value="${customer.zip_code}">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Creation
							Date</label>
						<div class="col-10">
							<input class="form-control" type="text" name="date"
								value="${customer.customer_creation_date}"
								id="example-date-input" readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="prePaid">Pre-paid?</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="prePaidTrue" name="prePaid"
							type="radio" value="${customer.pre_paid}" checked required>
						<label class="form-check-label" for="prePaidTrue">Previous
							Selection</label>
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
							aria-describedby="emailHelp" value="${customer.balance}" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Operator Id</label> <input
							type="text" class="form-control" name="O_name"
							aria-describedby="emailHelp"
							value="${customer.assigned_operator_id}" required>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Retailer Id</label> <input
							type="text" class="form-control" name="R_name"
							aria-describedby="emailHelp"
							value="${customer.assigned_retailer_id}" required>
					</div>
					<input type="hidden" name="customerId"
						value="${customer.customer_id}"><br /> <input
						type="hidden" name="action" value="update" />
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>