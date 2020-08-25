<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.Case_Customer"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
	ArrayList<Case_Customer> customers = (ArrayList<Case_Customer>) request.getAttribute("results");
%>
<%
	String userName = (String) request.getAttribute("userName");
if (userName == null) {
	userName = "Unkown User";
}
%>
<html>
<head>
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
			<div style="margin-top: 1%; margin-bottom: 1%">
				<h3>BravoTV Deduct Balance for Prepaid Customers</h3>
			</div>

			<br>

			<div class="card">
				<div class="card-body">

					<div class="form-group">
						Welcome Admin
						<%=userName%>
					</div>

					<div class="form-group">Deduct Balance for pre-paid Customers
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary"
							value="Deduct Balance" />
					</div>
					<table border="2" align="center" class="table">
						<tr>
							<th>Customer Id</th>
							<th>Current Balance</th>
							<th>Deducted Balance</th>
						</tr>
						<tr>
							<td>CST004</td>
							<td>85</td>
							<td>15</td>
						</tr>
						<tr>
							<td>CST007</td>
							<td>15</td>
							<td>85</td>
						</tr>
						<tr>
							<td>CST008</td>
							<td>30</td>
							<td>70</td>
						</tr>

						</div>
						</div>
						</div>
						</form>
</body>
</html>