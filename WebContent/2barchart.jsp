<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			var data = ${jsonString}
			for (var i = 0; i < data.Data.length; i++) {

				obj.push({
					label : data.Data[i].month,
					y : data.Data[i].count
				});

			}
			
			// create an instance of a pie chart
			var chart = anychart.bar();
			// set the data
			chart.data(obj);
			// set chart title
			chart.title("Month-wise total Operators created for last 12 months");
			// set the container element 
			chart.container("container");
			// initiate chart display
			chart.draw();
			
	
			console.log(obj);


		}
	</script>


	<div id="container"  style="height: 300px; width: 100%;"></div>
</body>
</html>