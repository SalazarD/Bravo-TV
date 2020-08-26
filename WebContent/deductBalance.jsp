<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.Case_Customer"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
	ArrayList<Case_Customer> customers = (ArrayList<Case_Customer>) request.getAttribute("results");
%>
<html>
<head>
<script type="text/javascript" src="deductBalance.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Deduct Balance</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="DeductBalance"
		action="${pageContext.request.contextPath}/DeductBalance"
		method="post">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Deduct balance for Pre-Paid
							Customers</h3>
					</div>
					<br>
					<div style="text-align: center;">
						<button type="submit" class="btn btn-primary">Deduct
							Balance</button>
					</div>
					<br>
					<div class="card-body"></div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>Customer Id</th>
								<th>Current Balance</th>
								<th>Deducted Balance</th>
							</tr>
						</thead>
						<tr id="row1">
							<td>CST004</td>
							<td id="CB-row1">85</td>
							<td id="DB_row1">15</td>
							<td><input type="button" id="edit_button1" value="Edit"
								class="edit" onclick="edit_row('1')"> <input
								type="button" id="save_button1" value="Save" class="save"
								onclick="save_row('1')"></td>
						</tr>
						<tr>
							<td>CST007</td>
							<td id="CB_row2">15</td>
							<td id="DB_row2">85</td>
							<td><input type="button" id="edit_button2" value="Edit"
								class="edit" onclick="edit_row('2')"> <input
								type="button" id="save_button2" value="Save" class="save"
								onclick="save_row('2')"></td>
						</tr>
						<tr>
							<td>CST008</td>
							<td id="CB-row3"">30</td>
							<td id="DB_row3">70</td>
							<td><input type="button" id="edit_button3" value="Edit"
								class="edit" onclick="edit_row('3')"> <input
								type="button" id="save_button3" value="Save" class="save"
								onclick="save_row('3')"></td>
						</tr>

						</div>
						</div>
						</div>
						</form>
</body>
</html>