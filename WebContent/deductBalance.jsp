<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
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
							<td><div id="nonEditableCB1" style="display: inline;">
									<p id="cbValue1">85</p>
									<input type="button" value="Edit" class="btn btn-secondary"
										onclick="editCB('1')">
								</div>
								<div id="editableCB1" style="display: none;">
									<input type="text" id="cbEdit1"><input type="button"
										value="Done" class="btn btn-secondary" onclick="confirmCB('1')">
								</div></td>
							<td><div id="nonEditableDB1" style="display: inline;">
									<p id="dbValue1">15</p>
									<input type="button" value="Edit" class="btn btn-secondary"
										onclick="editDB('1')">
								</div>
								<div id="editableDB1" style="display: none;">
									<input type="text" id="dbEdit1"><input type="button"
										value="Done" class="btn btn-secondary" onclick="confirmDB('1')">
								</div></td>
						</tr>
						<tr id="row2">
							<td>CST007</td>
							<td><div id="nonEditableCB2" style="display: inline;">
									<p id="cbValue2">15</p>
									<input type="button" value="Edit" class="btn btn-secondary"
										onclick="editCB('2')">
								</div>
								<div id="editableCB2" style="display: none;">
									<input type="text" id="cbEdit2"><input type="button"
										value="Done" class="btn btn-secondary" onclick="confirmCB('2')">
								</div></td>
							<td><div id="nonEditableDB2" style="display: inline;">
									<p id="dbValue2">85</p>
									<input type="button" value="Edit" class="btn btn-secondary"
										onclick="editDB('2')">
								</div>
								<div id="editableDB2" style="display: none;">
									<input type="text" id="dbEdit2"><input type="button"
										value="Done" class="btn btn-secondary" onclick="confirmDB('2')">
								</div></td>
						</tr>
						<tr id="row3">
							<td>CST003</td>
							<td><div id="nonEditableCB3" style="display: inline;">
									<p id="cbValue3">70</p>
									<input type="button" value="Edit" class="btn btn-secondary"
										onclick="editCB('3')">
								</div>
								<div id="editableCB3" style="display: none;">
									<input type="text" id="cbEdit3"><input type="button"
										value="Done" class="btn btn-secondary" onclick="confirmCB('3')">
								</div></td>
							<td><div id="nonEditableDB3" style="display: inline;">
									<p id="dbValue3">30</p>
									<input type="button" value="Edit" class="btn btn-secondary"
										onclick="editDB('3')">
								</div>
								<div id="editableDB3" style="display: none;">
									<input type="text" id="dbEdit3"><input type="button"
										value="Done" class="btn btn-secondary" onclick="confirmDB('3')">
								</div></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>