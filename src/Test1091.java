
import java.util.LinkedList;
import java.util.Queue;

public class Test1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int ans = 0;
        int[][] direction = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grid.length, n = grid[0].length;
        //bfs的老套路 来个队列
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});//把起点扔进去
        while (!queue.isEmpty()){
            int size =queue.size();
            ans++;
            while (size-- > 0){
                int[] cur = queue.poll();
                int crrX = cur[0], curY = cur[1];
                if (grid[crrX][curY] == 1){
                    continue;
                }
                // 能放进队列里的都是为0可以走的（这一点在后面保证了）
                // 如果等于终点则返回
                if (crrX == m - 1 && curY == n - 1){
                    return ans;
                }
                grid[crrX][curY] = 1;//标记
                //开始八个方向的判断
                for (int[] d : direction) {
                    int newX = crrX + d[0], newY = curY + d[1];
                    //这里开始过滤
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n){
                        continue;
                    }
                    //把在数组范围内 并且为0不阻塞的放入队列中
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }
}
