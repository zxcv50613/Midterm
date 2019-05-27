package midterm;

public class StockBean {
	private String stockCode;
	private String stockName;
	private String dealNumofstock;
	private Long dealPrice;
	private float startPrice;
	private float highestPrice;
	private float lowestPrice;
	private float endPrice;
	private String dealNum;
	private String priceGap;
	
	public StockBean(String stockCode, String stockName, String dealNumofstock, Long dealPrice, float startPrice, float highestPrice,
			float lowestPrice, float endPrice,String dealNum,String priceGap) {
		super();
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.dealNumofstock = dealNumofstock;
		this.dealPrice = dealPrice;
		this.startPrice = startPrice;
		this.highestPrice = highestPrice;
		this.lowestPrice = lowestPrice;
		this.endPrice = endPrice;
		this.dealNum = dealNum ;
		this.priceGap = priceGap ;
	}
	public StockBean() {
		
	}

	public String getstockCode() {
		return stockCode;
	}

	public void setstockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getstockName() {
		return stockName;
	}

	public void setstockName(String stockName) {
		this.stockName = stockName;
	}

	public String getdealNumofstock() {
		return dealNumofstock;
	}
	public void setdealNumofstock(String dealNumofstock) {
		this.dealNumofstock = dealNumofstock ;
		
	}

	public Long getdealPrice() {
		return dealPrice;
	}

	public void setdealPrice(Long dealPrice) {
		this.dealPrice = dealPrice;
	}

	public float getstartPrice() {
		return startPrice;
	}

	public void setstartPrice(float startPrice) {
		this.startPrice = startPrice;
	}

	public float gethighestPrice() {
		return highestPrice;
	}

	public void sethighestPrice(float highestPrice) {
		this.highestPrice = highestPrice;
	}

	public float getlowestPrice() {
		return lowestPrice;
	}

	public void setlowestPrice(float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public float getendPrice() {
		return endPrice;
	}

	public void setendPrice(float endPrice) {
		this.endPrice = endPrice;
	}

	public String getdealNum() {
		return dealNum;
	}

	public void setdealNum(String dealNum) {
		this.dealNum = dealNum;
	}

	public String getpriceGap() {
		return priceGap;
	}

	public void setpriceGap(String priceGap) {
		this.priceGap = priceGap;
	}
}

