package test;

import dao.GamesDAO;
import model.CharacterSelection;
import model.GameOutcome;

public class GamesDAOTest {
	public static void main(String[] args) {
		testselectCharacterOK();
		
		testRecordGameOutcomeOK();
		//		testRecordGameOutcomeNG();
	}

	private static void testselectCharacterOK() {
		CharacterSelection characterselection = new CharacterSelection (1,"12345", 1, 2,1);
		GamesDAO dao = new GamesDAO();
		boolean result = dao.selectCharacter(characterselection);

		if (result) {
			System.out.println("testselectCharacterOK:成功しました");
		} else {
			System.out.println("testselectCharacterOK:失敗しました");
		}
	}

	

	private static void testRecordGameOutcomeOK() {
		GameOutcome gameOutcome = new GameOutcome(1, 'A', 'B');
		GamesDAO dao = new GamesDAO();
		boolean result = dao.recordGameOutcome(gameOutcome);

		if (result) {
			System.out.println("testRecordGameOutcomeOK:成功しました");
		} else {
			System.out.println("testRecordGameOutcomeOK:失敗しました");
		}
	}
}
//	private static void testRecordGameOutcomeNG() {
//		GameOutcome gameOutcome = new GameOutcome(2, 'A', 'B');
//		GamesDAO dao = new GamesDAO();
//		boolean result = dao.recordGameOutcome(gameOutcome);
//		if (!result) {
//			System.out.println("testRecordGameOutcomeNG:成功しました");
//		} else
//
//		{
//			System.out.println("testRecordGameOutcomeNG:失敗しました");
//		}
//	}
//
//}
