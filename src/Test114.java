public class Test114 {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        // 将左子树展开为单链表
        flatten(root.left);
        // 将右子树展开为单链表
        flatten(root.right);
        // 暂存右子树
        TreeNode temp = root.right;
        // 左子树接到根的右侧
        root.right = root.left;
        // 左子树置空
        root.left = null;
        // 再接上右子树
        while(root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
}
