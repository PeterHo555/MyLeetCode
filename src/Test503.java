import java.util.Arrays;
import java.util.Stack;


public class Test503 {
    //思路：
    //1.将数组中所有元素全部置为-1
    //2.遍历两次，相当于循环遍历
    //3.第一遍遍历，入栈索引i
    //4.只要后面元素比栈顶索引对应的元素大，索引出栈，ans[pre.pop()]的数值
    //5.最后栈里面剩余的索引对应的数组值，都为默认的-1（因为后面未找到比它大的值）
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                ans[pre.pop()] = num;
            }
            if (i < n){
                pre.push(i);
            }
        }
        return ans;
    }
}
