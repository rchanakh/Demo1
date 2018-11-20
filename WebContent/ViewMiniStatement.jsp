<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(ViewMini.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;">
<h2><b>Account Number:${accNo}</b></h2>
<center>
<h2>Mini Statement</h2>
<h2>List of last 10 transactions</h2>
<table border=1>
<tr><th>Transaction Id<th>Description<th>Date<th>Transaction Amount<th>Account Number<th>Status</th></tr>

<c:forEach items="${list}" var="trans">
<tr>
<td>${trans.transactionId}
<td>${trans.transactionDesc}
<td>${trans.transactionDate}
<td>${trans.transactionAmount}
<td>${trans.accountNo}
<td>${trans.status}
</td></tr>
</c:forEach>
</table>
<br><br>
<a href="Try.obj?accNo=${accNo}"><h3>Home</h3></a>
</center>
</body>
</html>