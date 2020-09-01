<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.anychart.com/releases/8.7.1/js/anychart-base.min.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<script>
		window.onload = function() {

			var obj = [];
			fetch("./retailer_ByState.json")

			.then(function(resp) {
				return resp.json();
			}).then(function(data) {
				//console.log(data.Data[0])

				for (var i = 0; i < data.Data.length; i++) {

					obj.push({
						label : data.Data[i].state_province,
						y : data.Data[i].count
					});

				}
				
				// create an instance of a pie chart
				var chart = anychart.pie();
				// set the data
				chart.data(obj);
				// set chart title
				chart.title("Total Number of Retailers in each state");
				// set the container element 
				chart.container("container");
				// initiate chart display
				chart.draw();
			})
			console.log(obj);


		}
	</script>


	<div id="container"  style="height: 300px; width: 100%;"></div>
	
</body>
</html>