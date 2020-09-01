<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Insert title here</title>
</head>
<body>
<body>
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
									<a class="btn btn-primary" href="/BravoTV/deductBalance.jsp">Deduct
										Balance</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>