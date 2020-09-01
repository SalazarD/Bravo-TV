<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
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
<title>Update Channel</title>
</head>
<body>
	<c:set var = "user_type" scope = "session" value = "${user_type}"/>
	<c:choose>
  	<c:when test="${user_type == 'admin' || user_type == 'operator'}">
  	
	<jsp:include page="./menu.jsp" />
	<form name="EditChannel"
		action="${pageContext.request.contextPath}/ChannelServlet" method="POST">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<h3 style="text-align: center">Update Channel</h3>
					<br>
					<div class="form-group">
						<label for="exampleInputEmail1">Channel Name</label> <input
							type="text" class="form-control" name="channelName"
							aria-describedby="emailHelp" value="${channel.channel_name}"
							required>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Channel Band</label> <select
							class="form-control" name="channelBand" required>
							<option value="band1" ${channel.channel_band == 'band1' ? 'selected' : ''}>Band I</option>
							<option value="band2" ${channel.channel_band == 'band2' ? 'selected' : ''}>Band II</option>
							<option value="band3" ${channel.channel_band == 'band3' ? 'selected' : ''}>Band III</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Video Carrier Frequency
							MHz</label> <input type="text" class="form-control" name="video"
							aria-describedby="emailHelp"
							value="${channel.video_carrier_frequency}" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Audio Carrier Frequency
							MHz</label> <input type="text" class="form-control" name="audio"
							aria-describedby="emailHelp"
							value="${channel.audio_carrier_frequency}" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Channel Charge Type</label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="chargeType"
								value="fta" ${channel.channel_charge_type == 'fta' ? 'checked' : ''} required> <label class="form-check-label"
								for="exampleRadios1">FTA</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="chargeType"
								value="paid" ${channel.channel_charge_type == 'paid' ? 'checked' : ''} required> <label class="form-check-label"
								for="exampleRadios1">Paid</label>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Channel Charge</label> <input
							type="text" class="form-control" name="charge"
							aria-describedby="emailHelp" value="${channel.channel_charge}"
							required>
					</div>
					
					<input type="hidden" name="channelId" value="${channel.channel_id}">
					<input type="hidden" name="action" value="update" />
					<button type="submit" class="btn btn-primary">Update</button>
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
  		</c:otherwise>
	</c:choose>
</body>
</html>