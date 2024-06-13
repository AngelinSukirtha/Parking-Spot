<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.chainsys.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Parking Spots Management</title>
<style>
.center {
	text-align: center;
	margin: auto;
	font-size: 15px;
}

table {
	margin-top: 20px;
	margin-left: 100px;
	border-collapse: collapse;
	width: 80%;
}
</style>
</head>
<body>
	<div class="center">
		<h1 style="color: black;">PARKING SPOTS DETAILS</h1>
	</div>
	<table border="1">
		<tr style="background-color: rgb(253, 220, 54); height: 40px;">
			<th style="color: black;">User Id</th>
			<th style="color: black;">Location Name</th>
			<th style="color: black;">Address</th>
			<th style="color: black;">Vehicle Type</th>
			<th style="color: black;">Spot Number</th>
			<th style="color: black;">Spot Status</th>
		</tr>
		<%
		List<ParkingSpots> list = (ArrayList<ParkingSpots>) request.getAttribute("list");
		if (list != null) {
			for (ParkingSpots parkingSpots : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=parkingSpots.getUserId()%></td>
			<td><%=parkingSpots.getLocationName()%></td>
			<td><%=parkingSpots.getAddress()%></td>
			<td><%=parkingSpots.getVehicleType()%></td>
			<td><%=parkingSpots.getSpotNumber()%></td>
			<td><%=parkingSpots.getSpotStatus()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br>
	<div style="margin-left: 100px;">
		<form action="Admin.jsp">
			<button type="submit"
				style="border-color: rgb(253, 220, 54); background-color: rgb(253, 220, 54)"
				title="logout">Logout</button>
		</form>
	</div>
</body>
</html>
