<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Mail-Sign Up</title>
</head>
<body>
Sign up
<form action="create" method="post" id="SIGN_UP">
<table>
<tr>
<td>
Name:
</td>
<td>
<input type="text" name="name" required="required">
</td>
</tr>
<tr>
<td>
EmailId:
</td>
<td>
<input type="text" name="mailID" placeholder="example@myMail.com" pattern="[a-zA-Z]+[a-zA-Z0-9]+@myMail.com" required="required">
</td>
</tr>
<tr>
<td>
Password:
</td>
<td>
<input type="password" name="password" required="required">
</td>
</tr>
<tr>
<td>
<input type="submit"  value="Finish">
</td>
</tr>
</table>
</form>
${error_msg}
</body>
</html>