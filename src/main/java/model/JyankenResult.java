package model;

public class JyankenResult {
    private int character_choice;
    private int enemycharacter_choice;
    private int game_id;
    private int game_result_id;

    // コンストラクタ1
    public JyankenResult(int character_choice, int enemycharacter_choice, int game_id, int game_result_id) {
        this.character_choice = character_choice;
        this.enemycharacter_choice = enemycharacter_choice;
        this.game_id = game_id;
        this.game_result_id = game_result_id;
    }

    // コンストラクタ2
    public JyankenResult(int characterChoice, int enemyChoice, int gameResultId) {
        this.character_choice = characterChoice;
        this.enemycharacter_choice = enemyChoice;
        this.game_result_id = gameResultId;
        // game_id が設定されていないため、0または適切な値に設定する必要があります。
        this.game_id = 0; // または適切な値に設定する
    }
    
    public String getCharacterChoiceAsString() {
        return convertChoiceToString(this.character_choice);
    }

    public String getEnemyChoiceAsString() {
        return convertChoiceToString(this.enemycharacter_choice);
    }

    private String convertChoiceToString(int choice) {
        switch (choice) {
            case 1: return "ぐー";
            case 2: return "ちょき";
            case 3: return "ぱー";
            default: return "不明"; // 無効な選択肢
        }
    }

	public int getCharacter_choice() {
		return character_choice;
	}

	public void setCharacter_choice(int characterChoice) {
		this.character_choice = characterChoice;
	}

	public int getEnemycharacter_choice() {
		return enemycharacter_choice;
	}

	public void setEnemycharacter_choice(int enemycharacter_choice) {
		this.enemycharacter_choice = enemycharacter_choice;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public int getGame_result_id() {
		return game_result_id;
	}

	public void setGame_result_id(int game_result_id) {
		this.game_result_id = game_result_id;
	}

}