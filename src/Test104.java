

public class Test104 {
    //递归法
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return  Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
