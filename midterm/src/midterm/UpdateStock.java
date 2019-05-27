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

@WebServlet("/UpdateStock.do")
public class UpdateStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStock() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		StockBean bean = new StockBean();
		String stockCode = request.getParameter("stockCode");
		if (stockCode == null || stockCode.trim().length() == 0) {
			errorMessage.put("stockCode1", "必須輸入股票代號");
		}
		String stockName = request.getParameter("stockName");
		if (stockName == null || stockName.trim().length() == 0) {
			errorMessage.put("stockName", "必須輸入股票名稱");
		}
		String dealNumofstock = request.getParameter("dealNumofstock");
		if (dealNumofstock == null || dealNumofstock.trim().length() == 0) {
			errorMessage.put("dealNumofstock", "必須輸入成交股數");
		}
		String dealPrice = request.getParameter("dealPrice");
		if (dealPrice == null || dealPrice.trim().length() == 0) {
			errorMessage.put("dealPrice", "必須輸入成交價");
		}else {
			bean.setdealPrice(Long.valueOf(dealPrice));
		}
		String startPrice = request.getParameter("startPrice");
		if (startPrice == null || startPrice.trim().length() == 0) {
			errorMessage.put("startPrice", "必須輸入開盤價");
		}else {
			bean.setstartPrice(Float.parseFloat(startPrice));
		}
		String highestPrice = request.getParameter("highestPrice");
		if (highestPrice == null || highestPrice.trim().length() == 0) {
			errorMessage.put("highestPrice", "必須輸入最高價");
		}else {
			bean.sethighestPrice(Float.parseFloat(highestPrice));
		}
		String lowestPrice = request.getParameter("lowestPrice");
		if (lowestPrice == null || lowestPrice.trim().length() == 0) {
			errorMessage.put("lowestPrice", "必須輸入最低價");
		}else {
			bean.setlowestPrice(Float.parseFloat(lowestPrice));
		}
		String endPrice = request.getParameter("endPrice");
		if (endPrice == null || endPrice.trim().length() == 0) {
			errorMessage.put("endPrice", "必須輸入收盤價");
		}else {
			bean.setendPrice(Float.parseFloat(endPrice));
		}
		String priceGap = request.getParameter("priceGap");
		if (priceGap == null || priceGap.trim().length() == 0) {
			errorMessage.put("priceGap", "必須輸入漲跌價差");
		}
		String dealNum = request.getParameter("dealNum");
		if (dealNum == null || dealNum.trim().length() == 0) {
			errorMessage.put("dealNum", "必須輸入成交量");
		}else {
			bean.setdealNum(dealNum);
		}
		bean.setstockCode(request.getParameter("stockCode"));
		bean.setstockName(request.getParameter("stockName"));
		bean.setdealNumofstock(request.getParameter("dealNumofstock"));
		bean.setpriceGap(request.getParameter("priceGap"));
		
		if (!errorMessage.isEmpty()) {
			System.out.println(errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/Stock.jsp");
			rd.forward(request, response);
			return;
		} else {
			StockDAO s = new StockDAO();
			try {
				StockBean StockBean =s.UpdateStockByCode(bean);
				if (StockBean != null) {
					StockBean stockbean = s.findbycode(bean.getstockCode());
					request.setAttribute("stockCode", bean.getstockCode());
					request.setAttribute("stockName", stockbean.getstockName());
					request.setAttribute("dealNumofstock", stockbean.getdealNumofstock());
					request.setAttribute("dealPrice", stockbean.getdealPrice());
					request.setAttribute("startPrice", stockbean.getstartPrice());
					request.setAttribute("highestPrice", stockbean.gethighestPrice());
					request.setAttribute("lowestPrice", stockbean.getlowestPrice());
					request.setAttribute("endPrice", stockbean.getendPrice());
					request.setAttribute("priceGap", stockbean.getpriceGap());
					request.setAttribute("dealNum", stockbean.getdealNum());
					request.setAttribute("afterupdate", "(修改後結果)");
					RequestDispatcher rd = request.getRequestDispatcher("findbycode.jsp");
					rd.forward(request, response);
				} 

			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();

			}
		}
	}

}
