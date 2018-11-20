<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(ChangeMobile.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;">
<h2><b>Account Number:${accNo}</b></h2>
<center>
<table>
<sf:form method="post" action="changeMobileAction.obj" modelAttribute="cust">


<tr><td>Previous Mobile number : ${mobile}</td>
<tr><td>New Mobile Number : <input type="text" id="textbox" placeholder="New mobile" name="newMobile"/></td>
<tr><td><center><sf:errors style="color:red" path="newMobile"></sf:errors></center></td></tr>
<tr><td><input type="hidden" name="accNo" value=${accNo}>
<tr><td><center><input type="submit" value="Update" ></center></td><br/>

</tr></sf:form></table><a href="Try.obj?accNo=${accNo}"><h3>Home</h3></a></center>
</body>
</html>