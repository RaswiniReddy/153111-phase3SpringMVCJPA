<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.btn-primary {
	width: 500px;
	hight: 10px;
}
</style>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
	<div align="center" style="padding-top: 20px">
		<h1>My Payment App</h1>
	</div>
	<div align="center" style="padding-top: 100px">
		Welcome Mr./Mrs. &nbsp <font size="5" style="font-weight: bold;">${customer.name}</font><br>
		Registered Mobile Number:&nbsp<b> ${customer.mobileNo}</b><br> Wallet
		Balance:&nbsp<b> ${customer.wallet.balance}</b><br>
	</div>
	<div align="center" style="padding-top: 20px">
		<button class="btn" onclick="goBack()">Back</button>
	</div>
</body>
</html>