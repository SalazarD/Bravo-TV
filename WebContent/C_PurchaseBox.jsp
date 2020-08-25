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
<jsp:include page="./menu.jsp" />
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
						<label for="formGroupExampleInput2">Charging Type</label>
						<div class="form-group">
							<label class="radio-inline"> <input type="radio"
								name="chargeType" value="Prepaid" required> Prepaid
							</label> <label class="radio-inline"> <input type="radio"
								name="chargeType" value="Postpaid" required> Postpaid
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Set Top Box Type</label> <select
							name="major" class="form-control" id="exampleFormControlSelect1">
							<option value="HD">High Definition - HD</option>
							<option value="SD">Standard Definition - SD</option>
							<option value="UHD">Ultra High Definition - UHD</option>
						</select>
					</div>
					<div>
						<h5 style="text-align: center">Set Top Box Details</h5>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Features</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Dimensions in inches</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Price</label> <input type="text"
							class="form-control" aria-describedby="emailHelp" placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Installation Charge</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Upgradation Charge</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Discount %</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Billing Type</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Refundable Discount Amount</label>
						<input type="text" class="form-control"
							aria-describedby="emailHelp" placeholder="">
					</div>
					<div>
						<input class="btn btn-primary" type="button"
							onclick="location.href='/BravoTV/C_PurchaseBoxTotal.jsp';"
							value="Next" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>