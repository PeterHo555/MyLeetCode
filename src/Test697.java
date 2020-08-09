import java.util.HashMap;
import java.util.Map;

public class Test697 {
    public int findShortestSubArray(int[] nums) {
        //题目意思是在不改变原数组顺序的情况下求出一个度与原数组一样的子数组
        //用来记录每个元素出现的次数
        Map<Integer, Integer> numsCnt = new HashMap<>();
        //记录每个元素的最后一次出现的下标
        Map<Integer, Integer> numsLastIndex = new HashMap<>();
        //记录每个元素的第一次出现的下标
        Map<Integer, Integer> numsFirstIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            numsLastIndex.put(num, i);
            if (!numsFirstIndex.containsKey(num)) {
                System.out.println("firstIndex:"+i);
                numsFirstIndex.put(num, i);
            }
        }
        //求出数组的度
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numsCnt.get(num));
        }
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numsCnt.get(num);
            //当此元素的出现次数等于数组的度时
            //利用此元素的首次出现下标与最后出现的下标计算最小子序列长度
            if (cnt != maxCnt)
                continue;
            System.out.println(ans);
            ans = Math.min(ans, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
        }
        System.out.println(ans);
        return ans;
    }
}
