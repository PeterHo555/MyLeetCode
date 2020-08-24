public class Test130 {
    private int row, col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        row = board.length;
        col = board[0].length;
        //遍历边界，第0列和最后一列，标记所有未为X包围的O
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        //遍历边界，第0行和最后一行，标记所有未为X包围的O
        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }
        //将未被标记的O全部改为X
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O') {
            return;
        }
        //标记为'T'表示为已经访问过
        board[r][c] = 'T';
        //四个方向的遍历
        for (int[] d : direction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}
