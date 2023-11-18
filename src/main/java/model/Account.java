package model;

public class Account {
    private String accountId;
    private String pass;
    private String name;

    public Account(String accountId, String pass, String name) {
        this.accountId = accountId;
        this.pass = pass;
        this.name = name;
    }

    public Account(String accountId, String pass) {
		// TODO 自動生成されたコンストラクター・スタブ
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
