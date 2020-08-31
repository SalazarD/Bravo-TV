<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script>
	function showHideUpgradationCharge() {
		if (document.getElementById('topBoxType').value == "SD") {
			document.getElementById("upgradationCharge").disabled = true;
			document.getElementById("upgradationCharge").value = 0;
		} else {
			document.getElementById("upgradationCharge").disabled = false;
		}

	}
	function showHideRefundable() {
		var radios = document.getElementsByName('billingType');

		for (var i = 0, length = radios.length; i < length; i++) {
			if (radios[i].checked) {
				if (radios[i].value == "Postpaid") {
					document.getElementById("refundableDepositAmount").disabled = true;
					document.getElementById("refundableDepositAmount").value = 0;
				} else {
					document.getElementById("refundableDepositAmount").disabled = false;
				}
			}
		}
	}
</script>

<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'|| user_type == 'customer'}">
	<jsp:include page="./menu.jsp" />
	<form name="P_SetupBox"
		action="${pageContext.request.contextPath}/P_SetupBox" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Purchase Set Top Box</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="formGroupExampleInput2">Charging Type</label>
						<div class="form-group">
							<label class="radio-inline"> <input type="radio"
								name="billingType" onClick="showHideRefundable()" id="Prepaid"
								value="Prepaid" required> Prepaid
							</label> <label class="radio-inline"> <input type="radio"
								name="billingType" onClick="showHideRefundable()" id="Postpaid"
								value="Postpaid" required> Postpaid
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Set Top Box Type</label> <select
							name="topBoxType" class="form-control" id="topBoxType"
							onClick="showHideUpgradationCharge()" required>
							<option value="HD">High Definition - HD</option>
							<option value="SD">Standard Definition - SD</option>
							<option value="HDR">High Definition Recorder - HD+</option>
							<option value="IPTV">IPTV</option>
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
						<label for="exampleInputEmail1">Dimensions in inches</label>
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
							type="text" name="upgradationCharge" id="upgradationCharge"
							class="form-control" aria-describedby="emailHelp" placeholder="">
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
						<input type="text" id="refundableDepositAmount"
							class="form-control" aria-describedby="emailHelp" placeholder="1">
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
	</c:when>
  		<c:otherwise>
			<jsp:include page="./menu.jsp" />  		
  		</c:otherwise>
	</c:choose>
</body>
</html>