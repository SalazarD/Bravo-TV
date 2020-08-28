<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<jsp:include page="./menu.jsp" />
	<form method="POST">
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
						<input id="saveForm" class="btn btn-primary" type="submit" name="submit" value="Submit"/>
					</div>
				</div>
			</div>
		</div>
	</form>
	<form name="P_SetupBox2"
		action="${pageContext.request.contextPath}/P_SetupBox" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div>
						<h5 style="text-align: center">Set Top Box Details</h5>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Features</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="" value="${stbType.features}">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Dimensions in inches</label>
						<div class="form-row">
							<div class="col">
								<input type="text" class="form-control" value="${stbType.breadth}">
							</div>
							<div class="col">
								<input type="text" class="form-control" value="${stbType.width}">
							</div>
							<div class="col">
								<input type="text" class="form-control" value="${stbType.length}">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Price</label> 
						<input type="text" class="form-control" aria-describedby="emailHelp" 
						value="${stbType.price}"> 
							
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Installation Charge</label> <input
							type="text" class="form-control" aria-describedby="emailHelp" 
							value="${stbType.install_charges}">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Upgradation Charge</label> <input
							type="text" name="upgradationCharge" id="upgradationCharge"
							class="form-control" aria-describedby="emailHelp" 
							value="${stbType.upgrade_charge}">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Discount %</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${stbType.discount}">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Billing Type</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${stbType.billing_type}">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Refundable Discount Amount</label>
						<input type="text" id="refundableDepositAmount"
							class="form-control" aria-describedby="emailHelp" 
							value="${stbType.refundable_deposit}">
					</div>
					<div>
						<input class="btn btn-primary" type="button"
							onclick="${pageContext.request.contextPath}/P_SetupBoxT?id=${stbType.stb_type_id}"
							value="Next" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>