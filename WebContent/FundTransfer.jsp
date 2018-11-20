<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(FundTransfer.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;">
<h2><b>Account Number:${accNo}</b></h2>
<table>
<sf:form method="post" action="FundTransferAction.obj" modelAttribute="fund"> 

<tr><td><center>Enter Receiver Account Number:
 <input type="text" id="textbox" placeholder="Account No" name="recAccNo"></center></td></tr>
<tr><td><center><sf:errors style="color:red" path="recAccNo"></sf:errors></center></td></tr>

<tr><td><center>Enter Transfer Amount&emsp;&emsp;&emsp;&nbsp;&nbsp;: <input type="text" id="textbox" 
placeholder="Amount" name="amount"></center></td></tr>
<tr><td><center><sf:errors style="color:red" path="amount"></sf:errors></center></td></tr>

<tr><td><center>Enter Transaction Password&emsp;&nbsp;&nbsp; :
 <input type="password" id="textbox" placeholder="Transaction Password" 
 name="transPassword"></center></td></tr>
<tr><td><center><sf:errors style="color:red" path="transPassword">
</sf:errors></center></td></tr>
<tr><td><input type="hidden" name="accNo" value=${accNo}>
<tr><td><tr><td><center><input type="submit" value="Transfer"></center></td></tr>
</sf:form>
</table>
<a href="Try.obj?accNo=${accNo}"><h3>Home</h3></a></center></center>
</body>
</html>