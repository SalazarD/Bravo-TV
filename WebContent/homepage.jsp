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

<title>Homepage</title>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	
	<c:choose>
  		<c:when test="${user_type == 'admin' || user_type == 'customer' || user_type == 'operator'}">
		<jsp:include page="./menu.jsp" />
			<h1 style="text-align: center">
			Welcome <c:out value = "${user_type}"/>
			</h1>
  		</c:when>
  		<c:otherwise>
		<jsp:include page="./menu.jsp" />
  		</c:otherwise>
	</c:choose>

</body>
</html>