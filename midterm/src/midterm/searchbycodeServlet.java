package midterm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.StockBean;


@WebServlet("/searchbycode.do")
public class searchbycodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public searchbycodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		findByCode(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		findByCode(request, response);
	}

	private void findByCode(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		String stockCode = request.getParameter("stockCodespan");
		if (stockCode == null || stockCode.trim().length() == 0) {
			errorMessage.put("stockCode", "必須輸入股票代號");
			RequestDispatcher rd = request.getRequestDispatcher("/Stock.jsp");
			rd.forward(request, response);
			return;
		}
		StockDAO s = new StockDAO();
		try {
			StockBean stockbean = s.findbycode(stockCode);
			request.setAttribute("stockCode", stockCode);
			request.setAttribute("stockName", stockbean.getstockName());
			request.setAttribute("dealNumofstock", stockbean.getdealNumofstock());
			request.setAttribute("dealPrice", stockbean.getdealPrice());
			request.setAttribute("startPrice", stockbean.getstartPrice());
			request.setAttribute("highestPrice", stockbean.gethighestPrice());
			request.setAttribute("lowestPrice", stockbean.getlowestPrice());
			request.setAttribute("endPrice", stockbean.getendPrice());
			request.setAttribute("priceGap", stockbean.getpriceGap());
			request.setAttribute("dealNum", stockbean.getdealNum());
			RequestDispatcher rd = request.getRequestDispatcher("findbycode.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			errorMessage.put("stockCode", "沒有此股票代號");
			RequestDispatcher rd = request.getRequestDispatcher("/Stock.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
	
	}
}
