package model;

import dao.AccountDAO;

public class FindByAccountIdLogic {
	// すでに存在しているIDなのか調べるロジック(アカウント新規作成する時に使う)
	public boolean findByAccountId(Account account) {
		AccountDAO dao = new AccountDAO();
		return dao.findByAccountId(account);// アカウントIDが存在した場合trueが帰ってくる
	}
}
