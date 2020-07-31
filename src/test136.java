public class test136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        //对全部蒜素进行异或计算，异或满足交换律，得出的答案为单个元素
        for(int num: nums) {
            ans ^= num;
        }
        return ans;
    }
}
