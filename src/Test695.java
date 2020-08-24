public class Test695 {
    private int m, n;
    private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 ||grid[0].length ==0 )
            return 0;
        int maxArea = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y){
        if (x < 0 || x >= m ||y < 0 || y >= n || grid[x][y] == 0)
            return 0;
        //置为0表示已经访问过
        grid[x][y] = 0;
        int area = 1;
        //对四个方向进行dfs遍历
        for (int[] d : direction) {
            area += dfs(grid, x + d[0], y + d[1]);
        }
        return area;
    }
}
