import java.util.*;

public class Test350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //用两个hashMap将相同元素拿出
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        //记录元素出现的频次
        for (int temp1: nums1) {
            Integer count = map1.get(temp1);
            if (count == null) {
                map1.put(temp1, 1);
            } else {
                map1.put(temp1, ++count);
            }
        }
        int j = 0;
        for (int num : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map1.get(num);
            if (count != null && count != 0) {
                list.add(num);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map1.put(num, --count);
            }
        }
        //将hashSet转成数组形式
        int[] ans = new int[list.size()];
        int k = 0;
        for (int temp: list) {
            ans[k++]=temp;
        }
        return ans;
    }
}
