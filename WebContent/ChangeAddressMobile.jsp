<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(Home.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;">
<h2><b>Account Number:${acc}</b></h2><center><br><br>

<a href="changeAddress.obj?acc=${acc}"><h3>Change Address</h3></a>
<a href="changeMobile.obj?acc=${acc}"><h3>Change Mobile Number</h3></a>
<br><a href="Try.obj?accNo=${acc}"><h3>Home</h3></a></center>
</body>
</html>