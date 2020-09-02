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
	function deleteThis(record) {
		if (confirm("are you sure you want to delete this record")) {
			window.location.href = "${pageContext.request.contextPath}/ChannelServlet?deleteId="
					+ record;
		} else {
			console.log("nope")
		}
	}
</script>

<meta charset="ISO-8859-1">
<title>Channel List</title>
</head>
<body>
	<c:set var="user_type" scope="session" value="${user_type}" />
	<c:choose>
		<c:when
			test="${user_type == 'admin' || user_type == 'operator'|| user_type == 'customer'}">
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
						<c:forEach var="channel" items="${channels}">
							<tr>
								<td><c:out value="${channel.channel_name}" /></td>
								<td><c:out value="${channel.channel_band}" /></td>
								<td><c:out value="${channel.video_carrier_frequency}" /></td>
								<td><c:out value="${channel.audio_carrier_frequency}" /></td>
								<td><c:out value="${channel.channel_charge_type}" /></td>
								<td><c:out value="${channel.channel_charge}" /></td>
								<td class="noBorder"><a
									href="${pageContext.request.contextPath}/GetChannelServlet?id=${channel.channel_id}"><svg
											width="1em" height="1em" viewBox="0 0 16 16"
											class="bi bi-pencil-square" fill="currentColor"
											xmlns="http://www.w3.org/2000/svg">
  <path
												d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
  <path fill-rule="evenodd"
												d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
</svg></a></td>
								<td class="noBorder"><a type="button" name="delBtn"
									${deleteChannel_view}
									onclick="deleteThis('${channel.channel_id}')"><svg
											width="1em" height="1em" viewBox="0 0 16 16"
											class="bi bi-x-square" fill="red"
											xmlns="http://www.w3.org/2000/svg">
								  <path fill-rule="evenodd"
												d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
								  <path fill-rule="evenodd"
												d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
								</svg></a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<jsp:include page="./menu.jsp" />
			<h1 style="text-align: center">
				<a href="/BravoTV/login.jsp">Please Login With Your
					Email/Password</a>
			</h1>
		</c:otherwise>
	</c:choose>
</body>

<script type=text/javascript>
	/* function deleteFunc(i){
	 if (confirm('Would you like to delete this Channel?')) {
	 $.ajax({
	 type: "POST",
	 data: {
	 reqDelete: true,
	 id: i
	 },
	 url: "ChannelServlet",
	 success: function(data){
	 location.reload();
	 }
	
	 }); 
	
	 }
	 else
	 {
	 //do nothing
	 }
	
	 } */
</script>
</html>