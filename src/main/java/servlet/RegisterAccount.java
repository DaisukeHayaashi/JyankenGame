package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.AccountCreateLogic;
import model.FindByAccountIdLogic;

/**
 * Servlet implementation class RegisterAccount
 */
@WebServlet("/RegisterAccount")
public class RegisterAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// 画面の遷移先を決定する「action」の値をリクエストパラメータから取得
		String action = request.getParameter("action");

		String forwardPath = null;

		// 新規登録をリクエストされた時
		if (action == null) {
			// 登録画面へ遷移する
			forwardPath = "WEB-INF/jsp/registerAccount.jsp";
		}
		// 登録画面で登録をリクエストされた時
		else if (action.equals("done")) {
			// セッションスコープに保存されたアカウントを取得
			Account registerAccount = (Account) session.getAttribute("registerAccount");
			// 登録作業
			AccountCreateLogic accountCreateLogic = new AccountCreateLogic();
			boolean result = accountCreateLogic.accountCreate(registerAccount);

			// 登録作業の結果処理
			if (result == false) {
				String registerErrorMsg = "登録に失敗しました";
				session.setAttribute("registerErrorMsg", registerErrorMsg);
			}

			// 登録で使用したアカウント情報を削除
			session.removeAttribute("registerAccount");

			// 登録結果画面へフォワード
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 登録画面で確認をリクエストされた時
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String accountId = request.getParameter("accountId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String forwardPath = null;
		String registeredIdMsg = "";

		// 登録の処理
		Account registerAccount = new Account(accountId, pass, name);
		FindByAccountIdLogic findByAccountIdLogic = new FindByAccountIdLogic();
		boolean isAccountId = findByAccountIdLogic.findByAccountId(registerAccount);

		if (isAccountId) {// IDが登録されている場合
			registeredIdMsg = "登録されているIDです<br>";
		}

		HttpSession session = request.getSession();
		if (isAccountId) {
			session.setAttribute("registeredIdMsg", registeredIdMsg);
			// 登録されている場合、フォワードで登録情報入力画面に遷移
			forwardPath = "/WEB-INF/jsp/registerAccount.jsp";

		} else if (isAccountId == false) {
			// アカウント情報をセッションスコープに保存
			session.setAttribute("registerAccount", registerAccount);
			forwardPath = "/WEB-INF/jsp/confirmAccount.jsp";
		}
		// エラーがある場合は新規登録画面、保存に問題がなければ結果画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
}
