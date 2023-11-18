package test;

import model.Account;
import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] args) {
		testExecuteOK();
		testExcecuteNG();
	}
	
	public static void testExecuteOK() {
		Login login = new Login("user123","password123");
		LoginLogic bo = new LoginLogic();
		Account result = bo.execute(login);
		
		if(result != null) {
			System.out.println("testExecuteOK:に成功しました");
		} else {
			System.out.println("testExecuteOK:に失敗しました");
		}
	}
	public static void  testExcecuteNG() {
		Login login = new Login("user1235", "password1235"); 
		LoginLogic bo = new LoginLogic();
		Account result = bo.execute(login);
		
		if(result == null) {
			System.out.println("testExcecuteNG:に成功しました");
		} else {
			System.out.println("testExcecuteNG:に失敗しました");
		}
	}
}

