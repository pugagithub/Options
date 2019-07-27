package pugal;

import java.util.Date;

public class TradeDetailsBean {
	
	double buyPrice;
	public double getBuyPrice() {
		return buyPrice;
	}


	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}


	public double getSellPrice() {
		return sellPrice;
	}


	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}


	public String getInstrumentName() {
		return instrumentName;
	}


	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}


	public String getTimeOfTrade() {
		return timeOfTrade;
	}


	public void setTimeOfTrade(String timeOfTrade) {
		this.timeOfTrade = timeOfTrade;
	}


	public Date getCurrentDate() {
		return currentDate;
	}


	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}


	public double getStopLoss() {
		return stopLoss;
	}


	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}


	public double getTargetPrice() {
		return targetPrice;
	}


	public void setTargetPrice(double targetPrice) {
		this.targetPrice = targetPrice;
	}


	public boolean isLongOrShort() {
		return longOrShort;
	}


	public void setLongOrShort(boolean longOrShort) {
		this.longOrShort = longOrShort;
	}


	public String getTradingWindow() {
		return tradingWindow;
	}


	public void setTradingWindow(String tradingWindow) {
		this.tradingWindow = tradingWindow;
	}


	double sellPrice;
	String instrumentName;
	String timeOfTrade;
	Date currentDate;
	double stopLoss;
	double targetPrice;
	boolean longOrShort;
	String tradingWindow;
	
	
	public TradeDetailsBean(double buyPrice, double sellPrice,
			String instrumentName, String timeOfTrade, Date currentDate,
			double stopLoss, double targetPrice, boolean longOrShort,
			String tradingWindow) {
		super();
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.instrumentName = instrumentName;
		this.timeOfTrade = timeOfTrade;
		this.currentDate = currentDate;
		this.stopLoss = stopLoss;
		this.targetPrice = targetPrice;
		this.longOrShort = longOrShort;
		this.tradingWindow = tradingWindow;
	}
	
	
	

}
