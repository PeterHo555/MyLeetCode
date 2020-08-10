import java.util.LinkedList;
import java.util.Queue;

public class Test513 {
    public int findBottomLeftValue(TreeNode root) {
        //层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //注意顺序不能错，先取节点，再按顺序将其右子节与左子节点点入队，
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);

        }
        return root.val;
    }
}
