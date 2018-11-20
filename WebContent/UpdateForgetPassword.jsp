<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
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
<h2><b>Account Number:${accNo}</b></h2>
<br/>
<sf:form action="changeForgetPassword.obj" method="post">
<center>
<h2>Set new password here</h2>
Enter New password:<input type="password" placeholder="New Password" name="newPassword"><br/><br/>
Re-enter Password:<input type="password" placeholder="Re-enter Password" name="confirmNewPassword"><br/><br/>
<tr><td><input type="hidden" name="accNo" value=${accNo}>
<input type="submit"  value="Submit" >
</center>
</sf:form>
<center><h2><a href="enter.obj">Click Here</a> to Login Page</h2></center>
</body>
</html>