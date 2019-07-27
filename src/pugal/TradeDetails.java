package pugal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TradeDetails
 */
@WebServlet("/TradeDetails")
public class TradeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TradeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	ArrayList<TradeDetailsBean> tradeList= new ArrayList<TradeDetailsBean>();
	
	tradeList.add(new TradeDetailsBean(100.00, 120.00, "NIFTYOCT2016", "9:15 AM", new Date(), 95.00, 125.00, true, "09:15 to 10:15 AM"));
	tradeList.add(new TradeDetailsBean(100.00, 120.00, "NIFTYOCT2016", "9:15 AM", new Date(), 95.00, 125.00, true, "10:15 to 11:15 AM"));
	tradeList.add(new TradeDetailsBean(100.00, 120.00, "NIFTYOCT2016", "9:15 AM", new Date(), 95.00, 125.00, true, "09:15 to 10:15 AM"));
	tradeList.add(new TradeDetailsBean(100.00, 120.00, "NIFTYOCT2016", "9:15 AM", new Date(), 95.00, 125.00, true, "09:15 to 10:15 AM"));
	tradeList.add(new TradeDetailsBean(100.00, 120.00, "NIFTYOCT2016", "9:15 AM", new Date(), 95.00, 125.00, true, "09:15 to 10:15 AM"));
	tradeList.add(new TradeDetailsBean(100.00, 120.00, "NIFTYOCT2016", "9:15 AM", new Date(), 95.00, 125.00, true, "09:15 to 10:15 AM"));
	
	
	
	
	request.setAttribute("tradeList", tradeList);
	
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("trade/tradeDetails.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
