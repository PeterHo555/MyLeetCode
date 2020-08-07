import java.util.HashMap;
import java.util.Map;

public class Test594 {
    public int findLHS(int[] nums) {
        //和谐序列中最大数和最小数之差正好为 1，应该注意的是序列的元素不一定是数组的连续元素。
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            //getOrDefault意思就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            //此处存入的是每个元素出现的次数，注意map会更新
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            //当前元素是num，判断Map中是否存在num+1的元素，longset取当前longest与这两个元素和的最大值
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }

//先排序再双指针
//    public int findLHS(int[] nums) {
//        Arrays.sort(nums);
//        int count = 0,max = 0;
//        int i = 0,j = 1;
//        // 判断是为了最后一个if不出错
//        if(nums.length == 0) return 0;
//        //j永远会大于等于i
//        while(i<=j&&j<nums.length){
//            // 两个值相等或者相差1，j指针加1
//            if(nums[j] == nums[i]||nums[j]-nums[i]==1){
//                j++;
//
//            }else{
//                // 此处如果不加判断对1，1，3，3这种情况会计算错误
//                if(nums[j-1]-nums[i]==1) max = Math.max(max,j-i);
//                // 头指针加1
//                i++;
//            }
//        }
//        // 防止类似[1,1,2,2]这种数组，
//        if(nums[j-1]-nums[i]==1) max = Math.max(max,j-i);
//        return max;
//    }
}
