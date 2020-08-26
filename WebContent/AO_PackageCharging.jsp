<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat, java.util.*"%>
<%
	String pattern = "MM/dd/yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());
%>
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
<title>Generate Bill - Post Paid Customer</title>
</head>

<style>
table {
	counter-reset: section;
}

.count:before {
	counter-increment: section;
	content: counter(section);
}
</style>

<body>
	<jsp:include page="./menu.jsp" />
	<div>
		<div>
			<div class="card">
				<div class="card-body">
					<h3 style="text-align: center">Generate Bills for Post Paid
						Customer</h3>
					<br>
					<div style="text-align: center;">
						<button type="submit" class="btn btn-primary">Generate</button>
					</div>
					<br>

					<div class="form-group">
						<label for="exampleInputEmail1">Bill Generated as on</label>
						<div class="form-row">
							<div class="col">
								<input type="text" class="form-control" name="date"
									aria-describedby="emailHelp" value="<%=date%>" required>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="card-body">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Bills</th>
				</tr>
			</thead>
			<tbody>
				<!-- Mock data to display (lines 54 to 57) -->
				<tr>
					<th scope="row" class="count"></th>
					<td><a href="/BravoTV/AO_PackageChargingView.jsp">123456789</a></td>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<th scope="row" class="count"></th>
						<td><c:out value="${customer.billID}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>