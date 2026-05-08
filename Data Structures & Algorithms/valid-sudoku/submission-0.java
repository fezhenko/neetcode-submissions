class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        boolean passable = true;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int squareIndex = (r / 3) * 3 + (c / 3);
                if (rows[r].contains(board[r][c]) || columns[c].contains(board[r][c])
                    || squares[squareIndex].contains(board[r][c])) {
                    passable = false;
                    break;
                }
                if (Objects.equals('.', board[r][c])) {
                    continue;
                }
                rows[r].add(board[r][c]);
                columns[c].add(board[r][c]);
                squares[squareIndex].add(board[r][c]);
            }
        }

        return passable;
    }
}
