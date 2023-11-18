<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Account"%>
<%
	Account registerAccount = (Account) session.getAttribute("registerAccount");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>アカウント登録確認画面</title>
	<link rel="icon" type="image/ico" href="images/favicon.ico">
	<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="inputAccount">
		<h1 class="login-title">登録してもよろしいですか？</h1>
		<div>
			<ul class="login-item">
				<li class="confirm-text-center">ID</li>
				<li class="confirm-item-text"><%=registerAccount.getAccountId()%></li>
			</ul>
			<ul>
				<li class="confirm-text-center">PASS</li>
				<li class="confirm-item-text"><%=registerAccount.getPass()%></li>
			</ul>
			<ul>
				<li class="confirm-text-center">NAME</li>
				<li class="confirm-item-text"><%=registerAccount.getName()%></li>
			</ul>
		</div>
		<ul class="submit-button">
			<li><a class="button" href="/JyankenGame/RegisterAccount">戻る</a></li>
			<li><a class="button"
					href="/JyankenGame/RegisterAccount?action=done">登録</a></li>
		</ul>
	</div>
</body>

</html>