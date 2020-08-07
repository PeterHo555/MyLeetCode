import sun.font.DelegatingShape;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test128 {
    public int longestConsecutive(int[] nums) {
        //思路是将所有元素用HashMap存储
        //以每一个元素为原点，向左右两边扩张。
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int right = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int cur = 1 + left + right;
                //判断当前元素的最大扩张是否最大
                if (cur > ans) {
                    ans = cur;
                }
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return ans;
    }
//    public int longestConsecutive(int[] nums) {
//        Map<Integer, Integer> countForNum = new HashMap<>();
//        for (int num : nums) {
//            countForNum.put(num, 1);
//        }
//        for (int num : nums) {
//            forward(countForNum, num);
//        }
//        return maxCount(countForNum);
//    }
//
//    private int forward(Map<Integer, Integer> countForNum, int num) {
//        if (!countForNum.containsKey(num)) {
//            return 0;
//        }
//        int cnt = countForNum.get(num);
//        if (cnt > 1) {
//            return cnt;
//        }
//        cnt = forward(countForNum, num + 1) + 1;
//        countForNum.put(num, cnt);
//        return cnt;
//    }
//
//    private int maxCount(Map<Integer, Integer> countForNum) {
//        int max = 0;
//        for (int num : countForNum.keySet()) {
//            max = Math.max(max, countForNum.get(num));
//        }
//        return max;
//    }
}
