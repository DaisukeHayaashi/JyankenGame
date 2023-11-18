<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String errorIdMsg = (String) session.getAttribute("registeredIdMsg");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新規登録</title>
    <link rel="stylesheet" href="css/ress.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="inputAccount">
        <h3>新規アカウント登録</h3>
        <form action="/JyankenGame/RegisterAccount" method="post">
            <div class="msg-box"></div>
            <ul class="register-item">
                <li><span class="register-item-label">ID</span><input type="text" name="accountId" placeholder="半角英数4～12文字" pattern="^[0-9a-zA-Z]{4,12}$" required></li>
                
                <li><span class="register-item-label">PASS</span><input type="password" name="pass" placeholder="半角英数4～12文字" pattern="^[0-9a-zA-Z]{4,12}$" required></li>
                <li><span class="register-item-label">NAME</span><input type="text" name="name" placeholder="1～8文字（空白不可）" pattern="^\S{1,8}$" required></li>
                <li class="errorMsg msg-box">
                    <% if (errorIdMsg != null) { %>
                        <%=errorIdMsg%>
                    <% } %>
                </li>
            </ul>
            
            <ul class="submit-button">
                <li><a class="button" href="/JyankenGame/">戻る</a></li>
                <li><input class="button" type="submit" value="確認"></li>
            </ul>
        </form>
    </div>
    <%
        session.removeAttribute("registeredIdMsg") ;
    %>
</body>
</html>
