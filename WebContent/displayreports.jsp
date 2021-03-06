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
<title>Display reports</title>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'}">
	<jsp:include page="./menu.jsp" />
	<form action="${pageContext.request.contextPath}/DisplayReportsServlet" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Report displaying page</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Report Name:</label> <select
							name="chart" class="form-control" id="topBoxType" required>
							<option value="1" ${toDisplay == '1' ? 'selected' : ''}>Total number of operators in each shift (pie chart)</option>
							<option value="2" ${toDisplay == '2' ? 'selected' : ''}>Month-wise total Operators created for last 12 months (bar chart)</option>
							<option value="3" ${toDisplay == '3' ? 'selected' : ''}>Retailer-wise total count of Customers (pie chart)</option>
							<option value="4" ${toDisplay == '4' ? 'selected' : ''}>Month-wise total Customers created for last 12 months (bar chart)</option>
							<option value="5" ${toDisplay == '5' ? 'selected' : ''}>Total number of retailers in each State/Province (pie chart)</option>
							<option value="6" ${toDisplay == '6' ? 'selected' : ''}>Month-wise total Retailers created for last 12 months (bar chart)</option>
						</select>
					</div>
					<div>
						<input id="saveForm" class="btn btn-primary" type="submit" name="submit" value="Generate Report"/>
					</div>
				</div>
			</div>
		</div>
	</form>
	<c:choose>
		<c:when test="${toDisplay == '1'}">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<jsp:include page="./1piechart.jsp" />
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${toDisplay == '2'}">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<jsp:include page="./2barchart.jsp" />
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${toDisplay == '3'}">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<jsp:include page="./3piechart.jsp" />
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${toDisplay == '4'}">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<jsp:include page="./4barchart.jsp" />
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${toDisplay == '5'}">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<jsp:include page="./5piechart.jsp" />
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${toDisplay == '6'}">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<jsp:include page="./6barchart.jsp" />
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div class="card">
					<div class="card-body">
						Please select a report to display
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	</c:when>
		<c:when test="${user_type == 'customer'}">
			<jsp:include page="./menu.jsp" />
			<h1 style="text-align: center">
				<a href="/BravoTV/homepage.jsp">Customer does not have access to this page</a>
			</h1>
		</c:when>
  		<c:otherwise>
			<jsp:include page="./menu.jsp" />
  			<h1 style="text-align: center">
				<a href="/BravoTV/login.jsp">Please Login With Your Email/Password</a>
			</h1>			  		
  		</c:otherwise>
	</c:choose>
</body>
</html>