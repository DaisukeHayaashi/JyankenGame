package model;

public class CharacterSelection {
	private int game_id;
	private String account_id;
	private int character_id;
	private int enemycharacter_id;
	private int game_result_id;

	
	public CharacterSelection(int game_id, String account_id, int character_id, int enemycharacter_id,int game_result_id) {
		this.game_id = game_id;
		this.account_id = account_id;
		this.character_id = character_id;
		this.enemycharacter_id = enemycharacter_id;
		this.game_result_id = game_result_id;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public int getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
	}

	public int getEnemycharacter_id() {
		return enemycharacter_id;
	}

	public void setEnemycharacter_id(int enemycharacter_id) {
		this.enemycharacter_id = enemycharacter_id;
	}

	public int getGame_result_id() {
		return game_result_id;
	}

	public void setGame_result_id(int game_result_id) {
		this.game_result_id = game_result_id;
	}
}
