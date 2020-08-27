<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
	

<style>

.dropdown:hover>.dropdown-menu {
	  display: block;
	}

</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand"
		href="${pageContext.request.contextPath}/homepage.jsp">BravoTV</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Channels</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/addChannel.jsp">Add
						Channel</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/channelList.jsp">Channel
						List</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Channel
					Packages</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/channelPackage.jsp">Add
						Channel Package</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/additionalPackages.jsp">Purchase
						Additional Package</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">SetTop
					Box</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/setTopBox.jsp">Add
						SetTop Box</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/C_PurchaseBox.jsp">Purchase
						SetTop Box</a>
				</div></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/PackageCharging.jsp">Package
					& Charging</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Customer </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/Customer/Add">Register
						Customer</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/Customer/List">Customer
						List</a>
				</div></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/operator.jsp">Register
					Operator</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/retailerRegistration.jsp">Register
					Retailer</a></li>

		</ul>
	</div>
</nav>