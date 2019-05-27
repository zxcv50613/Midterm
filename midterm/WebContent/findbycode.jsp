<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/index.css">
<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("update")
				.addEventListener("click", clickupdate);
		document.getElementById("delete")
				.addEventListener("click", clickdelete);
	})
	function clickupdate() {
		document.searchupdatedeleteStock.action = "UpdateStock.do"
	}
	function clickdelete() {
		document.searchupdatedeleteStock.action = "DeleteStock.do"
	}
</script>
<title>股市資訊</title>
</head>
<body>
	<div class="allpage">
		<header>
			<nav>
				<h1 style="text-align: center">全台首家股票系統上線辣</h1>
				<img src="pic/logo.png" alt="logo" width="1024px" height="100px">
			</nav>
		</header>
		<div class="picture"><img src="pic/congradulation1.gif" width="300px"></div>
		<div class="content">
			<form name="searchupdatedeleteStock" action="" method="POST">
				<table border="1" style="width: 500px">
					<thead>
						<tr bgcolor='tan'>
							<th height="60" colspan="2" align="center">(${stockCode})${stockName}股票資料${afterupdate}</th>
						</tr>
					</thead>
					<tbody>
						<tr bgcolor='tan'>
							<td width="120" height="40">股票代號：</td>
							<td width="600" height="40" align="left"><input id='num'
								style="text-align: left" name="stockCode" value="${stockCode}"
								type="text" size="4"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">股票名稱：</td>
							<td width="600" height="40" align="left"><input id='num'
								style="text-align: left" name="stockName" value="${stockName}"
								type="text" size="14"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">成交股數：</td>
							<td width="600" height="40" align="left"><input
								name="dealNumofstock" value="${dealNumofstock}" type="text"
								size="20"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">成交金額：</td>
							<td width="600" height="40" align="left"><input
								name="dealPrice" value="${dealPrice}" type="text"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">開盤價：</td>
							<td width="600" height="40" align="left"><input
								name="startPrice" value="${startPrice}" type="text" size="20"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">最高價：</td>
							<td width="600" height="40" align="left"><input
								name="highestPrice" value="${highestPrice}" type="text"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">最低價：</td>
							<td width="600" height="40" align="left"><input
								name="lowestPrice" value="${lowestPrice}" type="text" size="14"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">收盤價：</td>
							<td width="600" height="40" align="left"><input
								name="endPrice" value="${endPrice}" type="text" size="14"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">漲跌價差：</td>
							<td width="600" height="40" align="left"><input
								name="priceGap" value="${priceGap}" type="text" size="14"></td>
						</tr>
						<tr bgcolor='tan'>
							<td width="120" height="40">成交量：</td>
							<td width="600" height="40" align="left"><input
								name="dealNum" value="${dealNum}" type="text" size="14"></td>
						</tr>
						<tr bgcolor='tan'>
							<td height="50" colspan="2" align="center"><span>你要執行的動作是：</span>
								<span> <input type="button" id="update" value="修改">
									<input type="button" id="delete" value="刪除">
							</span></td>
						</tr>
						<tr bgcolor='tan'>
							<td height="50" colspan="2" align="center"><input
								type="submit" value="送出"></td>
						</tr>
					</tbody>
				</table>
			</form>
</body>
</html>