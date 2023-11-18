package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CharacterSelectServlet")
public class CharacterSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストからactionを取得
	    String action = request.getParameter("action");

	    if ("A".equals(action)) {
	        // 選択したキャラクターIDを取得
	        String characterId = request.getParameter("character_Id");

	        // 選択したキャラクターIDをセッションスコープに保存
	        HttpSession session = request.getSession();
	        session.setAttribute("character_Id", characterId);

	        // 敵キャラクターの選択画面に遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/enemySelect.jsp");
	        dispatcher.forward(request, response);

	    } else if ("B".equals(action)) {  // この行をelse ifに変更
	        String enemyCharacterId = request.getParameter("enemyCharacter_Id");

	        HttpSession session = request.getSession();
	        session.setAttribute("enemyCharacter_Id", enemyCharacterId);

	        // じゃんけん開始画面に遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/startJyanken.jsp");
	        dispatcher.forward(request, response);

	    } else {
	        // 予期しないactionの場合のエラーハンドリング
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	    }
	}
}