public class Test404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        //判断此节点的左子节点是否是左叶子节点，如果是则将它的和累计起来
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
