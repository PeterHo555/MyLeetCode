import java.util.*;

public class Test279 {
    // dp[i]：表示完全平方数和为i的 最小个数
    // 初始状态dp[i]均取最大值i，即 1+1+...+1，i个1; dp[0] = 0
    // dp[i] = min(dp[i], dp[i-j*j]+1)，其中, j是平方数, j=1~k,其中k*k要保证 <= i
    // 意思就是：完全平方数和为i的 最小个数 等于 当前完全平方数和为i的 最大个数
    //   与 （完全平方数和为 i - j * j 的 最小个数 + 完全平方数和为 j * j的 最小个数）
    //   可以看到 dp[j*j] 是等于1的
//    public int numSquares(int n) {
//        int[] dp = new int[n + 1]; // 默认初始化值都为0
//        for (int i = 1; i <= n; i++) {
//            dp[i] = i; // 最坏的情况就是每次+1
//            for (int j = 1; i - j * j >= 0; j++) {
//                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
//            }
//        }
//        return dp[n];
//    }

    //BFS
    public int numSquares(int n) {
        //生成小于n平方数序列
        List<Integer> squares = generateSquares(n);
        //BFS套路队列
        Queue<Integer> queue = new LinkedList<>();
        //标记数组
        boolean[] marked = new boolean[n + 1];
        //扔进起点
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                System.out.println(cur);
                //遍历每个平方数，
                for (int s : squares) {
                    int next = cur - s;
                    System.out.println("：：："+next);
                    //next小于0，不符合条件
                    if (next < 0) {
                        break;
                    }
                    //减至为0，返回level
                    if (next == 0) {
                        return level;
                    }
                    //此平方数已被标记，进行下一次循环
                    if (marked[next]) {
                        continue;
                    }
                    System.out.println("：："+next);
                    //标记当前数减去所有平方数的剩余数
                    //并加入队列
                    //将次数的所有剩余数加入队列，BFS思想
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     * @return 1,4,9,...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
