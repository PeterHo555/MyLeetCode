import java.util.HashSet;
import java.util.Set;

public class Test217 {
    public boolean containsDuplicate(int[] nums) {
        //HashSet自带去重，所以HashSet的size小于数组的length的话就存在重复元素
        Set<Integer> res = new HashSet<>();
        for(int i:nums)
            res.add(i);
        return res.size()<nums.length;
    }
}
