<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<body>
<table>
<th>
</th>
<th>
Flyway
</th>
<th>
Liquibase
</th>
<tr>
<td>Compare 2 DB</td>
<td>-</td>
<td>Yes</td>
</tr>
<tr>
<td>Generates SQL</td>
<td>-</td>
<td>Yes</td>
</tr>
<tr>
<td>Rollback</td>
<td>Yes(Paid version)</td>
<td>Yes</td>
</tr>
<tr>
<td>Defining changes</td>
<td>SQL</td>
<td>SQL, XML, YAML, JSON</td>
</tr>

<tr>
<td>Preconditions</td>
<td>-</td>
<td>Yes</td>
</tr>
<tr>
<td>Ability to work with stored logic</td>
<td>-</td>
<td>Yes</td>
</tr>
</table><br><br>
<form action="userSubmit" method="get">
User details:
<input type="text" placeholder="Name" name="name" required="required">
<input type="text" placeholder="Lastname" name="lastname" required="required">
<input type="tel" placeholder="Mobile number" pattern="[0-9]{10}" name="mobile_number" required="required">
<input type="submit" value="Insert">
</form><br>
<form action="mobileSubmit" method="get">
Mobile details:
<input type="tel" placeholder="Number" pattern="[0-9]{10}" name="number" required>
<input type="text" placeholder="Model name" name="model" required>
<input type="submit" value="Insert">
</form>
${error}
</body>
</html>