import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            //先将左子节点入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //存入节点的值，下一轮遍历右子节点
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
}
