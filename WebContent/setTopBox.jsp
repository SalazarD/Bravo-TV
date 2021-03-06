<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat, java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="topBox.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>

<title>Set Top Box</title>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'}">
  	
	<jsp:include page="./menu.jsp" />
	<form name="SetTopBox"
		action="${pageContext.request.contextPath}/SetTopBox" method="post" enctype="multipart/form-data">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Set Top Box</h3>
					</div>

					<br>
					<div class="form-group">
						<label for="topBoxType">Set Top Box Type:</label> <select
							name="type" id="type" class="form-control"
							onClick="showHideUpgradationCharge()" required>
							<option value="HD">High Definition - HD</option>
							<option value="SD">Standard Definition - SD</option>
							<option value="HDR">High Definition Recorder - HD+</option>
							<option value="IPTV">IPTV</option>
						</select>
					</div>

					<div class="form-group">
						<label for="topBoxFeatures">Set Top Box Features:</label>

						<div id="featuresList">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" name="features"
									id="features" value="Live Recording"> <label
									class="form-check-label" for="liveRecording">Live
									Recording</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" name="features"
									id="features" value="Schedule Recording"> <label
									class="form-check-label" for="scheduleRecording">Schedule
									Recording</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="features"
									name="features" value="Play/Pause"> <label
									class="form-check-label" for="pausePlay">Play/Pause</label>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="features">Add a Custom Feature:</label> <input
								type="text" name="features" id="Cfeatures"
								class="form-control"
								placeholder="Enter custom features to be added">
						</div>
						<input type="button" class="btn btn-primary" value="Add Feature"
							onclick="addFeature()" />
					</div>

					<div class="form-group">
						<label for="dimensions">Dimensions in inches</label>
						<div class="form-row">
							<div class="col">
								<input type="text" class="form-control" name="length"
									placeholder="Length" required>
							</div>
							<div class="col">
								<input type="text" class="form-control" name="breadth"
									placeholder="Breadth" required>
							</div>
							<div class="col">
								<input type="text" class="form-control" name="width"
									placeholder="Width" required>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="price">Price:</label> <input type="number"
							name="price" id="price" class="form-control" placeholder="Enter Price"
							required>
					</div>
					<div class="form-group">
						<label for="installationCharge">Installation Charge:</label> <input
							type="number" name="install_charge" id="install_charge"
							class="form-control" placeholder="Enter Install Charge" required>
					</div>
					<div class="form-group">
						<label for="upgradationCharge">Upgradation Charge:</label> <input
							type="number" name="upgrade_charge" id="upgrade_charge"
							class="form-control" placeholder="Enter Upgrade Charge" required>
					</div>
					<div class="form-group">
						<label for="discountPercent">Discount %:</label> <input
							type="number" min="1" max="100" name="discount" id="discount"
							class="form-control" placeholder="Enter Discount" required>
					</div>
					<div class="form-group">
						<label for="billingType">Billing Type:</label>
						<div class="form-check">
							<label class="form-check-label" for="exampleRadio"> <input
								class="form-check-input" type="radio" name="billing_type"
								id="prepaid" value="prepaid" onClick="showHideRefundable()"
								required>Prepaid
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label" for="exampleRadio"><input
								class="form-check-input" type="radio" name="billing_type"
								id="postpaid" value="postpaid" onClick="showHideRefundable()"required">Postpaid</label>
						</div>
					</div>

					<div class="form-group">
						<label for="refundableAmount">Refundable Deposit Amount:</label> <input
							type="number" name="refundable_deposit"
							id="refundableDepositAmount" class="form-control" placeholder="Enter Refundable Deposit"
							required>
					</div>
					<div class="form-group">
						<label for="inventoryDetails">Set Top Box Inventory
							Details:</label> <br> <label class="btn btn-secondary">
							Choose File <input type="file" name="file" accept=".csv" required>
						</label>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Add" />
					</div>

				</div>


			</div>
		</div>
	</form>
	</c:when>
		<c:when test="${user_type == 'customer'}">
			<jsp:include page="./menu.jsp" />
			<h1 style="text-align: center">
				<a href="/BravoTV/homepage.jsp">Customer does not have access to this page</a>
			</h1>
		</c:when>
  		<c:otherwise>
			<jsp:include page="./menu.jsp" />
  			<h1 style="text-align: center">
				<a href="/BravoTV/login.jsp">Please Login With Your Email/Password</a>
			</h1>			  		
  		</c:otherwise>
	</c:choose>
	
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
