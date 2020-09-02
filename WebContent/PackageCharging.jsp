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
<title>Package and Charging</title>
</head>
<body>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'}">
	<jsp:include page="./menu.jsp" />
	<div>
		<div>
			<div class="card">
				<div class="card-body">
					<h3 style="text-align: center">Package and Charging</h3>
					<br>
					<form>
						<div class="form-group">
							<div class="form-row">
								<div class="col" style="text-align: center">
									<a class="btn btn-primary"
										href="/BravoTV/GenerateBillServlet">Generate Bills</a>
								</div>
								<div class="col" style="text-align: center">
									<a class="btn btn-primary" href="/BravoTV/DeductBalance">Deduct
										Balance</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</c:when>
		<c:when test="${user_type == 'customer'}">
			<jsp:include page="./menu.jsp" />
			<h1 style="text-align: center">
				<a href="/BravoTV/homepage.jsp">Customer does not have access to this page<br>Please contact a local Operator/Retailer</a>
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