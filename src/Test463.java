public class Test463 {
    public int islandPerimeter(int[][] grid) {
        // 直接遍历数组，只要前面有相邻的方格，就-2
        if (grid == null || grid.length == 0) return 0;
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    sum += 4;
                    if (i > 0 && grid[i - 1][j] == 1) sum -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) sum -= 2;
                }
            }
        }
        return sum;
    }
}
