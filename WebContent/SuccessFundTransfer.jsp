<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(updateDone.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;"><center>
<h2><b>Account Number:${accNo}</b></h2><br>
<h2>Fund Transfered Successfully<br> Your Balance : ${balance}</h2>

<a href="Try.obj?accNo=${accNo}"><h3>Home</h3></a>
</center>
</body>
</html>