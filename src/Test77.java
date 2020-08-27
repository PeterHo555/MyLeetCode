import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test77 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private int k, n;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backtrack(temp, 0);
        return ans;
    }

    private void backtrack(List<Integer> tmp, int x) {
        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));// 重新构造一个 List
            return;
        }
        for (int i = x + 1; i <= n; i++) {
            tmp.add(i); // 添加元素
            backtrack(tmp, i); // 起始元素往下，并对起始元素后对元素回溯
            tmp.remove(tmp.size() - 1); //删除元素
        }
    }
}
