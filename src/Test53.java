public class Test53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            // 遍历每个元素，当sum大于0时与sum累加
            // 否则令sum等于num，意思是若最大自序和为负数，判断当前负元素是否为最大负元素
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
