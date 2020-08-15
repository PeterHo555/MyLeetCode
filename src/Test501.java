import java.util.ArrayList;
import java.util.List;

public class Test501 {
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        //引用maxCntNums
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        //转成答案形式
        for (int i = 0; i < maxCntNums.size(); i++)
            ret[i] = maxCntNums.get(i);
        return ret;
    }
    //递归中序遍历，左根右，得到非递减序列
    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) // 当前值与上一个结点值相同，当前值的出现次数增加。
                curCnt++;
            else // 当前值与上一个结点值不同，重置计数
                curCnt = 1;
        }
        if (curCnt > maxCnt) {// 出现次数更多，清空之前的出现少的数，更新最大出现次数
            maxCnt = curCnt;
            nums.clear();//清空
            nums.add(node.val);
        } else if (curCnt == maxCnt) {// 不止一个众数
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }
//    private List<Integer> items;
//    private int maxCount;
//    private int curCount;
//    private TreeNode pre;
//
//    public int[] findMode(TreeNode root) {
//        if (root == null)
//            return new int[0];
//        items = new ArrayList<>();
//        // 这里设置为1是因为 在递归中 BST中最左边的结点被跳过了，作为初状态 该结点值出现一次，记录的出现最多次数一开始也为1
//        maxCount = 1;
//        curCount = 1;
//        midTraversal(root);
//        // 最右端结点的处理，从递归中看，最后一个结点与前一个结点相等只更新了curCount的值；不相等则只考虑到倒数第二个结点。
//        if(curCount > maxCount)
//            return new int[]{pre.val};
//        if(curCount == maxCount)
//            items.add(pre.val);
//        int[] res = new int[items.size()];
//        for (int i = 0; i < res.length; i++)
//            res[i] = items.get(i);
//        return res;
//    }
//    //中序遍历，左根右，获得一个非递减序列
//    private void midTraversal(TreeNode x) {
//        if (x == null) return;
//        midTraversal(x.left);
//        if(pre != null){
//            if(x.val != pre.val){ // 说明上一个值的结点数量已经统计完成 要看出现次数的情况
//                if(curCount > maxCount){ // 出现次数更多，清空之前的出现少的数，更新最大出现次数
//                    maxCount = curCount;
//                    items.clear();
//                    items.add(pre.val);
//                }
//                else if(curCount == maxCount){ // 不止一个众数
//                    items.add(pre.val);
//                }
//                curCount = 1; // 当前值与上一个结点值不同，重置计数
//            }
//            else curCount++; // 当前值与上一个结点值相同，当前值的出现次数增加。
//        }
//        pre = x;
//        midTraversal(x.right);
//    }
}
