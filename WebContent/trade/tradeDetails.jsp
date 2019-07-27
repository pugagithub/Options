<%@page import="pugal.TradeDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

ArrayList<TradeDetailsBean> tradeList = (ArrayList<TradeDetailsBean>)request.getAttribute("tradeList");

%>

<table width="1000px;" bgcolor="yellow" bordercolor="black" border="1" cellpadding="0" cellspacing="0">

<%
int i=1;
for(TradeDetailsBean bean :  tradeList) {%>

<tr height="200px" >
<td><%= (i++) %></td>
<td>
<table width="100%" bgcolor="yellow" border="1" cellpadding="0" cellspacing="0">
<tr height="40px;"><td>Long / Short </td>  <td><%=bean.isLongOrShort()?"Long":"Short" %></td></tr>
<tr height="40px;"><td>Buy <%=bean.getInstrumentName() %>: </td> <td><%=bean.getBuyPrice() %></td></tr>
<tr height="40px;"><td>Sell <%=bean.getInstrumentName() %> : </td>  <td><%=bean.getSellPrice() %></td></tr>
<tr height="40px;"><td>SL @ : </td>   <td><%=bean.getStopLoss() %></td></tr>
<tr height="40px;"><td>Trading Window : </td>  <td><%=bean.getTradingWindow() %></td></tr>
<tr height="40px;"><td>Trade Time : </td>  <td><%=bean.getCurrentDate() %>  <%=bean.getTimeOfTrade() %></td></tr>
<tr height="40px;"><td>Target @ : </td>  <td><%=bean.getTargetPrice() %></td></tr>
<tr bgcolor="green" height="40px;"><td colspan="2">5 Mins Gap Must</td></tr>
</table>
</td>
<td>+ 5000</td>

</tr>

<% } %>





</table>

</body>
</html>