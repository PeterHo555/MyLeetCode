import java.util.Arrays;

public class Test300 {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            // 记录当前点的暂时最长递增子序列（到i点为止）
            dp[i] = max;
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
