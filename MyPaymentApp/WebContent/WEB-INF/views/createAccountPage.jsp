<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Account</title>
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
	padding: 5px;
}

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
		<form:form action="createCustomer" method="post"
			modelAttribute="customer">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input path="name" size="30"></form:input></td>
					<td><form:errors path="name" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><form:input path="mobileNo" size="30"></form:input></td>
					<td><form:errors path="mobileNo" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td>Wallet Balance</td>
					<td><form:input path="wallet.balance" size="30"></form:input></td>
					<td><form:errors path="wallet.balance" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Create Account" class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>
		<div align="center" style="padding-top: 20px">
			<button class="btn" onclick="goBack()">Back</button>
		</div>
	</div>
</body>
</html>