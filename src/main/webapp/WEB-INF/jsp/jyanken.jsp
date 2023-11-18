<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>じゃんけんゲーム</title>
<link rel="stylesheet" href="css/style.css">
<style>
/* 以下はstyle.cssに追加または修正する内容です */

.container {
    text-align: center; /* コンテナ内の要素を中央揃えに */
}

.character-container {
    display: flex;
    flex-direction: column; /* 要素を縦に並べる */
    align-items: center; /* 要素を中央揃えに */
}

.enemy-character {
    max-width: 200px; /* 画像の最大幅を設定 */
    margin-top: 20px; /* 上部の余白 */
}

.choice-buttons {
    display: flex;
    justify-content: center; /* ボタンを中央揃えに */
    margin-top: 20px; /* 上部の余白 */
}

.choice-buttons button {
    margin: 0 10px; /* ボタン間の余白を設定 */
    padding: 10px 20px; /* ボタンの内側余白 */
}

/* その他のスタイルは既存のstyle.cssに従う */
</style>
<script>
window.onload = function() {
  // ユーザーの選択を表示する関数を定義
  function showUserChoice(choice) {
    var userChoiceDiv = document.getElementById("userChoice");
    userChoiceDiv.textContent = "ユーザーの選択: " + choice;
  }

  // 各ボタンにイベントリスナーを追加
  document.getElementById("rockButton").onmouseover = function() { showUserChoice("ぐー"); };
  document.getElementById("scissorsButton").onmouseover = function() { showUserChoice("ちょき"); };
  document.getElementById("paperButton").onmouseover = function() { showUserChoice("ぱー"); };

  // マウスがボタンから離れた時に選択を「未選択」に戻す
  var buttons = document.getElementsByClassName("choice-button");
  for (var i = 0; i < buttons.length; i++) {
    buttons[i].onmouseout = function() { showUserChoice("未選択"); };
  }
};
</script>
</head>
<body>
	<form id="jankenForm" action="JyankenServlet" method="post">
		<input type="hidden" id="userChoiceInput" name="action" value="D">
		<div class="container">
			<div class="character-container">
				<img src="image/enemycharacter01.png" alt="敵キャラ" class="enemy-character" />
				<div class="character" id="userChoice">ユーザーの選択: 未選択</div>
			</div>
			<div class="choice-buttons">
				<button id="rockButton" type="submit" name="button" value="1">ぐー</button>
				<button id="scissorsButton" type="submit" name="button" value="2">ちょき</button>
				<button id="paperButton" type="submit" name="button" value="3">ぱー</button>
			</div>
			<span id="message"></span>
		</div>
	</form>
</body>
</html>