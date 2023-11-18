package model;

public class Login {
	private String accountId;
	private String pass;
	public Login(String accountId,String pass) {
		this.accountId = accountId;
		this.pass = pass;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}