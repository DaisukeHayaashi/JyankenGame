package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NumberingDAO;
import model.Account;
import model.CharacterSelectLogic;
import model.CharacterSelection;
import model.GameOutcome;
import model.JyankenResult;
import model.ResultLogic;
import model.VictoryDeterminationLogic;

/**
 * Servlet implementation class JyankenServlet
 */
@WebServlet("/JyankenServlet")

public class JyankenServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // top.jspにリクエストを転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
        dispatcher.forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // セッションの取得と文字コードの設定
	    HttpSession session = request.getSession();
	    request.setCharacterEncoding("UTF-8");

	    // セッションからアカウントIDとキャラクターIDを取得

	    // リクエストからアクションの種類を取得
	    String action = request.getParameter("action");
//	    String button = request.getParameter("button");

	    if ("C".equals(action)) {
	    	String accountId = (String) session.getAttribute("account_Id");
	    	int characterId = Integer.parseInt((String) session.getAttribute("character_Id"));
	    	int enemyCharacterId = Integer.parseInt((String) session.getAttribute("enemyCharacter_Id"));
	    	
	    	NumberingDAO numberingDAO = new NumberingDAO();
	    	int  game_id = numberingDAO.findByNumbering();
	    	 numberingDAO.gameIdNumbering(game_id);
	    	// キャラクター選択情報をセッションに保存する   
	    	
	    	CharacterSelection selection = new CharacterSelection(game_id, accountId, characterId, enemyCharacterId, -2);
	    	session.setAttribute("selection", selection);

	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/jyanken.jsp");
	        dispatcher.forward(request, response);
	    } else  {
	        // じゃんけんの選択を取得
	    	int characterChoice = Integer.parseInt(request.getParameter("button"));
	        
	        // じゃんけんの結果を決定する
	        GameOutcome gameOutcome = new GameOutcome(characterChoice);
	        VictoryDeterminationLogic determinationLogic = new VictoryDeterminationLogic();
	        int gameResultId = determinationLogic.determineVictory(gameOutcome);
	        CharacterSelection selection = (CharacterSelection)session.getAttribute("selection");
	        // キャラクター選択のゲーム結果IDを更新
	        selection.setGame_result_id(gameResultId);

	        // ここでキャラクター選択をデータベースに登録
	        CharacterSelectLogic selectionLogic = new CharacterSelectLogic();
	        Account account = (Account)session.getAttribute("loginAccount");
	        selection.setAccount_id(account.getAccountId());
	        boolean isRegistered = selectionLogic.selectCharacter(selection);

	        if (!isRegistered) {
	            // 登録エラーの処理
	            String errorMsg = "キャラクターの登録に失敗しました。";
	            session.setAttribute("errorMsg", errorMsg);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/startJyanken.jsp");
	            dispatcher.forward(request, response);
	            return;
	        }

	        // じゃんけん結果を生成してリクエストにセット
	        JyankenResult jyankenResult = new JyankenResult(characterChoice, gameOutcome.getEnemycharacter_choice(), gameResultId);
	        request.setAttribute("jyankenResult", jyankenResult);
	        
	        ResultLogic resultLogic = new ResultLogic();
	        String resultMessage = resultLogic.getResultMessage(jyankenResult);
	        request.setAttribute("resultMessage", resultMessage);

	        // 結果表示ページにフォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
	        dispatcher.forward(request, response);
	    }
	}
}