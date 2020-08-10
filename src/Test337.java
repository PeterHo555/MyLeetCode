import java.util.HashMap;
import java.util.Map;

public class Test337 {

    public int rob(TreeNode root) {
        //节点为空，返回0
        if (root == null) return 0;
        //实际上是求不同的两种层次遍历，奇数层与偶数层
        int val1 = root.val;
        if (root.left != null)
            val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }

    //深度优先算法
//    Map<TreeNode, Integer> f = new HashMap<>();
//    Map<TreeNode, Integer> g = new HashMap<>();
//
//    public int rob(TreeNode root) {
//        dfs(root);
//        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
//    }
//
//    public void dfs(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        dfs(node.left);
//        dfs(node.right);
//        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
//        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
//    }
}
