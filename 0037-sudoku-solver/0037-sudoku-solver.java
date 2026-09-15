class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean empty = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    empty = true;
                    break;
                }
            }
            if (empty) break;
        }

        if (!empty) {
            return true;
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (board[row][i] == num) return false;
        }

        for (int i = 0; i < n; i++) {
            if (board[i][col] == num) return false;
        }

        int sqrt = (int) Math.sqrt(n);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;

        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = startCol; j < startCol + sqrt; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}