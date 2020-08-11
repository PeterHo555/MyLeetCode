public class Test538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val = root.val + sum;
            sum = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
    }

}

