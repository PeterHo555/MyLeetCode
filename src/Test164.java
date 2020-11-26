import java.util.Arrays;

public class Test164 {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            ans = Math.max(nums[i] - nums[i-1], ans);
        }
        return ans;
    }
}
