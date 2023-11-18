package model;

public class ResultLogic {

    public String getResultMessage(JyankenResult result) {
        int resultId = result.getGame_result_id();
        switch (resultId) {
            case 1: return "勝ち";
            case 2: return "負け";
            case 0: return "あいこ"; // 0 があいこに対応
            default: return "結果不明"; // このケースは基本的には発生しない
        }
    }
    
    // 他のビジネスロジックが必要な場合はここに追加
}
