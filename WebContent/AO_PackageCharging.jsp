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
	<c:set var="user_type" scope="session" value="${user_type}" />
	<c:choose>
		<c:when
			test="${user_type == 'admin' || user_type == 'operator'|| user_type == 'customer'}">
			<jsp:include page="./menu.jsp" />
			<form name="GenerateBill"
				action="${pageContext.request.contextPath}/GenerateBillServlet"
				method="POST">
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
								<th scope="col">Bills</th>
								<th scope="col">Customer Name</th>
								<th scope="col">Stb Type</th>
								<th scope="col">Other Charges</th>
								<th scope="col">Tax</th>
								<th scope="col">Total Amount</th>
								<th scope="col">Generation Date</th>
								<th scope="col">Due Date</th>
								<th scope="col">View</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bill" items="${bills}">
								<tr>
									<!-- <th scope="row" class="count"></th> -->
									<td><c:out value="${bill.bill_id}" /></td>
									<td><c:out value="${bill.customer_name}" /></td>
									<td><c:out value="${bill.stb_type}" /></td>
									<td><c:out value="${bill.other_charges}" /></td>
									<td><c:out value="${bill.tax}" /></td>
									<td><c:out value="${bill.total_amount}" /></td>
									<td><c:out value="${bill.generation_date}" /></td>
									<td><c:out value="${bill.due_date}" /></td>
									<td class="noBorder">
										<!--  /Book calls a servlet to fetch book by ID and populate EditBook.jsp -->
										<a class="button"
										href="${pageContext.request.contextPath}/GenerateBillServlet?id=${bill.bill_id}"><svg
												width="1em" height="1em" viewBox="0 0 16 16"
												class="bi bi-pencil-square" fill="currentColor"
												xmlns="http://www.w3.org/2000/svg">
  <path
													d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
  <path fill-rule="evenodd"
													d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
</svg></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<jsp:include page="./menu.jsp" />
			<h1 style="text-align: center">
				<a href="/BravoTV/login.jsp">Please Login With Your
					Email/Password</a>
			</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>