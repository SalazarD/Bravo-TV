<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'|| user_type == 'customer'}">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand"
		href="${pageContext.request.contextPath}/homepage.jsp">BravoTV</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarNav" >
		<ul class="navbar-nav"${menu_view}>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >Channels</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/addChannel.jsp" ${add_channel_view}>Add
						Channel</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/channelList.jsp"${channel_list_view}>Channel
						List</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Channel
					Packages</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/ChannelPack/Add"${add_package_view}>Add
						Channel Package</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/PurchasePackage"${package_purchase_view}>Purchase
						Additional Package</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">SetTop
					Box</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/setTopBox.jsp"${add_stb_view}>Add
						SetTop Box</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/P_SetupBox"${stb_purchase_view}>Purchase
						SetTop Box</a>
				</div></li>

			<li class="nav-item" ${charge_view}><a class="nav-link"
				href="${pageContext.request.contextPath}/PackageCharging.jsp">Package
					& Charging</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Customer </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/customer.jsp"${register_customer_view}>Register
						Customer</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/Customer/List">Customer
						List</a>
				</div></li>
				
			<li class="nav-item dropdown" ${register_operator_list_view}><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Operator </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/operator.jsp"${register_operator_view}>Register
						Operator</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/OperatorReg/List">Operator
						List</a>
				</div></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/retailerRegistration.jsp"${register_retailer_view}>Register
					Retailer</a></li>

		</ul>
	</div>
	<div>
		<a class="btn btn-danger"	href="/BravoTV/login.jsp">Logout</a>
	</div>
</nav>
		</c:when>
  		<c:otherwise>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/homepage.jsp">BravoTV</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</nav>  		
  			<h1 style="text-align: center">
				<a href="/BravoTV/login.jsp">Please Login With Your Username/Password</a>
			</h1>
  		</c:otherwise>
	</c:choose>