import java.util.ArrayList;
import java.util.List;

public class Test216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(k, n, 1, path, combinations);
        return combinations;
    }

    private void backtracking(int k, int n, int start, List<Integer> tempCombination, List<List<Integer>> combinations) {
        //k剩余量与n剩余量都为0，是一种答案，存入后回溯
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        //此时不是答案，不用存入，但需回溯
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempCombination.add(i); // 添加
            //对下一位进行组合
            backtracking(k - 1, n - i, i + 1, tempCombination, combinations);
            tempCombination.remove(tempCombination.size() - 1); // 删除
        }
    }
}
