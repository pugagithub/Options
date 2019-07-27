package pugal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OptionTableCreator
 */
@WebServlet("/optionsservlet")
public class OptionTableCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionTableCreator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Am in servlet");
		
		int[] expiryArr =  OptionTableUtility.getExpiryList();
		
		
		HashMap<Integer, List<OptionTrade>> map = OptionTableUtility.getRows(request);
		
		ResourceBundle bundle = ResourceBundle.getBundle("data");  
		
		
		request.setAttribute("expiryList", expiryArr);
		request.setAttribute("tradeMap", map);
		
		
		
		List<OptionTrade> tradeList = OptionTableUtility.getOptionTradedList(request);
		int netPremium=0;
		String netPremiumText="0";
		String tradeReversalExpenseText="0"; 
		int lotSize=75;
		int qty=Integer.parseInt(bundle.getString("qty"));     
		int sellQty=0;
		int totalBuyPremium=0;
		
		
		int MarginReqdForEachLot = Integer.parseInt(bundle.getString("MarginReqdForEachLot"));
		
		int tradeReversalExpense= 0;
		
		for(OptionTrade trade : tradeList){
			if(trade.buy){
				netPremium=netPremium+trade.boughtOrSoldPrice;
				totalBuyPremium = totalBuyPremium + trade.boughtOrSoldPrice*lotSize;
				netPremiumText=netPremiumText+"-"+trade.boughtOrSoldPrice+"";
				
				tradeReversalExpense = tradeReversalExpense - trade.currentMarketPrice;
				tradeReversalExpenseText = tradeReversalExpenseText +"-"+trade.currentMarketPrice+"";
			}
			else {
				sellQty++;
				netPremium=netPremium-trade.boughtOrSoldPrice;
				netPremiumText=netPremiumText+"+"+trade.boughtOrSoldPrice;
				
				tradeReversalExpense = tradeReversalExpense + trade.currentMarketPrice;
				tradeReversalExpenseText = tradeReversalExpenseText +"+"+trade.currentMarketPrice+"";
			}
		}
		
		
		request.setAttribute("Previous Balance", "0");
		request.setAttribute("staticTradedList", tradeList);
		request.setAttribute("netPremium", netPremium);
		request.setAttribute("netPremiumText", netPremiumText);
		request.setAttribute("lotSize", lotSize);
		request.setAttribute("sellQty", sellQty);
		request.setAttribute("Qty", qty);
		request.setAttribute("TotalBuyPremium", totalBuyPremium*qty);
		
		request.setAttribute("MarginReqdForEachLot", MarginReqdForEachLot);
		
		request.setAttribute("expiryDate", bundle.getString("expiryDate"));
		request.setAttribute("tradeEnterDate", "");
		request.setAttribute("tradeExitDate", "");
		
		
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		String daysArr[]={"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		
		Calendar startCal = Calendar.getInstance();
	    startCal.setTime(new Date()); 
	    startCal.add(Calendar.DAY_OF_MONTH, -1);
	    
	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(new Date(bundle.getString("expiryEndDateMMDDYYYY")));   
	    
	    
	    
	   long  noOfDays = (endCal.getTimeInMillis() - startCal.getTimeInMillis())/(24 * 60 * 60 * 1000);
	  
	   noOfDays++; // For including the end date also
	   
	   int tradingBusinessDay=0;
	   for(int i=0;i<(int)noOfDays;i++){
		   if(startCal.get(Calendar.DAY_OF_WEEK)<=5){
			   tradingBusinessDay++;
		   }
		   startCal.add(Calendar.DAY_OF_MONTH, 1);
	   }
	
	   SimpleDateFormat currentTimeFormat = new SimpleDateFormat("HH");
	  System.out.println("Current Time is -->"+ currentTimeFormat.format(Calendar.getInstance().getTime()));
	  
	  if(Integer.parseInt(currentTimeFormat.format(Calendar.getInstance().getTime()))>15)tradingBusinessDay--; //After 3:30 pm
	  
	   request.setAttribute("noOfDaysRemainingTillExpiry", tradingBusinessDay);
		
		request.setAttribute("tradeReversalExpense", tradeReversalExpense*lotSize*qty);
		request.setAttribute("tradeReversalExpenseText", "("+tradeReversalExpenseText+")"+"*"+lotSize+"*"+qty);
		
		System.out.println("Net Premium AMount"+ netPremium);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
