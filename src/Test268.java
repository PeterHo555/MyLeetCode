public class Test268 {
    public int missingNumber(int[] nums) {
        int ans = 0;
        //对所有元素进行异或操作，相同元素的异或答案为0，所以结果最后为缺少的数
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ i ^ nums[i];
        }
        return ans ^ nums.length;
    }
}
