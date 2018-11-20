<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(Background.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;">
<img src="logo.png" alt="Logo Kotak" height="150" width="500">
<center>
<h1><font face="Bookman"><b>WELCOME  TO  KOTAK  BANK</b></font></h1>
<br/><br/>
<sf:form action="loginAction.obj" method="post" modelAttribute="login">
<table>
<tr><td><center><b>User ID: </b><input type="text" placeholder="User ID" name="uname"></center></td></tr>
<tr><td><center><sf:errors style="color:red" path="uname"></sf:errors></center></td></tr>
<tr><td><center><b>Password:</b><input type="password"  placeholder="Password" name="password"></center></td></tr>
<tr><td><center><sf:errors style="color:red" path="password"></sf:errors></center></td></tr>
<tr><td align="center"><input type="submit"  value="LOGIN"></td></tr>
</table>
<br/><br/>
<a href="ForgetPassword.jsp"><b>Forgot Password?</b></a>
<br>
</sf:form>

</center>
</body>
</html>