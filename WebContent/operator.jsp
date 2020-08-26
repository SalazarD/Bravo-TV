<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat, java.util.*"%>
<!DOCTYPE html>
<%
	String pattern = "MM/dd/yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());
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
<title>Operator Registration</title>
</head>
<script>
	document.getElementById('date').value = (new Date()).format("m/dd/yy");
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>

<body>
	<jsp:include page="./menu.jsp" />
	<form name="OperatorReg"
		action="${pageContext.request.contextPath}/OperatorReg" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Operator Registration</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">First Name</label> <input
							type="text" class="form-control" name="firstName"
							aria-describedby="emailHelp" placeholder="Enter First Name"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Last Name</label> <input
							type="text" class="form-control" name="lastName"
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
						<label for="exampleInputEmail1">Shift End Time</label> <input
							type="text" class="form-control" name="endTime"
							aria-describedby="emailHelp" placeholder="Enter Shift End Time"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Max No. of Customers to be
							managed</label> <input type="text" class="form-control" name="max"
							aria-describedby="emailHelp" placeholder="Enter Max customers"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Creation Date</label> <input
							type="text" class="form-control" name="date"
							aria-describedby="emailHelp" value="<%=date%>" required>
					</div>

					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>