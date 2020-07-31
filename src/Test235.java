
public class Test235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当p和q节点等于root节点，直接返回root
        if (p.val==root.val || q.val==root.val){
            return root;
        }
        //递归求解
        if (p.val > root.val && q.val > root.val) {//p和q节点都大于root，则说明p和q为root的右子节点
            return lowestCommonAncestor(root.right,p,q);
        }else if (p.val < root.val && q.val < root.val) {//p和q节点都大于root，则说明p和q为root的右子节点
            return lowestCommonAncestor(root.left,p,q);
        }else{//其他情况均为root节点为最大父节点
            return root;
        }
    }
}
