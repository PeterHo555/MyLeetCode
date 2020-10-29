public class Test129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(0, root);
        return sum;
    }
    public void helper(int val, TreeNode node){
        if(node == null) return;
        int cur = val * 10 + node.val;
        if(node.left == null && node.right == null) sum += cur;
        helper(cur, node.left);
        helper(cur, node.right);
    }
}
