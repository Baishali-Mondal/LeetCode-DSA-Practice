
class Solution {

    boolean solve(int row, int col,
                  int ind,
                  char[][] board,
                  String word) {

        // The entire target word has been found
        if (ind == word.length()) {
            return true;
        }

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Current character doesn't match
        if (board[row][col] != word.charAt(ind)) {
            return false;
        }

        // Storing original character
        char original = board[row][col];

        // Mark as visited
        board[row][col] = '$';

        // Explore 4 directions
        boolean found =
            solve(row + 1, col, ind + 1, board, word) || // Down
            solve(row - 1, col, ind + 1, board, word) || // Up
            solve(row, col + 1, ind + 1, board, word) || // Right
            solve(row, col - 1, ind + 1, board, word);   // Left

        // Backtrack / restore
        board[row][col] = original;

        return found;
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        // Try every cell as starting point
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (solve(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}