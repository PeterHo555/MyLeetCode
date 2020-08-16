public class Test413 {
    public int numberOfArithmeticSlices(int[] A) {
        //例子：
        //dp[2] = 1
        //    [0, 1, 2]
        //dp[3] = dp[2] + 1 = 2
        //    [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
        //    [1, 2, 3]     // 新的递增子区间
        //dp[4] = dp[3] + 1 = 3
        //    [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
        //    [1, 2, 3, 4],    // [1, 2, 3] 之后加一个 4
        //    [2, 3, 4]        // 新的递增子区间
        //综上，在 A[i] - A[i-1] == A[i-1] - A[i-2] 时，dp[i] = dp[i-1] + 1。
        //
        //因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果。
        if (A == null || A.length == 0)
            return 0;
        int len = A.length;
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int cur:dp) {
            ans += cur;
        }
        return ans;
    }
}
