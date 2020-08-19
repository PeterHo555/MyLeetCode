import java.util.Arrays;

public class Test238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left = 1, right = 1;     //left：从左边累乘，right：从右边累乘
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for(int i = 0; i < n; ++i){
            //最终每个元素其左右乘积进行相乘得出结果
            ans[i] *= left;       //乘以其左边的乘积
            left *= nums[i];
            ans[n - 1 - i] *= right;  //乘以其右边的乘积
            right *= nums[n - 1 - i];
            for (int j = 0; j < n; j++) {
                System.out.print(ans[j]+" ");
            }
            System.out.println("");
        }
        return ans;
    }

}
