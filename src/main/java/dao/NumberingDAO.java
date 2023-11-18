package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NumberingDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/jyankengame?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "rootroot";

	public int findByNumbering() {
		int updateNumberingId = 1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "select numbering_id from Numbering ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int numberingId = rs.getInt("numbering_id");
				updateNumberingId = numberingId + 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateNumberingId;
	}

	public boolean gameIdNumbering(int updateNumberingId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "update Numbering set numbering_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, updateNumberingId);

			int result = pstmt.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
