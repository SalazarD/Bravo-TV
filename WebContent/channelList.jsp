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
<title>Channel List</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div class="card-body">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Channel Name</th>
					<th scope="col">Channel Band</th>
					<th scope="col">Video CF MHz</th>
					<th scope="col">Audio CF MHz</th>
					<th scope="col">Channel Charge Type</th>
					<th scope="col">Channel Charge</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>HBO</td>
					<td>Band I</td>
					<td>1</td>
					<td>2</td>
					<td>Paid</td>
					<td>10</td>
					<td class="noBorder"><a
						href="${pageContext.request.contextPath}/editChannel.jsp"><button
								type="button" class="btn btn-primary">Edit</button></a></td>
					<td class="noBorder">
						<button type="button" class="btn btn-primary">Delete</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>