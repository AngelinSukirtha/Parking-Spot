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
		<h1 style="color: black;">TRANSACTION DETAILS</h1>
	</div>
	<table border="1">
		<tr style="background-color: rgb(253, 220, 54); height: 40px;">
			<th style="color: black;">User Id</th>
			<th style="color: black;">Price</th>
			<th style="color: black;">Payment Method</th>
			<th style="color: black;">Transaction Time</th>
			<th style="color: black;">Payment Status</th>
		</tr>
		<%
		List<Transactions> list = (ArrayList<Transactions>) request.getAttribute("list");
		if (list != null) {
			for (Transactions transaction : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=transaction.getUserId()%></td>
			<td><%=transaction.getPrice()%></td>
			<td><%=transaction.getPaymentMethod()%></td>
			<td><%=transaction.getTransactionTime()%></td>
			<td><%=transaction.getPaymentStatus()%></td>
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
