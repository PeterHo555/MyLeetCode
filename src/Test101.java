public class Test101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }
    public boolean compare(TreeNode node1, TreeNode node2){
        //左子节点与右子节点都为空，则树对称
        if (node1 == null && node2 == null) return true;
        //左子节点或右子节点其中之一为空，则树不对称；左自节点与右自节点值不同，则树不对称
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        //比较左自节点的左子树与右自节点的右子树；比较左自节点的右子树与右自节点的左子树
        return compare(node1.left, node2.right) && compare(node1.right, node2.left);
    }
}
