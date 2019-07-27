package pugal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import static pugal.OptionTrade.*;

public class OptionTableUtility {
	
	public static boolean BUY_TRADE=true;
	public static boolean SELL_TRADE=false;
	
	
	public static boolean CALL_OPTION=true;
	public static boolean PUT_OPTION = false;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getExpiryList();
	}
		
		public static int[] getExpiryList(){
		
		int colsLen = 4;
		int rowsLen = 30;
		int currentPrice = 8700;
		int step=50;
		
		//Used only when row size is 1
		int givenPrice=8700;
		
		if(rowsLen<=0){
			System.exit(0);
		}
		
		int[] rowsArr = new int[rowsLen];
		if(rowsLen==1){
			rowsArr[0]=givenPrice;
			return rowsArr;
		}
		
		
		//System.out.println("--------------------------------------------");
		for(int j=0,i=rowsLen/2;i>0;i--,j++){
			rowsArr[j]=currentPrice-(step*i);
	//		//System.out.println("Index is"+ (j));
		//	//System.out.println(rowsArr[j]);
		}
		////System.out.println("--------------------------------------------");
		for(int i=0;i<rowsLen/2;i++){
			rowsArr[((i)+(rowsLen/2))]=currentPrice+(step*i);
		//	//System.out.println("Index is "+ ((i)+(rowsLen/2)));
		//	//System.out.println(rowsArr[((i)+(rowsLen/2))]);
		}
		
		if(rowsLen%2!=0){
			rowsArr[rowsLen-1]=rowsArr[rowsLen-2]+step;
		}
		
		////System.out.println("----------------Final----------------------------");
		for(int i=0;i<rowsArr.length;i++){
			
			//System.out.println(rowsArr[i]);
		}
		////System.out.println("----------------Final  2----------------------------");
		
for(int i=0;i<rowsArr.length;i++){
			
			//System.out.println(rowsArr[i]);
		}
		
return rowsArr;
		

	}


		
		public static ArrayList<OptionTrade> getOptionTradedList(HttpServletRequest request){
			
			ArrayList<OptionTrade> list = new ArrayList<OptionTrade>();
			
			
			
			
			
		/*	
			list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 6	));
			list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 6	));
			list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 6	));
			list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 6	));
			

			list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8600 , 50));
			list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8600 , 50));
			list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8600 , 50	));
			list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8600 , 50	));
			
			list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8700 , 174));
			list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8700 , 174));
			list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8700 , 174));
			list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8700 , 174));
			
			list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9200 , 8));
			list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9200 , 8));
			list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9200 , 8));
			list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9200 , 8));*/
			
			
			//Good as of now
			 /*list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 2	));
			 list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 2	));
			 list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 2	));
			// list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8200 , 10));
			 list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8700 , 70));
			 
			 list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8700 , 191));
			 //list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9200 , 10));
			list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9400 , 2));
			list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9400 , 2));
			list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9400 , 2));*/
			
			
			/*list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 2	));
			list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 2	));
			list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8000 , 2	));
			// list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8200 , 10));
			 list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8700 , 64));
			 
			 list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8700 , 214));
			// list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9200 , 10));
			 list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9400 , 2));
			 list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9400 , 2));
			 list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9400 , 2));*/
	
			//Current Market Price : 8786
			
			//---------CALL------------------------------------------
			 //list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8800 ,64)); 
			
			
			//----------PUT--------------------------------------------				
			/*//Oct 17 , 2016 
			list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8500 , 76,69)); 
			 list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,8100 , 8,8)); */
			
			
			list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,9000 , 260,260));  
			//list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8200 , 130,130));
			
			//list.add(new OptionTrade(SELL_TRADE,CALL_OPTION,8000 , 365,365));
			//list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8300 , 100,100));
			
			
			//list.add(new OptionTrade(BUY_TRADE,CALL_OPTION,9200 , 2,2));
			//list.add(new OptionTrade(BUY_TRADE,PUT_OPTION,7700 , 6,6));
			
				
			//list.add(new OptionTrade(SELL_TRADE,PUT_OPTION,8700 , 107,97));
			
			
			
			return list;
			
		}
		
		

		public static HashMap<Integer, List<OptionTrade>> getRows(HttpServletRequest request){
			
		HashMap<Integer, List<OptionTrade>> map = new HashMap<Integer , List<OptionTrade>>();
			
		int[] expiryArray =	getExpiryList();
		ArrayList<OptionTrade> tradeList = getOptionTradedList(request);
		
			for(int i=0;i<expiryArray.length;i++){
			
				
				ArrayList<OptionTrade>  newTradeList = new ArrayList<OptionTrade>();
				
				for(int j=0;j<tradeList.size();j++){
					
					OptionTrade trade = new OptionTrade();
					OptionTrade oldTrade = tradeList.get(j);
					trade.buy=oldTrade.buy;
					trade.callOption=oldTrade.callOption;
					trade.expiryPrice=oldTrade.expiryPrice;
					trade.strikePrice=oldTrade.strikePrice;
					
					
					//If Call 
					trade.expiryPrice=expiryArray[i];
					////System.out.println("Hi Pugal-------->"+trade.callOption);
					if(trade.callOption){
						////System.out.println("Am inside call option");
						if(trade.expiryPrice>trade.strikePrice) {
							////System.out.println("Am inside IF CONDITION");
							trade.profitLossAmt=(trade.expiryPrice-trade.strikePrice);
							if(!trade.buy)trade.profitLossAmt=trade.profitLossAmt*-1;
							//System.out.println("Profit Loss Amount FOr Expiry --> "+trade.expiryPrice+"--->"+ trade.profitLossAmt);
						}						
						else trade.profitLossAmt = 0;
					}
					
					else {
						
						if(trade.expiryPrice<trade.strikePrice){
							trade.profitLossAmt=(trade.strikePrice-trade.expiryPrice);
							if(!trade.buy)trade.profitLossAmt=trade.profitLossAmt*-1;
							//System.out.println("Profit Loss Amount FOr Expiry --> "+trade.expiryPrice+"--->"+ trade.profitLossAmt);
						}						
						else trade.profitLossAmt = 0;
					}//End For Inner For Loop
					
					newTradeList.add(trade);
				}
					
				map.put(expiryArray[i], newTradeList);
					
			}//End For Outer For Loop
			
			return map;
		}



}
