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
<title>Operator Registration</title>
</head>
<body>

	<form name="operatorReg" action="${pageContext.request.contextPath}/OperatorReg"
		method="POST">
		<div class="container">
			<div style="margin-top: 1%; margin-bottom: 1%">
				<h3>BravoTV Operator Registration</h3>
			</div>
			<div class="card">
				<div class="card-body">
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
						<label for="exampleFormControlSelect1">Shift Start Time</label> <select
							class="form-control" name="startTime" required>
							<option value="12am">12:00 am</option>
							<option value="1am">1:00 am</option>
							<option value="2am">2:00 am</option>
							<option value="3am">3:00 am</option>
							<option value="4am">4:00 am</option>
							<option value="5am">5:00 am</option>
							<option value="6am">6:00 am</option>
							<option value="7am">7:00 am</option>
							<option value="8am">8:00 am</option>
							<option value="9am">9:00 am</option>
							<option value="10am">10:00 am</option>
							<option value="11am">11:00 am</option>
							<option value="12pm">12:00 pm</option>
							<option value="1pm">1:00 pm</option>
							<option value="2pm">2:00 pm</option>
							<option value="3pm">3:00 pm</option>
							<option value="4pm">4:00 pm</option>
							<option value="5pm">5:00 pm</option>
							<option value="6pm">6:00 pm</option>
							<option value="7pm">7:00 pm</option>
							<option value="8pm">8:00 pm</option>
							<option value="9pm">9:00 pm</option>
							<option value="10pm">10:00 pm</option>
							<option value="11pm">11:00 pm</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Max No. of Customers to be managed</label> <input
							type="text" class="form-control" name="max"
							aria-describedby="emailHelp" placeholder="Enter Max customers"
							required>
					</div>
						<div class="form-group">
						<label for="exampleInputEmail1">Creation Date</label> <input
							type="text" class="form-control" name="date"
							aria-describedby="emailHelp" placeholder="Creation Date"
							required>
					</div>
					
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>