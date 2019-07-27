/*package pugal;

import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;

public class PriceRetriever{
  public static void main(String[] args){
    try{
      UserAgent userAgent = new UserAgent();   
      
      //create new userAgent (headless browser).
      userAgent.visit("https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteFO.jsp?"
      		+ "underlying=NIFTY"
      		+ "&"
      		+ "instrument=OPTIDX"
      		+ "&"
      		+ "strike=8600.00"
      		+ "&"
      		+ "type=CE"
      		+ "&"
      		+ "expiry=29SEP2016");   
      
      
      //userAgent.visit("www.moneycontrol.com/india/indexfutures/nifty/9/2016-09-29/OPTIDX/CE/8600.00/true");
      
      
      //visit a url   
     // Element span = userAgent.doc.findFirst("<span id=\"lastPrice\">");
      
      System.out.println("Body is"+ userAgent.doc.getText());//print the content as HTML
    }
    catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
      System.err.println(e);
    }
  }
}*/