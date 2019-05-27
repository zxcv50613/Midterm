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
import javax.servlet.http.HttpSession;

import midterm.StockBean;

@WebServlet("/InsertStock.do")
public class InsertStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertStock() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		StockBean bean = new StockBean();
		String stockCode = request.getParameter("stockCode1span");
		if (stockCode == null || stockCode.trim().length() == 0) {
			
			errorMessage.put("stockCode1", "必須輸入股票代號");
		}
		String stockName = request.getParameter("stockNamespan");
		if (stockName == null || stockName.trim().length() == 0) {
			errorMessage.put("stockName", "必須輸入股票名稱");
		}
		String dealNumofstock = request.getParameter("dealNumofstockspan");
		if (dealNumofstock == null || dealNumofstock.trim().length() == 0) {
			errorMessage.put("dealNumofstock", "必須輸入成交股數");
		}
		String dealPrice = request.getParameter("dealPricespan");
		if (dealPrice == null || dealPrice.trim().length() == 0) {
			errorMessage.put("dealPrice", "必須輸入成交價");
		}
		String startPrice = request.getParameter("startPricespan");
		if (startPrice == null || startPrice.trim().length() == 0) {
			errorMessage.put("startPrice", "必須輸入開盤價");
		}
		String highestPrice = request.getParameter("highestPricespan");
		if (highestPrice == null || highestPrice.trim().length() == 0) {
			errorMessage.put("highestPrice", "必須輸入最高價");
		}
		String lowestPrice = request.getParameter("lowestPricespan");
		if (lowestPrice == null || lowestPrice.trim().length() == 0) {
			errorMessage.put("lowestPrice", "必須輸入最低價");
		}
		String endPrice = request.getParameter("endPricespan");
		if (endPrice == null || endPrice.trim().length() == 0) {
			errorMessage.put("endPrice", "必須輸入收盤價");
		}
		String priceGap = request.getParameter("priceGapspan");
		if (priceGap == null || priceGap.trim().length() == 0) {
			errorMessage.put("priceGap", "必須輸入漲跌價差");
		}
		String dealNum = request.getParameter("dealNumspan");
		if (dealNum == null || dealNum.trim().length() == 0) {
			errorMessage.put("dealNum", "必須輸入成交量");
		}
		HttpSession session = request.getSession();
		bean.setstockCode(request.getParameter("stockCode1span"));
		bean.setstockName(request.getParameter("stockNamespan"));
		bean.setdealNumofstock(request.getParameter("dealNumofstockspan"));
		if (dealPrice.trim().length() != 0) {
		bean.setdealPrice(Long.valueOf(request.getParameter("dealPricespan")));
		}
		if (startPrice.trim().length() != 0) {
		bean.setstartPrice(Float.parseFloat(request.getParameter("startPricespan")));
		}
		if (highestPrice.trim().length() != 0) {
		bean.sethighestPrice(Float.parseFloat(request.getParameter("highestPricespan")));
		}
		if (lowestPrice.trim().length() != 0) {
		bean.setlowestPrice(Float.parseFloat(request.getParameter("lowestPricespan")));
		}
		if (endPrice.trim().length() != 0) {
		bean.setendPrice(Float.parseFloat(request.getParameter("endPricespan")));
		}
		bean.setpriceGap(request.getParameter("priceGapspan"));
		if (dealNum.trim().length() != 0) {
			bean.setdealNum(request.getParameter("dealNumspan"));
		}
		
		if (!errorMessage.isEmpty()) {
			
			request.setAttribute("insertfail", "新增失敗");
			RequestDispatcher rd = request.getRequestDispatcher("/Stock.jsp");
			rd.forward(request, response);
			return;
		} else {
			StockDAO s = new StockDAO();
			try {
				int i = s.insertStock(bean);
				if (i == 1) {
					session.setAttribute("insertSuccess", "修改資料大成功");
					session.setAttribute("StockBean", bean);
					response.sendRedirect("InsertSuccess.jsp");
				} 

			} catch (SQLException e) {
				System.out.println(e);
				request.setAttribute("insertfail", "(新增失敗)");
				RequestDispatcher rd = request.getRequestDispatcher("/Stock.jsp");
				rd.forward(request, response);

			}
		}
	}

}
