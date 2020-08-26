import java.util.ArrayList;
import java.util.List;

public class Test257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<Integer> values = new ArrayList<>();
        backTracking(root, values, ans);
        return ans;
    }

    //回溯
    private void backTracking(TreeNode node, List<Integer> values, List<String> ans){
        if (node == null) // 节点为空则回溯
            return;
        values.add(node.val);// 添加此时节点值
        if (isLeft(node)){
            ans.add(buildPath(values)); // 添加已有值的生成路径
        } else {
            backTracking(node.left, values, ans); // 回溯左子树
            backTracking(node.right, values, ans); // 回溯右子树
        }
        values.remove(values.size() - 1); //删除此时节点值
    }

    //判断是否是叶子节点
    private boolean isLeft(TreeNode node){
        return node.left == null && node.right == null;
    }

    //构造答案所需的路径结构
    private String buildPath(List<Integer> values){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i));
            if (i != values.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
