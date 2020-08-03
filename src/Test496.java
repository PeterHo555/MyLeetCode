import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans =new int[nums1.length];
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        //将nums2数组元素入栈
        for (int i = 0; i < nums2.length; i++) {
            stack1.push(nums2[i]);
        }
        //对nums1的每个元素与stack1的元素比较，若不相等，将stack1的元素入栈到stack2中
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            //ans[i]初始化为-1，再找到相等的值前，不断更新比nums[i]大的值
            while (stack1.peek() != nums1[i]){
                if (stack1.peek() > nums1[i])
                    ans[i] = stack1.peek();
                stack2.push(stack1.pop());
            }
            //重新入栈
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        return ans;
    }
}
