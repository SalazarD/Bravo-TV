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
<title>Login Page</title>
</head>
<body>

	<form name="login" action="${pageContext.request.contextPath}/login"
		method="POST">
		<div class="container">
			<br> <br>
			<div class="card">
				<div class="card-body">
					<h3 style="text-align: center">Login</h3>
					<br>
					<div class="container" style="width: 50%">
						<div class="form-group">
							<label for="exampleInputEmail1">Username</label> <input
								type="text" class="form-control" name="username"
								aria-describedby="emailHelp" placeholder="Enter Username"
								required>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password</label> <input
								type="text" class="form-control" name="password"
								aria-describedby="emailHelp" placeholder="Enter Password"
								required>
						</div>
						<input class="btn btn-primary" type="submit" value="Login"/>
						<br> <br>
						<p style="text-align: center">
							<a href="${pageContext.request.contextPath}/customer.jsp">Customer
								Registration</a> | <a
								href="${pageContext.request.contextPath}/ChangePassword.jsp">Forgot/Change
								Password</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>