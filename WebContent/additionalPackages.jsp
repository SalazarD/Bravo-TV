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
	function displayDetail(){
		var totalCost=0;
        var markup = "<td></td>";

        var obj = {};
		$('.pkName').each(function(){
		    var text = $.trim($(this).text());
		    if(obj[text]){
		    	$(this).replaceWith(markup);
		    } else {
		        obj[text] = true;
		    }
		})
		$('.pkCost').each(function(){
		    var text = $.trim($(this).text());
		    if(obj[text]){
		    	$(this).replaceWith(markup);
		    } else {
		        obj[text] = true;
		    }
		})
		$('.pkDate').each(function(){
		    var text = $.trim($(this).text());
		    if(obj[text]){
		    	$(this).replaceWith(markup);
		    } else {
		        obj[text] = true;
		    }
		})
		jQuery("input[name='category']:checked").each(function(i){
			var elems = document.getElementsByClassName($(this).val());
			for (var i=0;i<elems.length;i+=1){
				var costElems=elems[i].getElementsByClassName("pkCost")
				for(var x=0; x<costElems.length;x++){
					totalCost=totalCost+parseInt(costElems[x].textContent);
				}
				elems[i].style.display = 'table-row';
				}
			    
		});
		document.getElementById('total').value=totalCost;
		jQuery("input[name='category']:not(:checked)").each(function(i){
			var elems = document.getElementsByClassName($(this).val());
			for (var i=0;i<elems.length;i+=1){
				  elems[i].style.display = 'none';
				}	        
			});
		

	}
	function add_number() {		
		var elems = document.getElementsByClassName("pkCost");
		var total=0;
		for (var i=0;i<elems.length;i+=1){
		}
		document.getElementById("total").value = total;
	}
</script>
<meta charset="ISO-8859-1">
<title>Additional Packages</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<form name="AdditionalPackages"
		action="${pageContext.request.contextPath}/ChannelPack/PurchasePackage"
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
									<c:forEach var="addBydefaultPackage" items="${addByDefaultList}">
										<tr>
											<td>
											<c:out value="${addBydefaultPackage.getPackage_name()}"/>			
											</td>
											<td>
											<c:out value="${addBydefaultPackage.getPackage_cost()}"/>			
											</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
					</table>

					<button type="submit" class="btn btn-primary">Search More
						Packages</button>
					<br> <br>

					<div>
						<c:forEach var="notAddByDefault" items="${notAddByDefaultList}">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="checkbox" onchange="displayDetail()" 
										   name="category" value="${notAddByDefault.getPackage_name()}">
									<label class="form-check-label" >
										<c:out value="${notAddByDefault.getPackage_name()}"/>													
									</label>
								</div>
						</c:forEach>
					</div>
					<br>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Package Name</th>
								<th scope="col">Channel Details</th>
								<th scope="col">Package Purchase Date</th>
								<th scope="col">Total Package Cost</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="mappedPackage" items="${mappedPackage}">
									<tr class="${mappedPackage.getPackage_name()}" style="display:none;">
										<td class="pkName">
											<c:out value="${mappedPackage.getPackage_name()}"/>			
										</td>
										
										<td>
											<c:out value="${mappedPackage.getChannel_name()}"/>			
										</td>
										<td class="pkDate">
											<script>
											var d= new Date()
											document.write(d.toLocaleDateString("en-US"));
											</script>
										</td>
										<td class="pkCost">
											<c:out value="${mappedPackage.getPackage_cost()}"/>			
										</td>
									</tr>										
							</c:forEach>

							<tr id="helloD" style="display: none">
								<td>Drama</td>
								<td>
									<table class="table table-bordered">
										<th>Channel Name</th>
										<th>Channel Cost</th>
										<tr>
											<td>Suits</td>
											<td>2</td>
										</tr>
										<tr>
											<td>Friends</td>
											<td>1</td>
										</tr>
									</table>
								</td>
								<td>10/20/2016</td>
								<td>3</td>
							</tr>
						</tbody>
					</table>

					<div class="form-group">
						<label for="exampleInputEmail1">Total Amount</label> <input
							type="text" class="form-control" name="totalAmount" id="total"
							onClick="add_number();" aria-describedby="emailHelp"
							placeholder="Click to see the total">
					</div>
					<button type="submit" class="btn btn-primary">Purchase
						Additional Packages</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>