import java.util.Arrays;

public class Test153 {
    public int findMin(int[] nums) {
//        Arrays.sort(nums);
//        return nums[0];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            //由于元素是连续递增的，不重复且只有一处断点，用此条件可判断
            if (nums[m] <= nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
