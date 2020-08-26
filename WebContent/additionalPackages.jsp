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

<script type="text/javascript">
	var total1 = 0;
	var total2 = 0;
	var total3 = 0;

	function valueChangedKK() {
		if ($('#kidsKart').is(":checked")) {
			$("#helloShow").show();
			total1 = 2.5;
		} else {
			$("#helloShow").hide();
			total1 = 0;
		}
	}

	function valueChangedFT() {
		if ($('#food').is(":checked")) {
			$("#helloFT").show();
			total2 = 3;
		} else {
			$("#helloFT").hide();
			total2 = 0;
		}
	}

	function valueChangedD() {
		if ($('#drama').is(":checked")) {
			$("#helloD").show();
			total3 = 3;
		} else {
			$("#helloD").hide();
			total3 = 0;
		}
	}

	function add_number() {

		var fTotal = total1 + total2 + total3;
		document.getElementById("total").value = fTotal;

	}
</script>
<meta charset="ISO-8859-1">
<title>Additional Packages</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="AdditionalPackages"
		action="${pageContext.request.contextPath}/AdditionalPackages"
		method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<h3 style="text-align: center">Purchase Additional Packages</h3>
					<br>
					<table class="table table-bordered">
						<th colspan="3">Amount is in US Dollars</th>
						<tr>
							<td>Default Added Packages</td>
							<td>
								<table class="table table-bordered">
									<th>Package Name</th>
									<th>Charge</th>
									<tr>
										<td>Movie Magic</td>
										<td>2</td>
									</tr>
									<tr>
										<td>News Network</td>
										<td>1</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<button type="submit" class="btn btn-primary">Search More
						Packages</button>
					<br> <br>

					<div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="id1"
								value="option1" value="1" onchange="valueChangedKK()"
								id="kidsKart"> <label class="form-check-label"
								for="inlineCheckbox1">Kids Kart</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="id2"
								value="2" onchange="valueChangedFT()" id="food"> <label
								class="form-check-label" for="inlineCheckbox3">Food and
								Travel</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="id3"
								value="3" onchange="valueChangedD()" id="drama"> <label
								class="form-check-label" for="inlineCheckbox2">Drama</label>
						</div>
					</div>

					<br>

					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Package Name</th>
								<th scope="col">Channel Details</th>
								<th scope="col">Package Purchase Date</th>
								<th scope="col">Total Package Cost</th>
							</tr>
						</thead>
						<tbody>
							<tr id="helloShow" style="display: none">
								<td>Kids Kart</td>
								<td>
									<table class="table table-bordered">
										<th>Channel Name</th>
										<th>Channel Cost</th>
										<tr>
											<td>Cartoon Network</td>
											<td>1</td>
										</tr>
										<tr>
											<td>POGO</td>
											<td>1.5</td>
										</tr>
									</table>
								</td>
								<td>10/20/2016</td>
								<td>2.5</td>
							</tr>
							<tr id="helloFT" style="display: none">
								<td>Food and Travel</td>
								<td>
									<table class="table table-bordered">
										<th>Channel Name</th>
										<th>Channel Cost</th>
										<tr>
											<td>NDTV Good Times</td>
											<td>2</td>
										</tr>
										<tr>
											<td>Travel Nation</td>
											<td>1</td>
										</tr>
									</table>
								</td>
								<td>10/20/2016</td>
								<td>3</td>
							</tr>

							<tr id="helloD" style="display: none">
								<td>Drama</td>
								<td>
									<table class="table table-bordered">
										<th>Channel Name</th>
										<th>Channel Cost</th>
										<tr>
											<td>Suits</td>
											<td>2</td>
										</tr>
										<tr>
											<td>Friends</td>
											<td>1</td>
										</tr>
									</table>
								</td>
								<td>10/20/2016</td>
								<td>3</td>
							</tr>
						</tbody>
					</table>

					<div class="form-group">
						<label for="exampleInputEmail1">Total Amount</label> <input
							type="text" class="form-control" name="totalAmount" id="total"
							onClick="add_number();" aria-describedby="emailHelp"
							placeholder="Click to see the total">
					</div>
					<button type="submit" class="btn btn-primary">Purchase
						Additional Packages</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>