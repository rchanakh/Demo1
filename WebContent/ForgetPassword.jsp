<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(Password.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;">
<form action="PasswordAction.obj" method="post" modelAttribute="statement">
<center>
<h2>Please give your Account Number</h2><br/>
Account No:<input type="text" name="accNo"  placeholder="Account No"><br/><br/>
<input type="submit"  value="Submit">
<h3><a href="enter.obj">Click Here</a> to Login Page</h3>
</center>
</form>
</body>
</html>