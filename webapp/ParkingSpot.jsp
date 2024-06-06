<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.chainsys.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
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
		<h1 style="color: black;">REGISTRATION DETAILS</h1>
	</div>
	<table border="1">
		<tr style="background-color: rgb(253, 220, 54); height: 40px;">
			<th style="color: black;">User Id</th>
			<th style="color: black;">Name</th>
			<th style="color: black;">Password</th>
			<th style="color: black;">Phone Number</th>
			<th style="color: black;">Email</th>
			<th style="color: black;" colspan="2">Actions</th>
		</tr>
		<%
		List<RegistrationLogin> list = (ArrayList<RegistrationLogin>) request.getAttribute("list");
		if (list != null) {
			for (RegistrationLogin registrationLogin : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=registrationLogin.getUserId()%></td>
			<td><%=registrationLogin.getUserName()%></td>
			<td><%=registrationLogin.getUserPassword()%></td>
			<td><%=registrationLogin.getPhoneNumber()%></td>
			<td><%=registrationLogin.getEmail()%></td>
			<td><input type="hidden" name="email"
				value="<%=registrationLogin.getEmail()%>"> <a
				href="Update.html?editUserName=<%=registrationLogin.getUserName()%>">
					<button type="button"
						style="border-color: rgb(253, 220, 54); background-color: white">Update</button>
			</a></td>
			<td><form action="UserServlet" method="get">
					<input type="hidden" name="delete"
						value="<%=registrationLogin.getEmail()%>">
					<button type="submit"
						style="border-color: rgb(253, 220, 54); background-color: white"
						title="delete">Delete</button>
				</form></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br>
	<div style="margin-left: 100px;">
		<form action="Index.html">
			<button type="submit"
				style="border-color: rgb(253, 220, 54); background-color: rgb(253, 220, 54)"
				title="logout">Logout</button>
		</form>
	</div>
</body>
</html>
