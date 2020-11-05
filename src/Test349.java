import java.util.HashSet;

public class Test349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //用两个hashSet将相同元素拿出
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int temp1: nums1) {
            hashSet1.add(temp1);
        }
        for (int temp2: nums2) {
            if (hashSet1.contains(temp2)) {
                hashSet2.add(temp2);
            }
        }
        //将hashSet转成数组形式
        int[] ans = new int[hashSet2.size()];
        int i = 0;

        for (int temp: hashSet2) {
            ans[i++]=temp;
        }
        return ans;
    }
}
