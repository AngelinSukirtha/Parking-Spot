<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.chainsys.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Reservation Approval</title>
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
		<h1 style="color: black;">RESERVATION DETAILS</h1>
	</div>
	<table border="1">
		<tr style="background-color: rgb(253, 220, 54); height: 40px;">
			<th style="color: black;">User Id</th>
			<th style="color: black;">Number Plate</th>
			<th style="color: black;">Start Date And Time</th>
			<th style="color: black;">End Date And Time</th>
			<th style="color: black;">Reservation Status</th>
		</tr>
		<%
		List<Reservations> list = (ArrayList<Reservations>) request.getAttribute("list");
		if (list != null) {
			for (Reservations reservation : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=reservation.getUserId()%></td>
			<td><%=reservation.getNumberPlate()%></td>
			<td><%=reservation.getStartDateTime()%></td>
			<td><%=reservation.getEndDateTime()%></td>
			<td><%=reservation.getReservationStatus()%></td>
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
