<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home Page</title>
<style>
table {
	margin-top: 200px;
	margin-left: 500px;
	margin-right: 500px;
	border: 3px solid green;
	padding-right: 50px;
}

label {
	margin: 100px;
}

input {
	padding: 5px;
	margin: 10px;
}
</style>
</head>

<body>

	<table>
		<th>Add Employee Functionality</th>

		<form:form method="POST" modelAttribute="/employees">
			<tr>
				<div>
					<td><label for="firstname">First Name</label></td>
					<td><input type="text" name="firstname" id="firstname">
					</td>
				</div>
			</tr>
			<tr>
				<div>
					<td><label for="lastname">Last Name</label></td>
					<td><input type="text" name="lastname" id="lastname">
					</td>
				</div>
			</tr>
			<tr>
				<div>
					<td><label for="address">Addres</label></td>
					<td><input type="text" name="address" id="address"></td>
				</div>
			</tr>
			<tr>
				<div>
					<td><label for="emailid">Email Id</label></td>
					<td><input type="email" name="emailid" id="emailid"></td>
				</div>
			</tr>
			<tr>
				<div>
					<td><label for="mobilenumber">Mobile Number</label></td>
					<td><input type="text" name="mobilenumber" id="mobilenumber">
					</td>
				</div>
			</tr>
			<tr>
				<div>
					<td><label for="username">Email Id</label></td>
					<td><input type="email" name="username" id="username">
					</td>
				</div>
			</tr>
			<tr>
				<div>
					<td></td>
					<td><input type="button" value="Create Employee"></td>
				</div>
			</tr>
		</form:form>
	</table>

</body>

</html>