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
<meta charset="ISO-8859-1">
<title>Additional Packages</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="AdditionalPackages" action="${pageContext.request.contextPath}/AdditionalPackages"
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

					<div id="top">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="id1"
								value="option1"> <label class="form-check-label"
								for="inlineCheckbox1">Kids Kart</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="id2"
								name="id2" value="option2"> <label
								class="form-check-label" for="inlineCheckbox2">Drama</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="id3"
								value="option3"> <label class="form-check-label"
								for="inlineCheckbox3">Food and Travel</label>
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

							<tr>
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

							<tr>
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
							type="text" class="form-control" name="totalAmount"
							aria-describedby="emailHelp" value="8.5" required>
					</div>
					<button type="submit" class="btn btn-primary">Purchase
						Additional Packages</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>