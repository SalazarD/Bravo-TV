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
<title>Login</title>
</head>
<body>

	<form name="login" action="${pageContext.request.contextPath}/login"
		method="POST">
		<div class="container">
			<div style="margin-top: 10%; margin-bottom: 2%">
				<h3>Login</h3>
			</div>
			<div class="card">
				<div class="card-body">
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
					<input class="btn btn-primary" type="button"
						onclick="location.href='/BravoTV/homepage.jsp';" value="Login" />
					<br><br> 
						<a
						href="${pageContext.request.contextPath}/customer.jsp">Customer
						Registration</a>

				</div>
			</div>
		</div>
	</form>
</body>
</html>