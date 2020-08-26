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

<title>Set Top Box</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="SetTopBox"
		action="${pageContext.request.contextPath}/SetTopBox" method="post">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Set Top Box</h3>
					</div>

					<br>
					<div class="form-group">
						<label for="topBoxType">Set Top Box Type:</label> <select
							name="topBoxType" id="topBoxType" class="form-control"
							onClick="showHideUpgradationCharge()" required>
							<option id="standard" value="Standard">Standard-SD</option>
							<option id="HD" value="HD">High Definition-HD</option>
							<option id="HD+" value="HD+">High Definition
								Recorder-HD+</option>
							<option id="IPTV" value="IPTV">IPTV</option>
						</select>
					</div>

					<div class="form-group">
						<label for="topBoxFeatures">Set Top Box Features:</label>

						<div id="featuresList">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="liveRecording" value="Live Recording"> <label
									class="form-check-label" for="liveRecording">Live
									Recording</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="scheduleRecording" value="Schedule Recording"> <label
									class="form-check-label" for="scheduleRecording">Schedule
									Recording</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="pausePlay"
									value="Play/Pause"> <label class="form-check-label"
									for="pausePlay">Play/Pause</label>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="customFeature">Add a Custom Feature:</label> <input
								type="text" name="customFeature" id="customFeature"
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
								<input type="text" class="form-control" placeholder="Height">
							</div>
							<div class="col">
								<input type="text" class="form-control" placeholder="Width">
							</div>
							<div class="col">
								<input type="text" class="form-control" placeholder="Length">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="price">Price:</label> <input type="number"
							name="price" id="price" class="form-control" placeholder="5"
							required>
					</div>
					<div class="form-group">
						<label for="installationCharge">Installation Charge:</label> <input
							type="number" name="installationCharge" id="installationCharge"
							class="form-control" placeholder="5" required>
					</div>
					<div class="form-group">
						<label for="upgradationCharge">Upgradation Charge:</label> <input
							type="number" name="upgradationCharge" id="upgradationCharge"
							class="form-control" placeholder="2" required>
					</div>
					<div class="form-group">
						<label for="discountPercent">Discount %:</label> <input
							type="number" min="1" max="100" name="discountPercent"
							id="discountPercent" class="form-control" placeholder="2"
							required>
					</div>
					<div class="form-group">
						<label for="billingType">Billing Type:</label>
						<div class="form-check">
							<label class="form-check-label" for="exampleRadio"> <input
								class="form-check-input" type="radio" name="billingType"
								id="prepaid" value="prepaid" onClick="showHideRefundable()"
								required>Prepaid
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label" for="exampleRadio"><input
								class="form-check-input" type="radio" name="billingType"
								id="postpaid" value="postpaid" onClick="showHideRefundable()"required">Postpaid</label>
						</div>
					</div>

					<div class="form-group">
						<label for="refundableAmount">Refundable Deposit Amount:</label> <input
							type="number" name="refundableDepositAmount"
							id="refundableDepositAmount" class="form-control" placeholder="5"
							required>
					</div>
					<div class="form-group">
						<label for="inventoryDetails">Set Top Box Inventory
							Details:</label> <input type="file" name="inventoryDetails"
							id="inventoryDetails" class="form-control-file"
							placeholder="browse for your inventory details csv file" required>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Add" />
					</div>

				</div>


			</div>
		</div>
		</div>
	</form>
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
