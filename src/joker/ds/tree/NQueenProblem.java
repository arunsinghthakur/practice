package joker.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    static List<List<String>> nQueen(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = init(n);
        placeQueen(board, 0, result);
        return result;
    }

    static void placeQueen(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            processResult(board, result);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            board[row][col] = 'Q';
            if (isValidMove(board, row, col)) {
                placeQueen(board, row + 1, result);
            }
            board[row][col] = '.';
        }
    }

    static void processResult(char[][] board, List<List<String>> result) {
        List<String> rs = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            rs.add(new String(board[i]));
        }
        result.add(rs);
    }

    static char[][] init(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    static boolean isValidMove(char[][] board, int x, int y) {
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 'Q' && ((x == row || y == col || (Math.abs(x - row) == Math.abs(y - col))))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(nQueen(4));
    }
}
