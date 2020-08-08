import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }else {
                ans = nums[i];
            }
        }
        return ans;


//        //双指针解法，类似于有环链表中找出环的入口：
//        int slow = nums[0], fast = nums[nums[0]];
//        while (slow != fast) {
//            System.out.println("nums[slow]:"+nums[slow]);
//            System.out.println("nums[nums[fast]]:"+nums[nums[fast]]);
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        }
//        fast = 0;
//        while (slow != fast) {
//
//            slow = nums[slow];
//            fast = nums[fast];
//            System.out.println(slow);
//            System.out.println(fast);
//        }
//        System.out.println("ans:"+slow);
//        return slow;
    }
}
