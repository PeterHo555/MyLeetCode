import java.util.ArrayList;
import java.util.List;

public class Test46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));// 重新构造一个 List
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true; //标记为已经访问
            tmp.add(nums[i]); // 添加元素
            backtrack(res, nums, tmp, visited); // 回溯
            visited[i] = false; //去除标记
            tmp.remove(tmp.size() - 1); //删除元素
        }
        //注意，遍历完当前nums后回溯到上一层的nums
        //如 1 2 3 到 1 3 2
    }
}
