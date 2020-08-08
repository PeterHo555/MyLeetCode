public class Test485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        //暴力
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
