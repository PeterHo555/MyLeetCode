import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> listSet = new HashSet<>(); // 利用hashset去重
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(listSet, nums, new ArrayList<Integer>(), visited);
        for (List<Integer> tmp : listSet) {
            ans.add(tmp);
        }
        return ans;
    }

    private void backtrack(Set<List<Integer>> listSet, int[] nums, ArrayList<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            listSet.add(new ArrayList<>(tmp));// 重新构造一个 List
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true; //标记为已经访问
            tmp.add(nums[i]); // 添加元素
            backtrack(listSet, nums, tmp, visited); // 回溯
            visited[i] = false; //去除标记
            tmp.remove(tmp.size() - 1); //删除元素
        }
        //注意，遍历完当前nums后回溯到上一层的nums
        //如 1 2 3 到 1 3 2
    }
}
