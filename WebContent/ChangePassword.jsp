<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.Case_Customer"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Change Password</title>
</head>
<body>
	<form name="ChangePassword"
		action="${pageContext.request.contextPath}/ChangePassword"
		method="post">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Change Password</h3>
					</div>
					<br>
					<div class="container" style="width:50%">
						<div class="form-group">
							<label for="userName">User Name: </label><input type="text"
								id="userName" name="userName" class="form-control"
								placeholder="Enter your user name" required>
						</div>
						<div class="form-group">
							<label for="oldPassword">Old Password: </label><input type="text"
								id="oldPassword" name="oldPassword" class="form-control"
								placeholder="Enter your current Password" required>
						</div>
						<div class="form-group">
							<label for="oldPassword">New Password: </label><input
								type="text" id="changePassword" name="changePassword"
								class="form-control" placeholder="Enter a new password" required>
						</div>
						<div class="form-group">
							<label for="oldPassword">Confirm New Password: </label><input
								type="text" id="confirmPassword" name="confirmPassword"
								class="form-control" placeholder="Re-enter your new password"
								required>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary"
								value="Change Password" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>