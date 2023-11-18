package model;

import dao.AccountDAO;

public class AccountCreateLogic {
	public boolean accountCreate(Account account) {
		AccountDAO dao = new AccountDAO();
		return dao.accountCreate(account);// 新規登録が成功した場合trueが帰ってくる
		// 新規登録する時に何らかのエラーが起きた場合falseが帰ってきて登録できないの
	}
}
