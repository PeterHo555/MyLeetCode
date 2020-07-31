import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //利用队列解决层次遍历,LinkedList可以往队头添加元素
        LinkedList<List<Integer>> ansList = new LinkedList<>();
        if (root == null)
            return ansList;
        Queue<TreeNode> rowQueue = new LinkedList<>();
        rowQueue.add(root);
        while(!rowQueue.isEmpty()){
            List<Integer> rowList = new ArrayList<>();
            int count = rowQueue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = rowQueue.poll();
                rowList.add(node.val);
                if (node.left != null)
                    rowQueue.add(node.left);
                if (node.right != null)
                    rowQueue.add(node.right);
            }
            ansList.addFirst(rowList);
        }
        return ansList;
    }
}
