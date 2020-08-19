import java.util.Arrays;

public class Test628 {
    public int maximumProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        //最大的三位数相乘
        ans = Math.max(ans, nums[len-1] * nums[len-2] * nums[len-3]);
        //如果有最小两个的负数的绝对值更大，那就负负得正再乘最大的数
        ans = Math.max(ans, nums[0] * nums[1] * nums[len-1]);
        return ans;
    }
}
