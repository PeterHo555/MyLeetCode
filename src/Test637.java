import java.util.*;

public class Test637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //当前层的节点个数
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                //取出节点
                TreeNode node = queue.poll();
                sum += node.val;
                //存入此节点的子节点用作下一层均值计算
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            //存入当前层的平均值
            ans.add(sum / cnt);
        }
        return ans;
    }
}
