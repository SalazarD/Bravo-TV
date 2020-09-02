<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<script type="text/javascript">
	function getOption() {

		var total = new Date();

		selectElement = document.querySelector('#select1');

		output = selectElement.value;

		var d = new Date(output);
		f = new Date(d.getTime());

		a = d.setHours(d.getHours() + 8)
		var date = new Date(a);
		console.log(date);

		document.querySelector('.output').textContent = date;
	}
</script>

<meta charset="ISO-8859-1">
<title>Operator Registration</title>
</head>
<!-- 
<script>
	document.getElementById('date').value = (new Date()).format("m/dd/yy");
</script>

 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>

<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin'}">
  	
	<jsp:include page="./menu.jsp" />
	<form name="OperatorReg"
		action="${pageContext.request.contextPath}/OperatorReg/Add"
		method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Operator Registration</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">First Name</label> <input
							type="text" class="form-control" name="first_name"
							aria-describedby="emailHelp" placeholder="Enter First Name"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Last Name</label> <input
							type="text" class="form-control" name="last_name"
							aria-describedby="emailHelp" placeholder="Enter Last Name"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email ID</label> <input
							type="email" class="form-control" name="email"
							aria-describedby="emailHelp" placeholder="Enter Email ID"
							required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Phone Number</label> <input
							type="number" class="form-control" name="phone"
							aria-describedby="emailHelp" placeholder="Enter Phone Number"
							required>
					</div>


					<div class="form-group">
						<label for="exampleFormControlSelect1">Shift Start Time</label> <select
							class="form-control" id="select1" name="start_shift"
							onclick="getOption()" required>
							<option value="<%=shift + " 00:00:00"%>">12:00 am</option>
							<option value="<%=shift + " 01:00:00"%>">1:00 am</option>
							<option value="<%=shift + " 02:00:00"%>">2:00 am</option>
							<option value="<%=shift + " 03:00:00"%>">3:00 am</option>
							<option value="<%=shift + " 04:00:00"%>">4:00 am</option>
							<option value="<%=shift + " 05:00:00"%>">5:00 am</option>
							<option value="<%=shift + " 06:00:00"%>">6:00 am</option>
							<option value="<%=shift + " 07:00:00"%>">7:00 am</option>
							<option value="<%=shift + " 08:00:00"%>">8:00 am</option>
							<option value="<%=shift + " 09:00:00"%>">9:00 am</option>
							<option value="<%=shift + " 10:00:00"%>">10:00 am</option>
							<option value="<%=shift + " 11:00:00"%>">11:00 am</option>
							<option value="<%=shift + " 12:00:00"%>">12:00 pm</option>
							<option value="<%=shift + " 13:00:00"%>">1:00 pm</option>
							<option value="<%=shift + " 14:00:00"%>">2:00 pm</option>
							<option value="<%=shift + " 15:00:00"%>">3:00 pm</option>
							<option value="<%=shift + " 16:00:00"%>">4:00 pm</option>
							<option value="<%=shift + " 17:00:00"%>">5:00 pm</option>
							<option value="<%=shift + " 18:00:00"%>">6:00 pm</option>
							<option value="<%=shift + " 19:00:00"%>">7:00 pm</option>
							<option value="<%=shift + " 20:00:00"%>">8:00 pm</option>
							<option value="<%=shift + " 21:00:00"%>">9:00 pm</option>
							<option value="<%=shift + " 22:00:00"%>">10:00 pm</option>
							<option value="<%=shift + " 23:00:00"%>">11:00 pm</option>
						</select>
					</div>



					<div class="form-group">
						<label for="exampleInputEmail1">Shift End Time:- </label> <span
							class="output"></span>

					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Max No. of Customers to be
							managed</label> <input type="number" class="form-control"
							name="max_customers" aria-describedby="emailHelp"
							placeholder="Enter Max customers" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Creation Date</label> <input
							type="text" class="form-control" name="operator_creation_date"
							aria-describedby="emailHelp" value="<%=date%>" readonly>
					</div>

					<input type="hidden" name="operator_id" value="${operator.operator_id}"><br /> 
					<input type="hidden" name="action" value="add" />


					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>
		</div>
	</form>
	</c:when>
	
		<c:when test="${user_type == 'customer'|| user_type == 'operator'}">
			<jsp:include page="./menu.jsp" />
			<h1 style="text-align: center">
				<a href="/BravoTV/homepage.jsp">Customer/Operator does not have access to this page</a>
			</h1>
		</c:when>
  		<c:otherwise>
			<jsp:include page="./menu.jsp" /> 
			<h1 style="text-align: center">
				<a href="/BravoTV/login.jsp">Please Login With Your Email/Password</a>
			</h1>	 		
  		</c:otherwise>
	</c:choose>
</body>
</html>