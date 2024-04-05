<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Home Page</title>
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
		<th></th>
		<form action="" method="post">
			<tr>
				<div>
					<td><label for="name">First Name</label></td>
					<td><input type="text" name="name" id="name"></td>
				</div>
			</tr>
			<tr>
				<div>
					<td><label for="dept">Department Name</label></td>
					<td><input type="text" name="dept" id="dept"></td>
				</div>
			</tr>
			<tr>
				<div>
					<td></td>
					<td><input type="button" value="Create User"></td>
				</div>
			</tr>
		</form>
	</table>
</body>
</html>