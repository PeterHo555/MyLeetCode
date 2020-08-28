import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] isVisited = new boolean[candidates.length];
        backtracking(new ArrayList<>(), ans, 0, target, candidates, isVisited);
        return ans;
    }

    private void backtracking(List<Integer> temp, List<List<Integer>> ans, int start, int target, int[] candidates, boolean[] isVisited) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 某个candidates未被标记，但是与之前的candidates值相等，进行下一次循环
            if (i != 0 && candidates[i] == candidates[i - 1] && !isVisited[i - 1])
                continue;
            if (candidates[i] <= target) {
                temp.add(candidates[i]); // 添加
                isVisited[i] = true; // 标记
                // target减去添加的数，注意此处i+1，因为candidate不可重复使用
                backtracking(temp, ans, i + 1, target - candidates[i], candidates, isVisited);
                temp.remove(temp.size() - 1); // 删除
                isVisited[i] = false; // 去除标记
            }
        }
    }
}
