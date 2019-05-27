package midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import midterm.StockBean;

public class StockDAO {
	DataSource ds = null;

	public StockDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/stock");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String findbycode = "select * from stock where stockCode  = ? ";
//	private static final String getall = "select * from stock order by stockCode ";

	public StockBean findbycode(String code) throws SQLException {
		try (Connection conn = ds.getConnection();
				PreparedStatement prst = conn.prepareStatement(findbycode);
			) {
			StockBean Stock = null;
			prst.setString(1, code);
			ResultSet rs = prst.executeQuery();
			rs.next();
			Stock = new StockBean();
			Stock.setstockCode(rs.getString("stockCode"));
			Stock.setstockName(rs.getString("stockName"));
			Stock.setdealNumofstock(rs.getString("dealNumofstock"));
			Stock.setdealPrice(rs.getLong("dealPrice"));
			Stock.setstartPrice(rs.getFloat("startPrice"));
			Stock.sethighestPrice(rs.getFloat("highestPrice"));
			Stock.setlowestPrice(rs.getFloat("lowestPrice"));
			Stock.setendPrice(rs.getFloat("endPrice"));
			Stock.setpriceGap(rs.getString("priceGap"));
			Stock.setdealNum(rs.getString("dealNum"));
			return Stock;
		}
	}

//	public List<StockBean> getAll() throws SQLException {
//		StockBean Stock = new StockBean();
//		try (Connection conn = ds.getConnection();
//				PreparedStatement prst = conn.prepareStatement(getall);
//				ResultSet rs = prst.executeQuery();) {
//			List<StockBean> Stockarr = new ArrayList<StockBean>();
//			while (rs.next()) {
//				Stock = new StockBean();
//				Stock.setstockCode(rs.getString("stockCode"));
//				Stock.setstockName(rs.getString("stockName"));
//				Stock.setdealNumofstock(rs.getString("dealNumofstock"));
//				Stock.setdealPrice(rs.getLong("dealPrice"));
//				Stock.setstartPrice(rs.getFloat("startPrice"));
//				Stock.sethighestPrice(rs.getFloat("highestPrice"));
//				Stock.setlowestPrice(rs.getFloat("lowestPrice"));
//				Stock.setendPrice(rs.getFloat("endPrice"));
//				Stock.setpriceGap(rs.getString("priceGap"));
//				Stock.setdealNum(rs.getInt("dealNum"));
//				Stockarr.add(Stock);
//			}
//			return Stockarr;
//		}
//	}

	private static final String Insert = "Insert into stock (stockCode, stockName, "
			+ "dealNumofstock, dealPrice, startPrice, highestPrice, lowestPrice, "
			+ "endPrice, priceGap,dealNum) values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	
	public int insertStock(StockBean bean) throws SQLException {
		StockBean result = null;
		int i = 0 ;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(Insert);
		) {
			stmt.setString(1, bean.getstockCode());
			stmt.setString(2, bean.getstockName());
			stmt.setString(3, bean.getdealNumofstock());
			stmt.setLong(4, bean.getdealPrice());
			stmt.setFloat(5, bean.getstartPrice());
			stmt.setFloat(6, bean.gethighestPrice());
			stmt.setFloat(7, bean.getlowestPrice());
			stmt.setFloat(8, bean.getendPrice());
			stmt.setString(9, bean.getpriceGap());
			stmt.setString(10, bean.getdealNum());
			
			i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findbycode(bean.getstockCode());
				return i;
			}
			
		} 
		return i;
		
	}

	private static final String DELETE = "Delete from stock where stockCode=?";

	public int delete(String stockCode) {
		int result = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);
		) {
			stmt.setString(1, stockCode);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	private static final String Update = "Update stock set stockName=?, dealNumofstock=?,"
			+ "dealPrice=?, startPrice=?, highestPrice=?, lowestPrice=?,"
			+ " endPrice=?, priceGap=?, dealNum=? where stockCode= ? ";
	
	public StockBean UpdateStockByCode(StockBean bean) throws SQLException {
		StockBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(Update);
		) {
			stmt.setString(1, bean.getstockName());
			stmt.setString(2, bean.getdealNumofstock());
			stmt.setLong(3, bean.getdealPrice());
			stmt.setFloat(4, bean.getstartPrice());
			stmt.setFloat(5, bean.gethighestPrice());
			stmt.setFloat(6, bean.getlowestPrice());
			stmt.setFloat(7, bean.getendPrice());
			stmt.setString(8, bean.getpriceGap());
			stmt.setString(9, bean.getdealNum());
			stmt.setString(10, bean.getstockCode());
			
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findbycode(bean.getstockCode());
			}
		} 
		return result;
	}

}
