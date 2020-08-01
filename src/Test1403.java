import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int ansSum = 0, otherSum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            otherSum += num;
        }
        for (int i = nums.length-1; i >= 0 ; i--) {
            ansSum += nums[i];
            ansList.add(nums[i]);
            otherSum -= nums[i];
            if (ansSum > otherSum)
                break;
        }
        return ansList;
    }
}
