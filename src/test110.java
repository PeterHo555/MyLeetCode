public class test110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root)>=0;
    }
    //递归法解决方案
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        //左子树与右子树差值大于1，则标记为不平衡（-1）
        if(l==-1 || r==-1 || Math.abs(l-r)>1)
            return -1;
        //平衡则标记为上一层的高度+1
        return Math.max(l,r) +1;
    }
}
