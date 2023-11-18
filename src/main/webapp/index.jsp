<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String loginErrorMsg=(String) session.getAttribute("loginErrorMsg"); %>
<%
session.getAttribute("");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/ico" href="images/favicon.ico">
	<link rel="stylesheet" href="css/ress.css">
	

	<link rel="stylesheet" href="css/style.css">
	<title>ログイン画面</title>
</head>

<body>
	<div class="inputAccount">
	
		<form action="/JyankenGame/Login" method="post">
			<div class="msg-box errorMsg errorMsg-login">
				<% if (loginErrorMsg !=null) { %>
					<p><%=loginErrorMsg%></p>
				<% } %>
			</div>
			<ul>
				<li class="login-item"><span class="login-item-label">ID</span></li>
				<li><input type="text" name="accountId" pattern="^[0-9a-zA-Z]{4,12}$" placeholder="半角英数字4～12文字" required></li>
			</ul>
			<ul>
				<li class="login-item"><span class="login-item-label">PASS</span></li>
				<li><input type="password" name="pass" pattern="^[0-9a-zA-Z]{4,12}$" placeholder="半角英数字4～12文字" required></li>
			</ul>
			<ul class="submit-button-index">
				<li><input class="button" type="submit" value="ログイン"></li>
				<li><a class="button" href="/JyankenGame/RegisterAccount">新規登録</a></li>
			</ul>
		</form>
	</div>
	<% session.removeAttribute("loginErrorMsg"); %>
</body>

</html>