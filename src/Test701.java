public class Test701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 处理空根节点情况
        if(root == null){
            return new TreeNode(val);
        }
        // parent暂存最后一次比较的节点, 此时p为null
        TreeNode parent = root, p = root;
        while (p != null){
            parent = p;
            if (p.val < val)
                p = p.right;
            else
                p = p.left;
        }
        // 将加入的新值根据大小新增节点
        if (parent.val < val)
            parent.right = new TreeNode(val);
        else
            parent.left = new TreeNode(val);
        return root;
    }
}
