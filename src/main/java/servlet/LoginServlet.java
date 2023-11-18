package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.LoginLogic;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String accountId = request.getParameter("accountId");
		String pass = request.getParameter("pass");

		String loginErrorMsg = "";

		// ログインの処理
		Login login = new Login(accountId, pass);
		LoginLogic loginLogic = new LoginLogic();
		Account loginResult = loginLogic.execute(login); // Accountオブジェクトを受け取る

		if (loginResult != null) {
		    // ユーザー情報をセッションスコープに保存
		    HttpSession session = request.getSession();
		    session.setAttribute("loginAccount", loginResult);

		    // loginResultからアカウントIDを取得してセッションに保存
		    String sessionAccountId = loginResult.getAccountId();
		    session.setAttribute("account_Id", sessionAccountId);

		    // メイン画面にリダイレクト
		    response.sendRedirect("CharacterSelectServlet");
		} else {// ログイン失敗時
			// エラーメッセージをリクエストスコープに保存
			loginErrorMsg = "正しいIDとPASSを入力してください";
			HttpSession session = request.getSession();
			session.setAttribute("loginErrorMsg", loginErrorMsg);
			// ログイン画面にリダイレクト
			response.sendRedirect("/JyankenGame/");
		}

	}

}
