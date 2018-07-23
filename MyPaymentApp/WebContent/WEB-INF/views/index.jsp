<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Payment App</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table, th, td {
    border: collapse;
    border-spacing: 15px;
    padding:30px;
}
.btn
{
	width:500px;
	hight:10px;
}
</style>
</head>
<body>
<div align="center" style="padding-top: 20px">
<h1>My Payment App</h1>
</div>
	<div align="center" style="padding-top: 100px">
		<table>
			<tr>
				<td><a class="btn btn-primary" href="createaccount">Create
						New Account</a></td>
				<td><a class="btn btn-primary" href="showbalance">Show
						Current Balance</a><br></td>
			</tr>
			<tr>
				<td><a class="btn btn-primary" href="fundtransfer">Fund
						Transfer</a></td>
				<td><a class="btn btn-primary" href="deposit">Deposit</a></td>

			</tr>
			<tr>
				<td><a class="btn btn-primary" href="withdraw">Withdraw</a></td>
			</tr>
		</table>
	</div>
</body>
</html>