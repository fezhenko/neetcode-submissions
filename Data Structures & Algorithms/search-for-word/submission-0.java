class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }

        int[][] dimensions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(
        char[][] board, int indexRow, int indexCol, int indexMatchedChar, String word) {
        if (indexMatchedChar == word.length()) {
            return true;
        }

        // false path
        if (indexRow < 0 || indexRow >= board.length || indexCol < 0 || indexCol >= board[0].length
            || board[indexRow][indexCol] == '#'
            || board[indexRow][indexCol] != word.charAt(indexMatchedChar)) {
            return false;
        }

        char tmp = board[indexRow][indexCol];
        board[indexRow][indexCol] = '#';

        boolean found = dfs(board, indexRow + 1, indexCol, indexMatchedChar + 1, word)
            || dfs(board, indexRow, indexCol + 1, indexMatchedChar + 1, word)
            || dfs(board, indexRow - 1, indexCol, indexMatchedChar + 1, word)
            || dfs(board, indexRow, indexCol - 1, indexMatchedChar + 1, word);

        board[indexRow][indexCol] = tmp;
        return found;
    }
}
