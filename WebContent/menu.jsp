<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<nav class="navbar navbar-expand-lg navbar-dark"
	style="background-color: #563d7c;">
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<div class="btn-group" role="group" aria-label="Basic example">
			<ul class="navbar-nav mr-auto">

				<div class="input-group-addon">
					<a class="nav-link"
						href="${pageContext.request.contextPath}/homepage.jsp"
						style="color: white"><button type="button"
							class="btn btn-outline-light">
							<i class="fa fa-home"></i>
						</button></a>
				</div>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/addChannel.jsp"
					style="color: white"><button type="button"
							class="btn btn-outline-light">Add Channel</button></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/additionalPackages.jsp"
					style="color: white"><button type="button"
							class="btn btn-outline-light">Additional Packages</button></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/channelPackage.jsp"
					style="color: white"><button type="button"
							class="btn btn-outline-light">Channel Package</button></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/C_PurchaseBox.jsp"
					style="color: white"><button type="button"
							class="btn btn-outline-light">Purchase Box</button></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/operator.jsp"
					style="color: white"><button type="button"
							class="btn btn-outline-light">Operator</button></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/customer.jsp"
					style="color: white"><button type="button"
							class="btn btn-outline-light">Customer</button></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/AO_PackageCharging.jsp"
					style="color: white"><button type="button"
							class="btn btn-outline-light">Package Charging</button></a></li>

			</ul>
		</div>
	</div>
</nav>