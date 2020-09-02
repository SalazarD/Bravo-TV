<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
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
<script>
function deductionUpdate(event, id) {
	if (event.keyCode == 13) {
		event.preventDefault();
		updateNewBalance(id);
		return false
	}
	return true;
}

function updateNewBalance(id) {
	var balance = document.getElementById("balance"+id).innerHTML;
	var deduction = document.getElementById("deduction"+id).value;
	var newBalance = Number(balance) - Number(deduction);
	document.getElementById("newBalance"+id).innerHTML = newBalance.toFixed(2);
}

window.onload = function() {
	<c:forEach items="${prepaidCustomers}" var="customer">
    updateNewBalance(${customer.getCustomer_id()})
    </c:forEach>
};
</script>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'}">
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
								<th>Deductions</th>
								<th>New Balance</th>
							</tr>
						</thead>
						<c:forEach items="${prepaidCustomers}" var="customer">
						<tr id="row_${customer.getCustomer_id()}">
							<td>CST<fmt:formatNumber pattern="000" type="number" value="${customer.getCustomer_id()}" /></td>
							<td>
								<div style="display: inline-block;">
									<p id="balance${customer.getCustomer_id()}">${customer.getBalance()}</p>
								</div>
							</td>
							<td>
								<div style="display: inline-block;">
									<input required type="number" name="deduction${customer.getCustomer_id()}" id="deduction${customer.getCustomer_id()}" value="${deductionMap.get(customer)}"
									onkeypress="deductionUpdate(event,${customer.getCustomer_id()})" autocomplete="off">
								</div>
							</td>
							<td>
								<div style="display: inline-block;">
									<p id="newBalance${customer.getCustomer_id()}">...</p>
								</div>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>
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