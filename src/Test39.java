import java.util.ArrayList;
import java.util.List;

public class Test39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(new ArrayList<>(), ans, 0, target, candidates);
        return ans;
    }

    private void backtracking(List<Integer> temp, List<List<Integer>> ans, int start, int target, int[] candidates) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]); // 添加
                // target减去添加的数，注意此处i不需+1，因为candidate可重复使用
                backtracking(temp, ans, i, target - candidates[i], candidates);
                temp.remove(temp.size() - 1); // 删除
            }
        }
    }
}
