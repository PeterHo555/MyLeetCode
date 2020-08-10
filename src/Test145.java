import java.util.*;

public class Test145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left); //先左后右，保证右子树先遍历
            stack.push(node.right);
        }
        //从根右左转成左右根
        Collections.reverse(ret);
        return ret;
    }
}
