import java.util.Arrays;

public class Test462 {
    public int minMoves2(int[] nums) {
        //转成中位数的步数最少，可用数学证明
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }
}
