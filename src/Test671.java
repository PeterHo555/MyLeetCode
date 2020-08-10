public class Test671 {
    public int findSecondMinimumValue(TreeNode root) {
        //1.没有必要记录最小的值，因为最小的一定是根结点。
        //2.递归找到比根结点大的值时可以立即返回，不用再遍历当前节点下面的子节点，因为子节点的值不可能比它小。
        if (root == null) return -1;
        if (root.left == null && root.right == null)
            return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val)
            leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val)
            rightVal = findSecondMinimumValue(root.right);
        if (leftVal != -1 && rightVal != -1)
            return Math.min(leftVal, rightVal);
        if (leftVal != -1)
            return leftVal;
        return rightVal;
    }
}
