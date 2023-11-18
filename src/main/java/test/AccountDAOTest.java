package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK();
		testFindByLoginNG();
	}
	
	public static void testFindByLoginOK() {
		Login login = new Login("user123","password123");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		
		if(result != null && 
           result.getAccountId().equals("user123") &&  
           result.getPass().equals("password123") &&  
           result.getName().equals("John Doe") ) {  
			System.out.println("testFindByLoginOK:に成功しました");
		} else {
			System.out.println("testFindByLoginOK:に失敗しました");
		}
	}
	public static void  testFindByLoginNG() {
		Login login = new Login("user1235", "password1235"); 
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		
		if(result==null) {
			System.out.println("testFindByLoginNG:に成功しました");
		} else {
			System.out.println("testFindByLoginNG:に失敗しました");
		}
	}
}
