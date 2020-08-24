import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test417 {
    int row, col;
    int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ansList;
        row = matrix.length;
        col = matrix[0].length;
        this.matrix = matrix;//延伸至全局可用
        boolean[][] canReachP = new boolean[row][col];
        boolean[][] canReachA = new boolean[row][col];
        //遍历边界，第0列和最后一列，
        for (int i = 0; i < row; i++) {
            dfs(canReachP, i, 0);//太平洋
            dfs(canReachA, i, col - 1);//大西洋
        }
        //遍历边界，第0行和最后一行，
        for (int i = 0; i < col; i++) {
            dfs(canReachP, 0, i);//太平洋
            dfs(canReachA, row - 1, i);//大西洋
        }
        //遍历所有点，将能流向大西洋和太平洋的存入ansList
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (canReachP[i][j] && canReachA[i][j])
                    ansList.add(Arrays.asList(i, j));
            }
        }
        return ansList;
    }

    private void dfs(boolean[][] canReach, int r, int c){
        if (canReach[r][c])//标记过则回溯
            return;
        //标记
        canReach[r][c] = true;
        //对四个不同方向进行dfs遍历
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            //条件过滤
            if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || matrix[r][c] > matrix[nextR][nextC])
                continue;
            dfs(canReach, nextR, nextC);
        }
    }
}
