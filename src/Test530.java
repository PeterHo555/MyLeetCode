import java.util.ArrayDeque;
import java.util.Queue;

public class Test530 {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    //中序遍历得到升序数列，每次计算两数之间最小值，取最小
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (preNode != null)
            minDiff = Math.min(minDiff, node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }

    // 这个是任意相邻两点的最小值，用的层次遍历
    public int getMinimumDifference2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                minDiff = Math.min(minDiff, Math.abs(node.val - node.left.val));
                queue.add(node.left);
            }
            if (node.right != null){
                minDiff = Math.min(minDiff, Math.abs(node.val - node.right.val));
                queue.add(node.right);
            }
        }
        return minDiff;
    }
}
