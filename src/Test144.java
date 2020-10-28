import java.util.*;

public class Test144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.right);  // 先右后左，保证左子树先遍历
            stack.push(node.left);
        }
        return ret;
        // 二刷
//        List<Integer> ans = new ArrayList<>();
//        if(root == null) return ans;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode temp = stack.pop();
//            ans.add(temp.val);
//            if(temp.right != null) stack.push(temp.right);
//            if(temp.left != null) stack.push(temp.left);
//        }
//        return ans;
    }


    // 官方递归写法
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        preorder(root, res);
//        return res;
//    }
//
//    public void preorder(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        res.add(root.val);
//        preorder(root.left, res);
//        preorder(root.right, res);
//    }

}
