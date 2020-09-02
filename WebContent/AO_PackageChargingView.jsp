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
	    checkboxChanged("${entry.key.package_id}");
	    </c:forEach>
		updateTotal();
	};
</script>


<meta charset="ISO-8859-1">
<title>View Bill For Post Paid Customer</title>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'}">
	<jsp:include page="./menu.jsp" />
	<form name="GenerateBill"
		action="${pageContext.request.contextPath}/GenerateBillServlet"
		method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">View Bill For Post Paid
							Customer</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">Customer Name</label> <input
							type="text" name="emailC" id="emailC" class="form-control"
							aria-describedby="emailHelp" value="${bill.customer_name}"
							readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Set Top Box Type</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${bill.stb_type}" readonly>
					</div>



					<div class="container">
						<div class="card">
							<div class="card-body">
								<h5 style="text-align: center">Package Details</h5>
								<br>
								<div>
									<c:forEach items="${purchaseMap}" var="entry">
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="checkbox"
												name="packageIds" id="checkbox_${entry.key.package_id}"
												value="${entry.key.package_id}"
												onchange="checkboxChanged(${entry.key.package_id})"
												${entry.value ? "checked" : ""}> <label
												class="form-check-label"><c:out
													value="${entry.key.package_name}" /></label>
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
										<c:forEach items="${purchaseMap}" var="entry">
											<tr id="table_row_${entry.key.package_id}"
												style="display: none">
												<td><c:out value="${entry.key.package_name}" /></td>
												<td>
													<table class="table table-bordered">
														<th>Channel Name</th>
														<th>Channel Cost</th>
														<c:forEach items="${packageMap.get(entry.key.package_id)}"
															var="channel">
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
							</div>
						</div>
					</div>


					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">Other Chargers</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${bill.other_charges}" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Tax</label> <input type="text"
							class="form-control" aria-describedby="emailHelp"
							value="${bill.tax}" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Total Amount</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${bill.total_amount}" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Generation Date</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${bill.generation_date}" readonly>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Due Date</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							value="${bill.due_date}" readonly>
					</div>

					<div class="form-group">
						<input type="text" id="totalAmount" class="form-control"
							aria-describedby="emailHelp" value="${bill.total_amount}" hidden>
					</div>

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