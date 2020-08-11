public class Test64 {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        if (m == 0 || n == 0) return 0;
//        int[] dp = new int[n];
//        //求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (j == 0) {
//                    dp[j] = dp[j];        // 只能从上侧走到该位置
//                } else if (i == 0) {
//                    dp[j] = dp[j - 1];    // 只能从左侧走到该位置
//                } else {
//                    dp[j] = Math.min(dp[j - 1], dp[j]);
//                }
//                dp[j] += grid[i][j];
//            }
//        }
//        return dp[n-1];
//    }
    public int minPathSum(int[][] grid) {
        //求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0)
                    continue;
                else if(i == 0)  // 只能从上侧走到该位置
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  // 只能从上侧走到该位置
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                else
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
