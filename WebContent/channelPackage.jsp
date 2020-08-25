<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Channel Package</title>
</head>

<script src="https://code.jquery.com/jquery-3.3.1.min.js">
	
</script>
<script type="text/javascript">
	function addOption() {
		optionText = 'Premium';
		optionValue = 'premium';

		$('#select1').append(new Option(optionText, optionValue));
	}
</script>

<body>
	<jsp:include page="./menu.jsp" />
	<form name="ChannelPackage" action="${pageContext.request.contextPath}/ChannelPackage"
		method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div style="margin-top: 1%; margin-bottom: 1%">
						<h3 style="text-align: center">Add Channel Package</h3>
					</div>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">Package Name</label> <input
							type="text" class="form-control" name="packageName"
							aria-describedby="emailHelp" placeholder="Enter Package Name"
							required>
					</div>
					<div class="row">
						<div class="form-group name1 col-md-4">
							<label for="exampleFormControlSelect1">Package Category</label> <select
								class="form-control" name="packageCategory" id="select1"
								required>
								<option value="sports">Sports</option>
								<option value="news">News</option>
								<option value="movies">Movies</option>
							</select>
						</div>
						<div class="form-group name2 col-md-4" style="padding-top: 3%">
							<button class="btn btn-primary" onclick="addOption()">Add
								New Category</button>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Package Charge Type</label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="packageType"
								value="fta" required> <label class="form-check-label"
								for="exampleRadios1">FTA</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="packageType"
								value="paid"> <label class="form-check-label"
								for="exampleRadios1">Paid</label>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Package Transmission Type</label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="packageTrans"
								value="HD" required> <label class="form-check-label"
								for="exampleRadios1">HD</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="packageTrans"
								value="Standard"> <label class="form-check-label"
								for="exampleRadios1">Standard</label>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Select Channels</label> <select
							class="form-control" name="packageCategory" id="select1" required>
							<option value="starMovies">Star Movies</option>
							<option value="starSports">Star Sports</option>
							<option value="hbo">HBO</option>
						</select>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Package Cost</label> <input
							type="text" class="form-control" name="packageCostt"
							aria-describedby="emailHelp" placeholder="Enter Package Cost"
							required>
					</div>

					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Package
							available from Date</label>
						<div class="col-10">
							<input class="form-control" type="date" value=""
								id="example-date-input">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Package
							available from Date</label>
						<div class="col-10">
							<input class="form-control" type="date" value=""
								id="example-date-input">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Added by Default</label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="packageTrans"
								value="Yes" required> <label class="form-check-label"
								for="exampleRadios1">Yes</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="packageTrans"
								value="No"> <label class="form-check-label"
								for="exampleRadios1">No</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>