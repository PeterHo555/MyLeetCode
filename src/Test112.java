public class Test112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        //是否为空树
        if (root == null) return false;
        //是否为叶子节点，若是，判断是否路径上的和值等于sum
        if (root.left == null && root.right == null) return sum == root.val;
        //递归法对左子树和右子树求解
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
