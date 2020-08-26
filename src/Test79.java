public class Test79 {
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backTracking(0, i, j, visited, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(int curLen, int r, int c, boolean[][] visited, char[][] board, String word) {
        //curLen从0开始，若与word长度相等，则证明前面各位字母相等，返回true
        if (curLen == word.length()) {
            return true;
        }
        //边界过滤条件
        //判断单词的此位是否相等
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != word.charAt(curLen) || visited[r][c]) {
            return false;
        }
        //标记为已经访问
        visited[r][c] = true;
        //四个方向的回溯
        for (int[] d : direction) {
            if (backTracking(curLen + 1, r + d[0], c + d[1], visited, board, word)) {
                return true;
            }
        }
        //下个起点可能需要再次访问此点，所以去除标记
        visited[r][c] = false;
        return false;
    }
}
