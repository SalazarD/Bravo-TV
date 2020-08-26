<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat, java.util.*"%>

<!DOCTYPE html>
<%
	String userName = (String) request.getAttribute("userName");
if (userName == null) {
	userName = "Unkown User";
}

String inventoryCost = (String) request.getAttribute("inventoryCost");
if (inventoryCost == null) {
	inventoryCost = "";
}

String pattern = "MM/dd/yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());
%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Retailer Registration</title>
</head>
<body>
	<form name="RetailerReg"
		action="${pageContext.request.contextPath}/RetailerReg" method="post">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Retailer Registration</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="RetailerName">Name:</label> <input type="text"
							name="RetailerName" id="RetailerName" class="form-control"
							placeholder="Enter Retailer Name" required>
					</div>
					<div class="form-group">
						<label for="contact1">Contact 1:</label> <input type="text"
							name="contact1" id="contact1" class="form-control"
							placeholder="Enter Contact 1" required>
					</div>
					<div class="form-group">
						<label for="contact2">Contact 2:</label> <input type="text"
							name="contact2" id="contact2" class="form-control"
							placeholder="Enter Contact 2" required>
					</div>
					<div class="form-group">
						<label for="address1">Address 1:</label> <input type="text"
							name="address1" id="address1" class="form-control"
							placeholder="Enter Address 1" required>
					</div>
					<div class="form-group">
						<label for="address2">Address 2:</label> <input type="text"
							name="address2" id="address2" class="form-control"
							placeholder="Enter Address 2" required>
					</div>
					<div class="form-group">
						<label for="zipCode">Pincode/Zipcode:</label> <input type="text"
							name="zipcode" id="zipcode" class="form-control"
							placeholder="Enter zip code" required>
					</div>
					<div class="form-group">
						<label for="city">City:</label> <input type="text" name="city"
							id="city" class="form-control" placeholder="Enter city" required>
					</div>
					<div class="form-group">
						<label for="state">State/Province:</label> <input type="text"
							name="state" id="state" class="form-control"
							placeholder="Enter State" required>
					</div>
					<div class="form-group">
						<label for="topBoxLimit">Set Top Box Limit:</label> <input
							type="number" name="topBoxLimit" id="topBoxLimit"
							class="form-control" placeholder="Enter Top Box Limit" required>
					</div>
					<div class="form-group">
						<label for="creditLimit">Credit Limit:</label> <input
							type="number" min="1" step="any" name="creditLimit"
							id="creditLimit" class="form-control"
							placeholder="Enter Credit Limit" required>
					</div>
					<div class="form-group">
						<label for="commissionPercent">Commision % on Sale:</label> <input
							type="number" min="1" max="100" name="commissionPercent"
							id="commissionPercent" class="form-control"
							placeholder="Enter Percentage for Commission like 2 or 5"
							required>
					</div>
					<div class="form-group">
						<label for="ServiceCharges">Service Charges:</label> <input
							type="number" name="serviceCharges" id="serviceCharges"
							class="form-control" placeholder="Enter Service Charges" required>
					</div>
					<div class="form-group">
						<label for="inventoryList">Inventory List:</label> <input
							type="file" name="inventoryList" id="inventoryList"
							class="form-control-file"
							placeholder="browse for your inventory list file" required>
					</div>
					<div class="form-group">
						<label>Date</label>
						<%=date%>
					</div>
					<div class="form-group">
						<label>Total Cost of Inventory:</label>

						<%=inventoryCost%>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</div>
			</div>
	</form>

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
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>
