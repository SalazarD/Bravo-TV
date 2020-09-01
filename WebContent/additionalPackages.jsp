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
	function updateTotal() {
		total = 0.00;
		
	    <c:forEach items="${defaultPackages}" var="cp">
	    total += ${cp.package_cost};
	    </c:forEach>
	    
	    <c:forEach items="${purchaseMap}" var="entry">
		if ($("#checkbox_${entry.key.package_id}").is(":checked")) {
			total += ${entry.key.package_cost};
		}
	    </c:forEach>
		
		document.getElementById("totalAmount").value = total;
	}
	
	function checkboxChanged(package_id) {
		if ($("#checkbox_"+package_id).is(":checked")) {
			$("#table_row_"+package_id).show();
		} else {
			$("#table_row_"+package_id).hide();
		}
		updateTotal();
	}
	
	window.onload = function() {
	    <c:forEach items="${purchaseMap}" var="entry">
	    checkboxChanged(${entry.key.package_id});
	    </c:forEach>
		updateTotal();
	};
</script>
<meta charset="ISO-8859-1">
<title>Additional Packages</title>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'|| user_type == 'customer'}">
	<jsp:include page="./menu.jsp" />
	<form name="AdditionalPackages"
		action="${pageContext.request.contextPath}/PurchasePackage"
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
									<c:forEach items="${defaultPackages}" var="cp" >
									<tr>
										<td><c:out value="${cp.package_name}" /></td>
										<td><c:out value="${cp.package_cost}" /></td>
									</tr>
									</c:forEach>
								</table>
							</td>
					</table>
					<br> <br>

					<h3>Select More</h3>
					<div>
						<c:forEach items="${purchaseMap}" var="entry" >
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="packageIds" id="checkbox_${entry.key.package_id}"
								value="${entry.key.package_id}" onchange="checkboxChanged(${entry.key.package_id})" ${entry.value ? "checked" : ""} >
							<label class="form-check-label"><c:out value="${entry.key.package_name}" /></label>
						</div>
						</c:forEach>
					</div>

					<br>

					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Package Name</th>
								<th scope="col">Channel Details</th>
								<th scope="col">Total Package Cost</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${purchaseMap}" var="entry" >
							<tr id="table_row_${entry.key.package_id}" style="display: none">
								<td><c:out value="${entry.key.package_name}" /></td>
								<td>
									<table class="table table-bordered">
										<th>Channel Name</th>
										<th>Channel Cost</th>
										<c:forEach items="${packageMap.get(entry.key.package_id)}" var="channel" >
										<tr>
											<td>${channel.channel_name}</td>
											<td>${channel.channel_charge}</td>
										</tr>
										</c:forEach>
									</table>
								</td>
								<td><c:out value="${entry.key.package_cost}" /></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="form-group">
						<label for="exampleInputEmail1">Total Amount</label> <input
							type="text" class="form-control" id="totalAmount"
							aria-describedby="emailHelp" disabled>
					</div>
					<button type="submit" class="btn btn-primary">Purchase Additional Packages</button>
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
</html>