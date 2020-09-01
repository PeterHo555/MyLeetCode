public class Test486 {
    public boolean PredictTheWinner(int[] nums) {
        // 数量为偶数，先手必胜
        if (nums.length % 2 == 0) return true;
        return helper(0,nums.length - 1, nums) >= 0;
    }

    private int helper(int l, int r, int[] nums) {
        // 递归，计算当前选择的玩家能赢过对手的分数，求最大
        if (l == r) return nums[l];
        // 选左，左指针加一
        // 自己选左边，减去对手下次选能获得的最大分数
        int pickL = nums[l] - helper(l + 1, r, nums);
        // 选右，右指针减一
        // 自己选右边，减去对手下次选能获得的最大分数
        int pickR = nums[r] - helper(l, r - 1 , nums);
        return Math.max(pickL, pickR);
    }


}
