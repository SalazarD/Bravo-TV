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
<title>Purchase Set Top Box</title>
</head>

<style>
.radio-inline {
	padding-left: 1em;
}
</style>

<body>

	<form name="P_SetupBox"
		action="${pageContext.request.contextPath}/P_SetupBox" method="POST">
		<div class="container">
			<div style="margin-top: 1%; margin-bottom: 1%">
				<h3>BravoTV Purchase Set Top Box</h3>
			</div>

			<br>

			<div class="card">
				<div class="card-body">
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

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box MAC ID</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Serial Number</label>
						<input type="text" class="form-control"
							aria-describedby="emailHelp" placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Price</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Installation Charge</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Refundable Discount Amount</label>
						<input type="text" class="form-control"
							aria-describedby="emailHelp" placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Discount %</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Tax</label> <input type="text"
							class="form-control" aria-describedby="emailHelp" placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Amount Payable</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<button type="submit" class="btn btn-primary">Purchase</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>