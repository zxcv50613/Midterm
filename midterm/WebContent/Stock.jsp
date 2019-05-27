<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Index</title>
    <link rel="stylesheet" href="css/index.css">
    <script>
	document.addEventListener("DOMContentLoaded", function() {

		
		document.getElementById("stockCode").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("stockCode").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("stockName").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("stockName").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("dealNumofstock").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("dealNumofstock").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("stockCode1").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("stockCode1").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("dealPrice").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("dealPrice").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("startPrice").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("startPrice").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("highestPrice").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("highestPrice").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("lowestPrice").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("lowestPrice").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("endPrice").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("endPrice").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("priceGap").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("priceGap").addEventListener("focus", function(){focus(this.id)});
		document.getElementById("dealNum").addEventListener("blur", function(){chkname(this.id)});
		document.getElementById("dealNum").addEventListener("focus", function(){focus(this.id)});
		
	})

	function focus(id) {
		document.getElementById(document.getElementById(id).name).innerHTML = ""
	}

	function chkname(id) {
		
		let stockCode = document.getElementById(id).value;
		if (stockCode == "") {
			document.getElementById(document.getElementById(id).name).innerHTML = "<img src='pic/false.jpg' width='10%'>查詢必須輸入數值";
		}else{
			document.getElementById(document.getElementById(id).name).innerHTML = "";
		}
	}
</script>
</head>

<body>
    <div class="allpage">
        <header>
            <nav>
               	<h1 style="text-align:center">全台首家股票系統上線辣</h1>
                <img src="pic/logo.png" alt="logo" width="1024px" height="100px">
            </nav>
        </header>
        <div class="content">
          <form name="searchStock" action="searchbycode.do" method="POST" >
	<table border="1" style="width: 500px">
			<thead>
				<tr bgcolor='#ca8ec2'>
					<th height="60" colspan="2" align="center">股票基本查詢(查詢後可做修改刪除)<div>${insertSuccess}</div></th>
				</tr>
			</thead>
			<tbody>
			<tr bgcolor='#81c0c0'>
					<td width="120" height="40">股票代號：</td>
					<td width="600" height="40" align="left"><input id='stockCode'
						style="text-align: left" name="stockCodespan">
						<span id="stockCodespan"></span>
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
		</tbody>
		</table>
	</form>
	<form name="insertStockForm" action="InsertStock.do" method="POST">
		<table border="1" style="width: 500px">
			<thead>
				<tr bgcolor='#ca8ec2'>
					<th height="60" colspan="2" align="center">新增股票資料<span style="color:#2528ca">${insertfail}</span></th>
					
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">股票代號：</td>
					<td width="600" height="40" align="left"><input id='stockCode1'
						style="text-align: left" name="stockCode1span" value="${StockBean.stockCode}"
						type="text" size="4">
						<span id="stockCode1span"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">股票名稱：</td>
					<td width="600" height="40" align="left"><input id='stockName'
						style="text-align: left" name="stockNamespan" value="${StockBean.stockName}"
						type="text" size="14">
						<span id="stockNamespan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">成交股數：</td>
					<td width="600" height="40" align="left"><input name="dealNumofstockspan" id='dealNumofstock'
						value="${StockBean.dealNumofstock}" type="text" size="20">
						<span id="dealNumofstockspan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">成交金額：</td>
					<td width="600" height="40" align="left"><input id="dealPrice"
						name="dealPricespan" value="${StockBean.dealPrice}" type="text">
						<span id="dealPricespan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">開盤價：</td>
					<td width="600" height="40" align="left"><input name="startPricespan" id="startPrice"
						value="${StockBean.startPrice}" type="text" size="20">
						<span id="startPricespan"></span>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">最高價：</td>
					<td width="600" height="40" align="left"><input id="highestPrice"
						name="highestPricespan" value="${StockBean.highestPrice}" type="text">
						<span id="highestPricespan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">最低價：</td>
					<td width="600" height="40" align="left"><input name="lowestPricespan" id="lowestPrice"
						value="${StockBean.lowestPrice}" type="text" size="14">
						<span id="lowestPricespan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">收盤價：</td>
					<td width="600" height="40" align="left"><input name="endPricespan" id="endPrice"
						value="${StockBean.endPrice}" type="text" size="14">
						<span id="endPricespan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">漲跌價差：</td>
					<td width="600" height="40" align="left"><input name="priceGapspan" id="priceGap"
						value="${StockBean.endPrice}" type="text" size="14">
						<span id="priceGapspan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td width="120" height="40">成交量：</td>
					<td width="600" height="40" align="left"><input name="dealNumspan" id="dealNum"
						value="${StockBean.dealNum}"" type="text" size="14">
						<span id="dealNumspan"></span>
						
					</td>
				</tr>
				<tr bgcolor='#81c0c0'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>

			</tbody>
		</table>
	</form>

</body>

</html>