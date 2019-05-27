<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <div class="picture"><img src="pic/congradulation2.gif" width="400px"></div>
        <div class="content">
        <h2>資料已刪除成功</h2>
        <h3>倒數時間返回查詢首頁</h3>
         <div id="count"><img src="pic/count.gif" width="500px"></div>

<script>
	setInterval("window.location = 'http://localhost:8080/midterm/Stock.jsp'", 4900);
</script>

</body>
</html>
