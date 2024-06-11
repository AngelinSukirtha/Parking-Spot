<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transaction Confirmation</title>
<style>
body {
	background-image:
		url('https://images.pexels.com/photos/39811/pexels-photo-39811.jpeg?cs=srgb&dl=pexels-veeterzy-39811.jpg&fm=jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	margin-top: 100px;
}

.container {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	background-color: #222;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1, h2 {
	text-align: center;
	color: white;
}

.confirmation {
	text-align: center;
	margin-top: 30px;
}

.confirmation p {
	margin-bottom: 10px;
	color: white;
}

.btn {
	display: inline-block;
	padding: 10px 20px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<form action="TransactionServlet" method="post">
			<h2>Thank You for Your Reservation!</h2>
			<div class="confirmation">
				<p>Your transaction for a parking spot has been confirmed.</p>
				<p>Reservation Details</p>
				<p>
					Name:
					<%=request.getAttribute("userName")%></p>
				<p>
					Email:
					<%=request.getAttribute("phoneNumber")%></p>
				<p>
					Phone:
					<%=request.getAttribute("email")%></p>
			</div>
			<div class="confirmation">
				<p>
					Your payment of $.
					<%=request.getAttribute("price")%>
					has been processed.
				</p>
				<p>
					Transaction time is
					<%=request.getAttribute("transactionTime")%>
				</p>
			</div>
			<div class="confirmation">
				<a href="Index.html" class="btn">Back to Home</a>
			</div>
		</form>
	</div>

</body>
</html>