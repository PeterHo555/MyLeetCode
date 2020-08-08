public class Test645 {
    public int[] findErrorNums(int[] nums) {
        // 用一个布尔数组来记录元素是否出现，布尔数组默认值为false
        boolean[] showed = new boolean[nums.length + 1];
        int[] ans = new int[2];
        for (int num : nums) {
            // 出现了重复的数字 置为true
            if (showed[num])
                ans[0] = num;
            else
                showed[num] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            // 找到没有出现的那一位
            if (!showed[i])
                ans[1] = i;
        }
        return ans;
    }
}
