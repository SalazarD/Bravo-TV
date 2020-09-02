<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Channel Package</title>
</head>

<script src="https://code.jquery.com/jquery-3.3.1.min.js">
	
</script>
<script type="text/javascript">
	var totalSelectValue=0;
	function addOption() {
		var newCategory=prompt("Please Enter a Name for the new Category");
		optionText = newCategory;
		optionValue = newCategory;

		$('#select1').append(new Option(optionText, optionValue));
	}
	function showPrice(){
		totalSelectValue=0;
		var sel = document.getElementById('select2');
	    var channelPrice=[];
	    for ( var i = 0, len = sel.options.length; i < len; i++ ) {
	       if(sel.options[i].selected===true){
	    	   var splitere=sel.options[i].value.lastIndexOf('$')	
	    	   var channelprice=sel.options[i].value.substring(splitere+1)
	    	   channelPrice.push(parseInt(channelprice))
	       }
	    }
	    for(var i=0; i<channelPrice.length;i++){
	    	totalSelectValue=totalSelectValue+channelPrice[i]
	    }
		document.getElementById('total').value=totalSelectValue;
	}
</script>

<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'}">
	<jsp:include page="./menu.jsp" />
	<form name="ChannelPackage"
		action="${pageContext.request.contextPath}/ChannelPack/Add"
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
								<c:forEach var="category" items="${allCategory}">
									<option>
										<c:out value="${category}" />
									</option>
								</c:forEach>
								
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
						<label for="exampleFormControlSelect1">Select Channels</label> 
						<select class="form-control" name="allAvailableChannel" id="select2" required multiple onchange="showPrice()">
							<c:forEach var="channel" items="${allChannel}">
								<option id="channelOption">
									<c:out value="${channel.getChannel_id()}."/>		
									<c:out value="${channel.getChannel_name()} - "/>
									$<c:out value="${channel.getChannel_charge()}"/>		
								</option>								
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Package Cost</label> <input
							type="number" class="form-control" name="packageCostt"
							aria-describedby="emailHelp" placeholder="Enter Package Cost"
							id="total" required>
					</div>

					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Package
							available from Date</label>
						<div class="col-10">
							<input class="form-control" type="date" value=""
								id="example-date-input" name="available_date">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-date-input" class="col-2 col-form-label">Package
							available to Date</label>
						<div class="col-10">
							<input class="form-control" type="date" value=""
								id="example-date-input" name="to_date">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Added by Default</label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="addByDefault"
								value="True" required> <label class="form-check-label"
								for="exampleRadios1">Yes</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="addByDefault"
								value="False"> <label class="form-check-label"
								for="exampleRadios1">No</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
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