package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/jyankengame?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "rootroot";

	public Account findByLogin(Login login) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		Account account = null;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ACCOUNT_ID, PASS, NAME FROM ACCOUNTS WHERE ACCOUNT_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getAccountId());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String accountId = rs.getString("ACCOUNT_ID");
				String pass = rs.getString("PASS");
				String name = rs.getString("NAME");
				account = new Account(accountId, pass, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

	public boolean findByAccountId(Account account) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ACCOUNT_ID FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getAccountId());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean accountCreate(Account account) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO ACCOUNTS(ACCOUNT_ID, PASS, NAME) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, account.getAccountId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
