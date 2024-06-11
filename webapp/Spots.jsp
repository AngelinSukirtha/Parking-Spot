<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Location Choosing Page</title>
<style>
body {
	margin: 0;
	padding: 0;
}

.container {
	margin-left: 60px;
	display: flex;
	flex-wrap: wrap;
	justify-content: left;
	align-items: center;
	height: 100vh;
}

.grid {
	display: grid;
	grid-template-columns: repeat(2, 100px);
	grid-gap: 20px;
}

.cell {
	width: 100px;
	height: 100px;
	border: 1px solid black;
	cursor: pointer;
	display: flex;
	justify-content: center;
	align-items: center;
}

.cell:hover {
	background-color: #f0f0f0;
}

.grid1 {
	margin-left: 150px;
	display: grid;
	grid-template-columns: repeat(3, 100px);
	grid-gap: 8px;
}

.cell1 {
	width: 80px;
	height: 100px;
	border: 1px solid black;
	cursor: pointer;
	display: flex;
	justify-content: center;
	align-items: center;
}

.cell1:hover {
	background-color: #f0f0f0;
}

.grid2 {
	margin-left: 150px;
	display: grid;
	grid-template-columns: repeat(2, 100px);
	grid-gap: 75px;
}

.cell2 {
	width: 150px;
	height: 100px;
	border: 1px solid black;
	cursor: pointer;
	display: flex;
	justify-content: center;
	align-items: center;
}

.cell2:hover {
	background-color: #f0f0f0;
}

.vehicle-buttons {
	margin-top: 50px;
	display: flex;
	justify-content: space-between;
	margin-bottom: 20px;
}

.vehicle-button {
	padding: 10px 20px;
	border: none;
	cursor: pointer;
	background-color: rgb(253, 220, 54);
	color: black;
	border-radius: 5px;
}

.checkbox-cell {
	display: none;
}

.checkbox-cell:checked+label.cell, .checkbox-cell:checked+label.cell1,
	.checkbox-cell:checked+label.cell2 {
	background-color: rgb(90, 209, 90);
}
</style>
</head>
<body>

	<div class="vehicle-buttons">
		<button class="vehicle-button" style="margin-left: 140px;">
			<i class="fas fa-car"></i>CAR
		</button>
		<button class="vehicle-button" style="margin-right: 70px;">
			<i class="fas fa-bicycle"></i>BIKE
		</button>
		<button class="vehicle-button" style="margin-right: 160px;">
			<i class="fas fa-truck"></i>TRUCK
		</button>
	</div>
	<form id="parkingForm" action="ParkingSpotsServlet" method="post">
		<div class="container">
			<div class="grid">
				<%
				for (int i = 1; i <= 20; i++) {
				%>
				<input type="checkbox" class="checkbox-cell" id="C<%=i%>"> <label
					for="C<%=i%>" class="cell">C<%=i%></label>
				<%
				}
				%>
			</div>

			<div class="grid1">
				<%
				for (int i = 1; i <= 33; i++) {
				%>
				<input type="checkbox" class="checkbox-cell" id="B<%=i%>"> <label
					for="B<%=i%>" class="cell1">B<%=i%></label>
				<%
				}
				%>
			</div>

			<div class="grid2">
				<%
				for (int i = 1; i <= 14; i++) {
				%>
				<input type="checkbox" class="checkbox-cell" id="T<%=i%>"> <label
					for="T<%=i%>" class="cell2">T<%=i%></label>
				<%
				}
				%>
			</div>
			<div style="text-align: center; margin-top: 50px;">
				<button
					style="padding: 10px 20px; border: none; cursor: pointer; background-color: rgb(253, 220, 54); color: black; border-radius: 5px; margin-bottom: 50px; margin-left: 500px;">
					Book Now</button>
			</div>
		</div>
	</form>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			const checkboxes = document.querySelectorAll('.checkbox-cell');
			const parkingForm = document.getElementById('parkingForm');

			parkingForm.addEventListener('submit', function(event) {
				event.preventDefault();

				let selectedCells = [];
				checkboxes.forEach(function(checkbox) {
					if (checkbox.checked) {
						selectedCells.push(checkbox.id);
					}
				});

				if (selectedCells.length === 0) {
					alert("Please select at least one spot.");
					return;
				}

				const selectedSpotsInput = document.createElement('input');
				selectedSpotsInput.type = 'hidden';
				selectedSpotsInput.name = 'selectedSpots';
				selectedSpotsInput.value = JSON.stringify(selectedCells);
				parkingForm.appendChild(selectedSpotsInput);

				parkingForm.submit();
			});
		});
	</script>
</body>
</html>
