<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.JyankenResult" %>  <!-- JyankenResultをインポート -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>じゃんけんゲーム - 結果</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>じゃんけんの結果</h1>
        <% 
    JyankenResult jankenResult = (JyankenResult) request.getAttribute("jyankenResult");
    String resultMessage = (String) request.getAttribute("resultMessage");

    if (jankenResult != null) {
%>
        <p>あなたの選択: <%= jankenResult.getCharacterChoiceAsString() %></p>
        <p>相手の選択: <%= jankenResult.getEnemyChoiceAsString() %></p>
<% 
    }

    if (resultMessage != null) {
%>
        <p id="resultMessage">結果メッセージ： <%= resultMessage %></p>
<% 
    }
%>
        <a class="button" href="JyankenServlet">トップに戻る</a>
    </div>
</body>
</html>
