public class Test437 {
    //路径不一定以 root 开头，也不一定以 leaf 结尾，但是必须连续。
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int ans = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ans;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int ans = 0;
        if (root.val == sum) ans++;
        ans += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ans;
    }
}
