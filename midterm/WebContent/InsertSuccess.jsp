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
</head>

<body>
    <div class="allpage">
        <header>
            <nav>
               	<h1 style="text-align:center">全台首家股票系統上線辣</h1>
                <img src="pic/logo.png" alt="logo" width="1024px" height="100px">
            </nav>
        </header>
        <div class="picture"><img src="pic/congradulation.gif"></div>
        <div class="content">
        <form >
		<table border="1" style="width: 500px" >
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center">新增的股票資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">股票代號：</td>
					<td width="600" height="40" align="left"><input id='num' disabled="disabled"
						style="text-align: left" name="stockCode" value="${StockBean.stockCode}"
						type="text" size="4">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">股票名稱：</td>
					<td width="600" height="40" align="left"><input id='num' disabled="disabled"
						style="text-align: left" name="stockName" value="${StockBean.stockName}"
						type="text" size="14">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">成交股數：</td>
					<td width="600" height="40" align="left"><input name="dealNumofstock" disabled="disabled"
						value="${StockBean.dealNumofstock}" type="text" size="20">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">成交金額：</td>
					<td width="600" height="40" align="left"><input disabled="disabled"
						name="dealPrice" value="${StockBean.dealPrice}" type="text">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">開盤價：</td>
					<td width="600" height="40" align="left"><input name="startPrice" disabled="disabled"
						value="${StockBean.startPrice}" type="text" size="20"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">最高價：</td>
					<td width="600" height="40" align="left"><input disabled="disabled"
						name="highestPrice" value="${StockBean.highestPrice}" type="text">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">最低價：</td>
					<td width="600" height="40" align="left"><input name="lowestPrice" disabled="disabled"
						value="${StockBean.lowestPrice}" type="text" size="14">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">收盤價：</td>
					<td width="600" height="40" align="left"><input name="endPrice" disabled="disabled"
						value="${StockBean.endPrice}" type="text" size="14">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">漲跌價差：</td>
					<td width="600" height="40" align="left"><input name="priceGap" disabled="disabled"
						value="${StockBean.priceGap}" type="text" size="14">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">成交量：</td>
					<td width="600" height="40" align="left"><input name="dealNum" disabled="disabled"
						value="${StockBean.dealNum}" type="text" size="14">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
          
</body>

</html>