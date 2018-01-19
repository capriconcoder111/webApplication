<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Search Page</title>
</head>
<body>

	<form action="SearchServlet" method="post">
		Employee ID: <input type="text" name="employeeId"><br>
		<input type="submit" value="submit">	
	</form>
	
	${message}
	<table border="1|0">
	
		<tr>
			<th>id</th>
			<th>name</th>
			<th>salary</th>
			<th>year</th>
			<th>age</th>
		</tr>
		<tr>
			<td>${id}</td>
			<td>${name}</td>
			<td>${salary}</td>
			<td>${year}</td>
			<td>${age}</td>
		</tr>
	</table>

</body>
</html>