import java.util.List;

public class Test841 {
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // 记录能访问房间的总数
        num = 0;
        // 标记访问过的房间
        boolean[] vis = new boolean[n];
        dfs(rooms, 0, vis);
        // 若可访问的房间等于N，返回true，反之false
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x, boolean[] vis) {
        vis[x] = true; // 标记
        num++;
        for (int it : rooms.get(x)) {
            // 当前房间未被访问，对其深度优先搜索
            if (!vis[it]) {
                dfs(rooms, it, vis);
            }
        }
    }

}
