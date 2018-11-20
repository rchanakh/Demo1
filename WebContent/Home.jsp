<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

<center><h1><font face="Bookman">Hello,  ${name} </font></center>
<input type="button" style="float:right;" value="Log Out" onClick="javascript:window.location='enter.obj';"> </h1><br/>

<center><h2>Your Balance  :  ${balance}  </h2><br/>

<br/>
<b><a href="viewMiniStat.obj?acc=${accNo}">View Mini Statement</a><br><br>
<a href="ChangeAddressMobile.obj?acc=${accNo}">Change in Address/Mobile Number</a><br><br>
<a href="FundTransfer.obj?acc=${accNo}">Fund Transfer</a><br><br>
<a href="changePassword.obj?acc=${accNo}">Change Password</a><br><br>
</b>
</center>
</body>
</html>