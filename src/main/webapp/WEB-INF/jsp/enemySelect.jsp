<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>敵キャラクター選択</title>
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
	<img src="image/enemycharacter01.png" alt="選んだキャラクター1の画像">

	<form action="CharacterSelectServlet" method="post">
		<input type="hidden" name="action" value="B"> <label
			for="enemyCharacter_Ids">敵キャラクターを選択してください:</label> <select
			name="enemyCharacter_Id" id="enemyCharacter_Id">
			<!-- オプションを動的に生成する部分 -->
			<option value="3" >敵キャラクター1</option>
			<!-- 他のキャラクターオプションを追加 -->
		</select> <input type="submit" value="選択" class="button">
		 <br> <a href="index.jsp" class="button">ログアウト</a>
	</form>
</body>
</html>
