public class Test665 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            //非递减情况直接跳下一位
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            //递减情况计数
            cnt++;
            //判断前两位是否大于当前位，
            //是：修改i位为i-1
            //否：修改i-1位为i
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
