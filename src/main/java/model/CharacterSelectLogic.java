package model;

import dao.GamesDAO;

public class CharacterSelectLogic {
	public boolean selectCharacter(CharacterSelection characterselection) {
		GamesDAO dao = new GamesDAO();
		 return dao.selectCharacter(characterselection);

	}
}