public class Test37 {
    private boolean[][] rowsUsed = new boolean[9][10];
    private boolean[][] colsUsed = new boolean[9][10];
    private boolean[][] cubesUsed = new boolean[9][10];
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        // 先将全部已经存入数值的点标记
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                rowsUsed[i][num] = true;
                colsUsed[j][num] = true;
                cubesUsed[cubeNum(i, j)][num] = true;
            }
        backtracking(0, 0);
    }

    private boolean backtracking(int row, int col) {
        // 搜寻空位置
        while (row < 9 && board[row][col] != '.') {
            // 如果col是最后一列，row++，col重新置为0，搜寻空位置
            // col不是最后一列，row不变，col++，搜寻空位置
            row = col == 8 ? row + 1 : row;
            col = col == 8 ? 0 : col + 1;
        }
        // 搜索到最后一行+1，全部搜完了
        if (row == 9) {
            return true;
        }
        for (int num = 1; num <= 9; num++) {
            if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[cubeNum(row, col)][num]) {
                continue;
            }
            // 标记并存入数字的字符形式
            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = true;
            board[row][col] = (char) (num + '0');
            // 回溯
            if (backtracking(row, col)) {
                return true;
            }
            // 删除标记并置空
            board[row][col] = '.';
            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = false;
        }
        return false;
    }
    // 确定当前点的3*3模块
    private int cubeNum(int i, int j) {
        int r = i / 3;
        int c = j / 3;
        return r * 3 + c;
    }
//    private boolean[][] rowUsed = new boolean[9][10];
//    private boolean[][] colUsed = new boolean[9][10];
//    private boolean[][] cubeUsed = new boolean[9][10];
//
//    public void solveSudoku(char[][] board) {
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') {
//                    continue;
//                }
//                int num = board[i][j] - '0';
//                // 标记第i行使用了此数
//                rowUsed[i][num] = true;
//                // 标记第j列使用了此数
//                colUsed[j][num] = true;
//                // 标记第cubeNum(i, j)个模块使用了此数
//                cubeUsed[cubeNum(i, j)][num] = true;
//            }
//        }
//        backTracking(0, 0, board);
//    }
//
//
//    private boolean backTracking(int row, int col, char[][] board){
//        // 找寻空位置
//        while (row < 9 && board[row][col] != '.') {
//            // 如果col是最后一列，row++，col重新置为0，搜寻空位置
//            // col不是最后一列，row不变，col++，搜寻空位置
//            row = col == 8 ? row + 1 : row;
//            col = col == 8 ? 0 : col + 1;
//        }
//        // 搜索到最后一行+1，全部搜完了
//        if (row == 9) {
//            return true;
//        }
//        for (int num = 1; num <= 9; num++) {
//            // 此行或此列或此模块已被标记，continue
//            if (rowUsed[row][num] || cubeUsed[col][num] || cubeUsed[cubeNum(row, col)][num]){
//                continue;
//            }
//            // 标记
//            rowUsed[row][num] = true;
//            cubeUsed[col][num] = true;
//            cubeUsed[cubeNum(row, col)][num] = true;
//            // 存入数字的字符形式
//            board[row][col] = (char)(num + '0');
//            // 回溯
//            if (backTracking(row, col, board)){
//                return true;
//            }
//            // 置空并删除标记
//            board[row][col] = '.';
//            rowUsed[row][num] = false;
//            cubeUsed[col][num] = false;
//            cubeUsed[cubeNum(row, col)][num] = false;
//        }
//        return false;
//    }
//
//    // 计算当前点属于那个3*3模块
//    private int cubeNum(int row, int col){
//        int r = row / 3;
//        int c = col / 3;
//        return r * 3 + c;
//    }
}
