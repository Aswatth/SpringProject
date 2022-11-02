<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Mail-Log in</title>
</head>
<body>
<h1>Login :)</h1>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="login" method="POST" id="loginForm">
<table>
<tr>
<td>
Username:
</td>

<td>
<input type="text" name="username" pattern="[a-zA-Z]+[a-zA-Z0-9]+@myMail.com" required="required">
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
<td>
<input type="submit" name="submit" value="Submit" >
</td>

</table>
</form>

</body>
</html>