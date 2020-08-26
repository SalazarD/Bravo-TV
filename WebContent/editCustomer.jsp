<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="EditCustomer"
		action="${pageContext.request.contextPath}/EditCustomer" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Update Customer</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">First Name</label> <input
							type="text" class="form-control" name="firstname_U"
							aria-describedby="emailHelp" placeholder="Enter First Name"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Last Name</label> <input
							type="text" class="form-control" name="lastname_U"
							aria-describedby="emailHelp" placeholder="Enter Last Name"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email ID</label> <input
							type="text" class="form-control" name="email_U"
							aria-describedby="emailHelp" placeholder="Enter Email ID"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Phone Number</label> <input
							type="text" class="form-control" name="phone_U"
							aria-describedby="emailHelp" placeholder="Enter Phone Number"
							required>
					</div>

					<div class="form-group">
						<label for="inputAddress">Address</label> <input type="text"
							class="form-control" id="inputAddress_U" placeholder="1234 Main St">
					</div>
					<div class="form-group">
						<label for="inputAddress2">Address 2</label> <input type="text"
							class="form-control" id="inputAddress2_U"
							placeholder="Apartment, studio, or floor">
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCity">City</label> <input type="text"
								class="form-control" id="inputCity_U">
						</div>
						<div class="col-md-3 mb-3">
							<label for="validationCustom04">State</label> <input type="text"
								class="form-control" id="validationCustom04_U" placeholder="State"
								required>
							<div class="invalid-feedback">Please provide a valid state.
							</div>
						</div>
						<div class="form-group col-md-2">
							<label for="inputZip">Zip</label> <input type="text"
								class="form-control" id="inputZip_U">
						</div>
					</div>

					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Creation
							Date</label>
						<div class="col-10">
							<input class="form-control" type="date" value="2020-08-24"
								id="example-date-input_U">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Operator Name</label> <input
							type="text" class="form-control" name="O_name_U"
							aria-describedby="emailHelp" placeholder="" required>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Retailer Name</label> <input
							type="text" class="form-control" name="R_name_U"
							aria-describedby="emailHelp" placeholder="" required>
					</div>

					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>