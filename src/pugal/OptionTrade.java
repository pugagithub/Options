package pugal;

import java.util.Date;

public class OptionTrade {
	
	
	/*String url = "http://www.moneycontrol.com/india/indexfutures/nifty/9/";
	String dynamicUrl = "2016-09-29/OPTIDX/CE/8600.00/true";
	String staticPart ="2016-09-29/OPTIDX";
	String callText="CE";
	String putText="PE";
	String strikePriceText="";*/

	
	public boolean buy = true;
	public boolean callOption = true;
	public int strikePrice;
	public int expiryPrice;	
	public int profitLossAmt;
	public String bgcolor;
	
	public int boughtOrSoldPrice;
	public int currentMarketPrice;
	
	public Date tradeEnterDate;
	public Date tradeExitDate;
	
	public OptionTrade() {
		// TODO Auto-generated constructor stub
	}

	public OptionTrade(boolean buy, boolean callOption, int strikePrice , int boughtOrSoldPrice, int currentMarketPrice) {
		super();
		this.buy = buy;
		this.callOption = callOption;
		this.strikePrice = strikePrice;
		this.boughtOrSoldPrice= boughtOrSoldPrice;
		this.currentMarketPrice= currentMarketPrice;
		
		/*try {
			
			String price = HTMLUnitPriceGetter.sendRequest(url ,dynamicUrl );
			
			System.out.println("Price for strikeprice -->"+strikePrice+"----> is "+ price );
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	

}
