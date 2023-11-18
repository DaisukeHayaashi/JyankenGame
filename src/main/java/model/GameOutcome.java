package model;

public class GameOutcome {
	private int game_id;
	private int character_choice;
	private int enemycharacter_choice;

	public GameOutcome(int character_choice) {
		this.character_choice = character_choice;
	}


	public GameOutcome(int game_id, int character_choice, int enemycharacter_choice) {
//		this.jyanken_id = jyanken_id;
		this.game_id = game_id;
		this.character_choice = character_choice;
		this.enemycharacter_choice = enemycharacter_choice;

	}

	public GameOutcome(int characterChoice, int enemyChoice) {
		
	}


	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public int getCharacter_choice() {
		return character_choice;
	}

	public void setCharacter_choice(int character_choice) {
		this.character_choice = character_choice;
	}

	public int getEnemycharacter_choice() {
		return enemycharacter_choice;
	}

	public void setEnemycharacter_choice(int enemycharacter_choice) {
		this.enemycharacter_choice = enemycharacter_choice;
	}
}
