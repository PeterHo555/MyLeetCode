public class Test99 {
    TreeNode ex1 = null;
    TreeNode ex2 = null;
    public void recoverTree(TreeNode root) {
        inorder( root, null);
        if(ex1 != null&& ex2!=null){
            int temp = ex1.val;
            ex1.val = ex2.val;
            ex2.val = temp;
        }
    }
    TreeNode inorder(TreeNode root, TreeNode pre){
        if(root == null) return pre;
        pre = inorder(root.left,pre);
        if(pre != null && pre.val>root.val){
            // System.out.print(pre.val);
            if(ex1 == null)
                ex1 = pre;
            ex2 = root;
        }
        pre = inorder(root.right,root);
        return pre;
    }
}
