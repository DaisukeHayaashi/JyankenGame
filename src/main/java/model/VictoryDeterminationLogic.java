package model;

import java.util.Random;

import dao.GamesDAO;

public class VictoryDeterminationLogic {

    public int determineVictory(GameOutcome gameOutcome) {
        // 敵の選択を1から3の間でランダムに設定します。
        int enemyCharacterChoice = new Random().nextInt(3) + 1;
        gameOutcome.setEnemycharacter_choice(enemyCharacterChoice);
        //1は、ぐー
        //2は、ちょき
        //3は、ぱー
        // プレイヤーの選択を取得します。
        int playerCharacterChoice = gameOutcome.getCharacter_choice();

        // 勝敗判定ロジック
        if (playerCharacterChoice == enemyCharacterChoice) {
            // 同じ選択はあいこ
            return 0;
        } else if ((playerCharacterChoice == 1 && enemyCharacterChoice == 2) || 
                   (playerCharacterChoice == 2 && enemyCharacterChoice == 3) || 
                   (playerCharacterChoice == 3 && enemyCharacterChoice == 1)) {
            // プレイヤーの勝ち
            return 1;
        } else {
            // プレイヤーの負け
            return 2;
        }
    }
	public void excute(GameOutcome gameOutcome) {
		GamesDAO dao = new GamesDAO();
		dao.recordGameOutcome(gameOutcome);
	}
}
