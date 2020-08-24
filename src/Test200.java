public class Test200 {
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int ans  = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int x, int y){
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1')
            return;//不再符合岛的条件，回溯
        //置为2标记为已经访问
        grid[x][y] = '2';
        for (int[] d : direction) {
            dfs(grid, x + d[0], y + d[1]);
        }
    }
}
