import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test95 {
    public List<TreeNode> generateTrees(int n) {
        // 判断特殊情况
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateSubtrees(1, n);
    }
    // 分治的思想
    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null);
            return res;
        }
        // 枚举可行根节点
        for (int i = s; i <= e; ++i) {
            // 获得所有的可行左子树
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            // 获得所有的可行右子树
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
