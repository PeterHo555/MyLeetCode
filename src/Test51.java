import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test51 {
    // 每一行从上到下的填充
    public List<List<String>> solveNQueens(int n) {
        if(n <= 0) return new ArrayList<List<String>>();
        List<List<String>> res = new ArrayList<>();
        int y = 0;
        for(int x = 0; x < n; x++) {
            char[][] tmp = new char[n][n];
            boolean[] col = new boolean[n];
            for(char[] cs : tmp) {
                Arrays.fill(cs, '.');
            }
            tmp[y][x] = 'Q';
            col[x] = true;
            dfs(n, 1, col, tmp, res);
        }
        return res;
    }

    public void dfs(int n, int y, boolean[] col, char[][] tmp, List<List<String>> res) {
        if(y == n) {
            List<String> list = new ArrayList<>();
            for(char[] cs : tmp) {
                StringBuilder sb = new StringBuilder();
                for(char c : cs) {
                    sb.append(c);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isValid(n, y, i, col, tmp)) {
                tmp[y][i] = 'Q';
                col[i] = true;
                dfs(n, y + 1, col, tmp, res);
                col[i] = false;
                tmp[y][i] = '.';
            }
        }
    }

    private boolean isValid(int n, int y, int x, boolean[] col, char[][] tmp) {
        if(col[x]) return false;
        for(int i = 1; i < n; i++) {
            if(y - i >= 0 && x + i < n && tmp[y - i][x + i] == 'Q') {
                return false;
            }
            if(y - i >= 0 && x - i >= 0 && tmp[y - i][x - i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
