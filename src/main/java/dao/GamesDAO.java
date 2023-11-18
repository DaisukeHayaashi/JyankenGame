package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CharacterSelection;
import model.GameOutcome;

public class GamesDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/jyankengame?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "rootroot";

	public boolean selectCharacter(CharacterSelection characterselection) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO games (account_id, character_id, enemycharacter_id,game_result_id) VALUES (?, ?, ?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, characterselection.getAccount_id());
			pstmt.setInt(2, characterselection.getCharacter_id());
			pstmt.setInt(3, characterselection.getEnemycharacter_id());
			pstmt.setInt(4, characterselection.getGame_result_id());

			int result = pstmt.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean recordGameOutcome(GameOutcome gameOutcome) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO Jyankens (character_choice, enemycharacter_choice) VALUES (?, ?)";
			// PreparedStatementを自動生成されたキーを取得するように設定します。
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, gameOutcome.getCharacter_choice());
			pstmt.setInt(2, gameOutcome.getEnemycharacter_choice());

			int result = pstmt.executeUpdate();

			// 自動生成されたキーを取得します。
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					// 自動生成されたキー（game_id）をGameOutcomeオブジェクトにセットします。
					gameOutcome.setGame_id(generatedKeys.getInt(1));
				} else {
					throw new SQLException("ゲームIDの生成に失敗しました。");
				}
			}

			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
