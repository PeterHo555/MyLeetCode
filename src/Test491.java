import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        //使用HashSet令结果去重
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, result);
        //转为题目所需的数据类型
        List<List<Integer>> realResult = new ArrayList<>(result);
        return realResult;
    }

    private void dfs(int[] nums, int start, List<Integer> path, Set<List<Integer>> result){
        if(path.size() >= 2){
            result.add(new ArrayList<>(path));
        }
        if(start == nums.length){
            return;
        }

        for(int i = start; i < nums.length; i++){
            //增加元素的条件
            if(path.size() == 0 ||nums[i] >= path.get(path.size() - 1)){
                path.add(nums[i]);
                dfs(nums, i + 1, path, result);
                //移除最后一位元素，然后起始位start+1
                path.remove(path.size() - 1);
            }
        }
    }
}
