import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        queens(board, 0, results);
        return results;
    }

    private void queens(boolean[][] board, int row, List<List<String>> results) {
        if (row == board.length) {
            results.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                queens(board, row + 1, results);
                board[row][col] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) return false;
        }

        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }

    private List<String> buildBoard(boolean[][] board) {
        List<String> rows = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean ele : row) {
                sb.append(ele ? 'Q' : '.');
            }
            rows.add(sb.toString());
        }
        return rows;
    }
}