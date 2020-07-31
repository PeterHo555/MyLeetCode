public class Test70 {
    public int climbStairs(int n) {
        //总体思路，第n阶的方法数等于第n-1阶的方法数加第n-2阶的方法数
        if (n==1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
