package test;

import dao.NumberingDAO;

public class NumberingDAOtest {
    public static void main(String[] args) {
        NumberingDAO numberingDAO = new NumberingDAO();

        // 新しい番号を取得
        int newNumber = numberingDAO.findByNumbering();
        System.out.println("新しい番号: " + newNumber);

        // 新しい番号をデータベースにアップデート
        boolean result = numberingDAO.gameIdNumbering(newNumber);
        if (result) {
            System.out.println("新しい番号がデータベースにアップデートされました。");
        } else {
            System.out.println("新しい番号のアップデートに失敗しました。");
        }
    }
}