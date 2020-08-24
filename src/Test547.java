public class Test547 {
    private int m;

    public int findCircleNum(int[][] M) {
        //注意：M[i][j]表达的意思是i和j是朋友
        //可以看作无向图
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int ans  = 0;
        m = M.length;
        //使用一个visited数组, 依次判断每个节点,
        //如果其未访问, 朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
        boolean[] isVisited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (!isVisited[i]){
                dfs(M, i, isVisited);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] M, int i, boolean[] isVisited){
        isVisited[i] = true;
        for (int j = 0; j < m; j++) {
            if (M[i][j] == 1 && !isVisited[j])
                dfs(M, j, isVisited);
        }
    }
}
