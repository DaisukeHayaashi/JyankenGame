<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>じゃんけんゲーム - トップページ</title>
<link rel="stylesheet" href="css/ress.css">
<link rel="stylesheet" href="css/style.css">
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
	text-align: center;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

h1 {
	font-size: 24px;
	margin-bottom: 10px;
}

p {
	font-size: 18px;
	margin-bottom: 20px;
}

form {
	display: flex;
	flex-direction: column;
	align-items: center;
}

select {
	width: 200px;
	margin: 10px 0;
}

a {
	text-decoration: none;
	margin: 10px 0;
}

/* キャラクターごとのスタイル */
.character-image {
	width: 200px; /* 画像の幅を調整 */
}
</style>

</head>
<body>

	<h1>キャラクター選択</h1>
	<img src="image/character01.png" alt="選んだキャラクター1の画像">

	<!-- キャラクター選択のフォーム -->
	<form action="CharacterSelectServlet" method="post">
		<!-- アクションタイプを隠しフィールドとして設定 -->
		<input type="hidden" name="action" value="A">

		<!-- キャラクター選択のオプション -->
		<label for="character_Id">キャラクターを選択してください:</label> <select
			name="character_Id" id="character_Id">
			<!-- ここにサーバーサイドから取得したキャラクターリストを動的に展開するコードを追加 -->
			<option value="1" >キャラクター1</option>
			<!-- ...その他のキャラクターオプション... -->
		</select> <input type="submit" value="選択" class="button" />
		 <br> <a href="index.jsp" class="button">ログアウト</a>
	</form>
</body>
</html>
