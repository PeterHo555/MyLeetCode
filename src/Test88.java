import java.util.Arrays;

public class Test88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先合并再排序
        int len1 =nums1.length;
        int k = 0;
        for (int i = m; i < len1; i++) {
           nums1[i] = nums2[k++];
        }
        Arrays.sort(nums1);
    }
}
