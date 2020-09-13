public class Test494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }
    //DFS
//    public int findTargetSumWays(int[] nums, int S) {
//        return findTargetSumWays(nums, 0, S);
//    }
//
//    private int findTargetSumWays(int[] nums, int start, int S) {
//        if (start == nums.length) {
//            return S == 0 ? 1 : 0;
//        }
//        return findTargetSumWays(nums, start + 1, S + nums[start]) + findTargetSumWays(nums, start + 1, S - nums[start]);
//    }
}
