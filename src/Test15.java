import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        //对原始数组排序
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            //因为已经排序，所以若当前元素大于0，与后面元素相加不可能等于0，故直接返回结果
            if(nums[i] > 0)
                return ansList;
            //跳过重复元素
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            //当前元素的左一位设左指针，数据最后一位设右指针
            int curr = nums[i];
            //双指针
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                //三数相加结果为0，保存至结果
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    ansList.add(list);
                    //跳过重复元素
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {//结果小于0，左指针往右移动，取更大的元素相加后再比较
                    ++L;
                } else {//结果大于0，右指针往左移动，取更小的元素相加后再比较
                    --R;
                }
            }
        }
        return ansList;
    }
}
