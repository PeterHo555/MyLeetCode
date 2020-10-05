import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test18 {
    /**
     * 1：暴力的四重改为1.2两重+一重双指针
     * 2：下标的遍历范围修改，因为要四数之和
     * 3：避免重复，利用 nums[i] == nums[i-1]
     * 4：提前开启下一次循环，排序之后是从小到大的，利用和最大数的加和仍然<target
     * 5：提前结束，排序之后遍历是从小到大的，利用四数之和>target
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if(nums == null || len < 4) return ans;

        for(int i = 0; i < len - 3; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target)break;
            if(nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target)continue;

            for(int j = i+1; j < len - 2; j++){
                if(j > i+1 && nums[j] == nums[j-1])continue;//注意这里的j>i+1
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target)break;
                if(nums[i] + nums[j] + nums[len-2] + nums[len-1] < target)continue;

                //剩下两层采用双指针降低时间复杂度
                int left = j+1, right = len-1;
                while(left < right){
                    int tempSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(tempSum == target){
                        //加入集合
                        ArrayList<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        //移动指针,去重
                        while(left < right && nums[left] == nums[left+1])left++;
                        left++;
                        while(left < right && nums[right] == nums[right-1])right--;
                        right--;
                    }else if(tempSum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
