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
  overflow: hidden;"><h2><b>Account Number:${accNo}</b></h2>


<sf:form method="post" action="changePasswordAction.obj" modelAttribute="user">
<center><table><tr><td><center>Old Password&emsp;&emsp;&emsp;&emsp;: <input type="password" id="textbox" placeholder="Old Password" name="oldPassword"/></center></td>
<tr><td><center><sf:errors style="color:red" path="oldPassword"></sf:errors></center></td></tr>
<tr><td><center>New Password&emsp;&emsp;&emsp;&emsp;: <input type="password" id="textbox" placeholder="New Password" name="newPassword"/></center></td>
<tr><td><center><sf:errors style="color:red" path="newPassword"></sf:errors></center></td></tr>
<tr><td><center>Confirm New Password : <input type="password" id="textbox" placeholder="Re-enter new Password" name="new1Password"/></center></td>
<tr><td><center><sf:errors style="color:red" path="new1Password"></sf:errors></center></td></tr>
<tr><td><input type="hidden" name="accNo" value=${accNo}>
<tr><td><input type="hidden" name="password" value=${password}></table></center>
<center><input type="submit" value="Update"></center>
</sf:form>

<br><br>
<center><a href="Try.obj?accNo=${accNo}"><h3>Home</h3></a></center>
</body>
</html>