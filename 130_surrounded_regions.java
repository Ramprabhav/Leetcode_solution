class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // First column and last column
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        // First row and last row
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // Convert remaining O → X
        // Convert # → O
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {

        // Boundary check
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length) {
            return;
        }

        // Stop if not O
        if (board[i][j] != 'O') {
            return;
        }

        // Mark as safe
        board[i][j] = '#';

        // Down
        dfs(board, i + 1, j);

        // Up
        dfs(board, i - 1, j);

        // Right
        dfs(board, i, j + 1);

        // Left
        dfs(board, i, j - 1);
    }
}