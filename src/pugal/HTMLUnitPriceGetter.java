/*package pugal;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HTMLUnitPriceGetter {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		sendRequest("","");
		
	}
		
	
	
	public static String sendRequest(String url , String xPath) throws InterruptedException, IOException{
	
		long startTime = System.currentTimeMillis();
	    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
	    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	    webClient.getOptions().setThrowExceptionOnScriptError(false);
	    webClient.getCookieManager().setCookiesEnabled(true);
	    webClient.getOptions().setCssEnabled(false);
	    webClient.getOptions().setTimeout(1000);

	    HtmlPage page=null;
			try {
				page = webClient.getPage("https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteFO.jsp?"
				+ "underlying=NIFTY"
				+ "&"
				+ "instrument=OPTIDX"
				+ "&"
				+ "strike=8600.00"
				+ "&"
				+ "type=CE"
				+ "&"
				+ "expiry=29SEP2016");
				
				//page = webClient.getPage("http://www.moneycontrol.com/india/indexfutures/nifty/9/2016-09-29/OPTIDX/CE/8600.00/true");
				page = webClient.getPage("https://zerodha.com/margin-calculator/SPAN/");
				//page = webClient.getPage("http://zeenews.india.com/business/derivatives/getquotes.html");
				
			} catch (FailingHttpStatusCodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        //get list of all divs
	     //   page.getBody();
			
		//	System.out.println(page.asXml());
			
			Thread.sleep(1000);
			
			HtmlSelect select= ((HtmlSelect) page.getElementById("InstrumentType"));
			HtmlOption option =select.getOptionByText("OPTIDX");
			select.setSelectedAttribute(option, true);			
			Thread.sleep(100);
			
			
			select= ((HtmlSelect) page.getElementById("Symbol"));
			option =select.getOptionByText("NSE Index");
			select.setSelectedAttribute(option, true);
			Thread.sleep(100);
			
			select= ((HtmlSelect) page.getElementById("Symbol"));
			option =select.getOptionByText("NSE Index");
			select.setSelectedAttribute(option, true);
			Thread.sleep(100);
			
			select= ((HtmlSelect) page.getElementById("ExpiryDate"));
			option =select.getOption(2);
			select.setSelectedAttribute(option, true);
			Thread.sleep(100);
			
			select= ((HtmlSelect) page.getElementById("OptionType"));
			option =select.getOptionByText("CE");
			select.setSelectedAttribute(option, true);
			Thread.sleep(100);
			
			select= ((HtmlSelect) page.getElementById("StrikePrice"));
			option =select.getOptionByText("8600");
			select.setSelectedAttribute(option, true);
			Thread.sleep(100);
			
			HtmlSubmitInput el = (HtmlSubmitInput)page.getByXPath("/html/body/table/tbody/tr[9]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[6]/img").get(0);
			 page = (HtmlPage) el.click();
			 
			 
			 Thread.sleep(1000);
			 
			 System.out.println(page.getByXPath("html/body/table/tbody/tr[8]/td/table/tbody/tr[2]/td[4]"));
			
			
			
			
			
			//String val = page.getByXPath("/html/body/center[2]/div/div/div[7]/div[3]/div[3]/div[1]/div[1]/div[3]/p[1]/strong/text()").get(0).toString().replace("[", "").replace("]", "");
				
				System.out.println("Page as XML"+ page.asXml());
			long endTime = System.currentTimeMillis();
			
			System.out.println("TIme in secs "+ (endTime-startTime)/60);
			
			return "0";
	        //get div which has a 'name' attribute of 'John'
	       // final HtmlDivision div = (HtmlDivision) page.getByXPath("//div[@name='John']").get(0);
	    }
	

}
*/