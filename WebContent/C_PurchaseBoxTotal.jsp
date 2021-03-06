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
	function add_number() {

		var price = parseFloat(document.getElementById("price").value);
		var charge = parseFloat(document.getElementById("installCharge").value);
		var deposit = parseFloat(document.getElementById("depoistAmount").value);
		var discount = parseFloat(document.getElementById("discount").value);
		var tax = parseFloat(document.getElementById("tax").value);
		var result = price + charge - deposit;
		var fTotal = (result - (result * ((discount) / 100)));
		var finalTotal = (fTotal + (fTotal * ((tax) / 100)));

		document.getElementById("total").value = finalTotal;
	}
</script>

<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'|| user_type == 'customer'}">
	<jsp:include page="./menu.jsp" />
	<form name="P_SetupBoxT"
		action="${pageContext.request.contextPath}/P_SetupBoxT" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Purchase Set Top Box</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">Customer Email</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							placeholder="" name="email" onClick="add_number();" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Type</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${stbType.type}" name="type" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box MAC ID</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${stb.mac_id}" name="mac_id" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Serial Number</label>
						<input type="text" class="form-control"
							aria-describedby="emailHelp" value="${stb.serial_num}" name="serial_num" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Price</label> <input
							type="text" id="price" class="form-control"
							aria-describedby="emailHelp" value="${stbType.price}" name="price" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Installation Charge</label> <input
							type="text" id="installCharge" class="form-control"
							aria-describedby="emailHelp" value="${stbType.install_charges}" name="install_charges" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Refundable Deposit Amount</label>
						<input type="text" id="depoistAmount"
							class="form-control" aria-describedby="emailHelp" value="${stbType.refundable_deposit}" name="refundable_deposit" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Discount %</label> <input
							type="text" id="discount" class="form-control"
							aria-describedby="emailHelp" value="${stbType.discount}" name="discount" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Tax %</label> <input type="text"
							class="form-control" value="6" id="tax"
							aria-describedby="emailHelp" placeholder="" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Amount Payable</label> <input
							type="text" id="total"
							class="form-control readonly" aria-describedby="emailHelp"
							placeholder="Enter Email to see total" name="payable" required>
					</div>
					<input type="hidden" value="${stb.std_id}" name="std_id"/>
					<input type="hidden" value="${stb.stb_type_id}" name="stb_type_id"/>
					<input type="hidden" value="${stb.remote_asset_id}" name="remote_asset_id"/>
					<input type="hidden" value="${stb.dish_asset_id}" name="dish_asset_id"/>
					<input type="hidden" value="${stb.assigned_retailer_id}" name="assigned_retailer_id"/>
					<button type="submit" class="btn btn-primary">Purchase</button>
				</div>
			</div>
		</div>
	</form>
	</c:when>
  		<c:otherwise>
			<jsp:include page="./menu.jsp" /> 
			<h1 style="text-align: center">
				<a href="/BravoTV/login.jsp">Please Login With Your Email/Password</a>
			</h1>	 		
  		</c:otherwise>
	</c:choose>
</body>
<script>
    $(".readonly").keydown(function(e){
        e.preventDefault();
    });
</script>
</html>