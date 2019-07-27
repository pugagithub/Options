<%@page import="java.util.Date"%>
<%@page import="pugal.OptionTrade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rev 1 : Option Trading Strategies From Pugal</title>
<style type="text/css">
table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}

td {
    height: 50px;
    vertical-align: middle;
    text-align: center;
    font-weight: bold;
}
</style>
</head>
<body>

<h1>Hi Pugal</h1>

<% 
int marginReqFromNSE =(Integer) request.getAttribute("MarginReqdForEachLot");
int lotSize = (Integer)request.getAttribute("lotSize");
int[] expiryList = (int[])request.getAttribute("expiryList");
int netPremiumPaidOrReceived = (Integer)request.getAttribute("netPremium");
int qty = (Integer)request.getAttribute("Qty");
int sellQty = (Integer)request.getAttribute("sellQty");
int buyPremium = (Integer)request.getAttribute("TotalBuyPremium");
String expiryDate = (String)request.getAttribute("expiryDate");
String tradeEnterDate = (String)request.getAttribute("tradeEnterDate");
String tradeExitDate = (String)request.getAttribute("tradeExitDate");
int noOfDaysRemainingTillExpiry = (Integer)request.getAttribute("noOfDaysRemainingTillExpiry");

int tradeReversalExpense = (Integer)request.getAttribute("tradeReversalExpense");
String tradeReversalExpenseText = (String)request.getAttribute("tradeReversalExpenseText");

HashMap<Integer, List<OptionTrade>> tradeMap = (HashMap<Integer, List<OptionTrade>>)request.getAttribute("tradeMap");
List<OptionTrade> tradeList = (List<OptionTrade>)request.getAttribute("staticTradedList");

int cols = tradeList.size(); int rows = expiryList.length; %>



<table align="center" width="800"  cellpadding="0" cellspacing="0" bgcolor="yellow" border="1" bordercolor="black">
<tr>
<td>Description</td>
<td>Values</td>
</tr>

<tr>
<td>Net Premium per qty</td>
<td <%=(netPremiumPaidOrReceived>0)?"bgcolor=red":"bgcolor=lightgreen" %>><%=(netPremiumPaidOrReceived>0)?"Paid":"Received" %>  : <%=Math.abs(netPremiumPaidOrReceived)%>  [<%=request.getAttribute("netPremiumText")%>]</td>
</tr>

<tr>
<td>Net Premium Total Amount per qty</td>
<td <%=(netPremiumPaidOrReceived>0)?"bgcolor=red":"bgcolor=lightgreen" %>><%=(netPremiumPaidOrReceived>0)?"Paid":"Received" %>  : <%=Math.abs(netPremiumPaidOrReceived)*lotSize%>  [<%=Math.abs(netPremiumPaidOrReceived) %> * <%=lotSize %>]</td>
</tr>



<tr>
<td>Total Sell Per Qty : </td>
<td><%=sellQty %> Sells Happened </td>
</tr>

<tr>
<td>No of times Qty :</td>
<td><%=qty %></td>
</tr>

<tr>
<td>Approximate Investment Required For Selling Margin :</td>
<td><%=(sellQty*marginReqFromNSE)*qty %> </td>
</tr>

<tr>
<td>Total Buy Premium : </td>
<td><%=buyPremium %></td>
</tr>

<tr>
<td>Net Premium Paid / Received : </td>
<td <%=(netPremiumPaidOrReceived>0)?"bgcolor=red":"bgcolor=lightgreen" %>><%=(netPremiumPaidOrReceived>0)?"Paid":"Received" %>  : <%= Math.abs(netPremiumPaidOrReceived)*lotSize*qty %>  [<%=Math.abs(netPremiumPaidOrReceived) %> * <%=lotSize %> * <%=qty %>]</td>
</tr>

<tr>
<td>Expiry Date </td>
<td><%= expiryDate %></td>
</tr>

<tr>
<td>Trade Enter Date </td>
<td><%= tradeEnterDate %></td>
</tr>

<tr>
<td>Trade Exit Date </td>
<td><%= tradeExitDate %></td>
</tr>

<tr>
<td>No. of Trading Sessions Till Expiry <br> (Incl Both Dates)</td>
<td><%=noOfDaysRemainingTillExpiry %></td>
</tr>

<tr>
<td>Trade Reversal Expense</td>
<td><%=tradeReversalExpense * -1 %> [(<%=tradeReversalExpenseText %>) * -1] </td>
</tr>



<tr>
<td>MTM Profit / Loss</td>

<%
int mtm= (((netPremiumPaidOrReceived)*lotSize*qty*-1) + ((tradeReversalExpense))*-1) ; 
%>
<td <%=(mtm>0)?"bgcolor=lightgreen":"bgcolor=red" %> ><%=mtm %>

<br>[(<%=((netPremiumPaidOrReceived)*lotSize*qty*-1) %> + <%=((tradeReversalExpense*-1)) %>) ]
</td>
</tr>



</table>

<br>
<br>


<table align="center" width="1300"  cellpadding="0" cellspacing="0" bgcolor="yellow" border="1" bordercolor="black">



<tr>

<td colspan="<%= (cols+4) %>" align="left"><b>Options Chart Table 


</b></td>
</tr>

<tr><b>
<td>S.No</td>
<td>Expiry</td>
<% for(OptionTrade trade : tradeList) {%><td>
<%=trade.buy?"BUY":"SELL" %> <%=trade.callOption?"CALL":"PUT" %> <%=trade.strikePrice %> @ <%=trade.boughtOrSoldPrice %>
</td><%} %>
<td >Net Amount</td></b>
<td align="left" width="450px;">Net Amount Explanation <br> [(netAmt * lotSize) - (netPremiumPaid * lotSize))] * qty
</tr>

<% for(int j=0;j<rows;j++){ 

int netAmt = 0;
%>

<tr>
<td><%= (j+1) %></td>
<td><%= expiryList[j] %></td>
<% 
List<OptionTrade> list = tradeMap.get(expiryList[j]);


String newFinalAmtText="(0";

for(OptionTrade trade : list){ %>
<td><%=trade.profitLossAmt %></td>
<%
netAmt = netAmt + trade.profitLossAmt;
newFinalAmtText=newFinalAmtText+((trade.profitLossAmt>=0)?"+":"")+trade.profitLossAmt;
} 

int newFinalAmt = (netAmt-netPremiumPaidOrReceived)*lotSize*qty ;
newFinalAmtText = newFinalAmtText+" * "+lotSize+")"+"-"+"("+(netPremiumPaidOrReceived+" * "+lotSize+")");

%>
<td <%=(newFinalAmt>0)?"bgcolor=lightgreen":"bgcolor=red" %>><%=newFinalAmt%>

<script type="text/javascript">
//alert('Hi Pugal  --->'+  $(this).closest("tr"));
$(this).closest("tr").css({"color": "red", "border": "2px solid red"});;
//this.parentNode.parentNode.setAttribute('bgcolor','green');

</script>

</td>

<td> [<%= newFinalAmtText %>]  * <%=qty  %></td>
</tr>
<%} %>

</table>

</body>
</html>