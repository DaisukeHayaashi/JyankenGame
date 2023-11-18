<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>敵キャラクター選択</title>
<link rel="stylesheet" href="css/ress.css">
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>じゃんけん開始！</title>
<style>
body {
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    height: 100vh;
}


.circle-container {
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
}

.circle {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    border: 2px solid white; /* 円の色を白に変更 */
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 20px; /* 円同士の余白を調整 */
}

.circle.left, .circle.right {
    border: 2px solid transparent; /* 透明な境界線に変更 */
}

.vs {
    font-size: 2em; /* VSのサイズを調整 */
    margin: 0 140px;
    z-index: 1;
}

.button-container {
    margin-top: 100px; /* ボタンコンテナの上の余白を追加 */
    display: flex;
    flex-direction: column;
    align-items: center;
}

button, .logout-button {
    padding: 10px 20px;
    margin: 10px 0; /* 上下のみマージンを設定 */
    font-size: 16px;
    cursor: pointer;
    width: auto; /* 自動的に幅を設定 */
}

.logout-button {
    background-color: #f0f0f0;
    border: 1px solid #dcdcdc;
    text-decoration: none;
    color: black;
}
</style>
</head>
<body>
    <!--じゃんけん開始を促すフォーム -->
    <form action="JyankenServlet" method="post">
        <input type="hidden" name="action" value="C">
        <div class="circle-container">
            <div class="circle left">
                <!-- 左側のキャラクターの画像 -->
                <img src="image/character01.png" alt="選んだキャラクター1の画像">
            </div>
            <div class="vs">VS</div>
            <div class="circle right">
                <!-- 右側のキャラクターの画像 -->
                <img src="image/enemycharacter01.png" alt="選んだ敵キャラクター1の画像">
            </div>
        </div>
        <!-- "ドンッ！"の画像 -->
  
        <!-- ボタンコンテナ -->
        <div class="button-container">
            <!-- じゃんけん開始ボタン -->
            <button type="submit">じゃんけん開始！</button>
            <!-- ログアウトボタン -->
            <a href="LogoutServlet" class="logout-button">ログアウト</a>
        </div>
    </form>
</body>
</html>
