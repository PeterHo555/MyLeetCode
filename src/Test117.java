public class Test117 {

//    public Node connect(Node root){
//        ArrayDeque<Node> queue = new ArrayDeque<>(20);
//        //首先将根节点加入栈中
//        queue.add(root);
//        //遍历二叉树
//        while (!queue.isEmpty()) {
//            Node tempNode = queue.poll();
//            if (queue.isEmpty()){
//                root.next = null;
//            }
//
//            if(tempNode.left != null){
//                queue.add(tempNode.left);
//            }
//            if(tempNode.right != null){
//                queue.add(tempNode.right);
//            }
//        }
//
//        return root;
//    }

    // 填充的是next指针，注意了
    public Node connect(Node root) {
        if(root==null) return root;
        // 左右子节点都为非空，另其左子节点的next节点等于右子节点
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        //左子节点为非空，右子节点为空
        if(root.left!=null && root.right==null){
            root.left.next = getNext(root.next);
        }
        //
        if(root.right!=null)
            root.right.next=getNext(root.next);
        // 先递归右
        connect(root.right);
        System.out.println(root.val);
        // 再递归左
        connect(root.left);
        return root;
    }

    //
    public Node getNext(Node root){
        if(root==null) return null;
        // 左不为空，返回左
        if(root.left!=null) return root.left;
        // 右不为空，返回右
        if(root.right!=null) return root.right;
        // next不为空，返回next
        if(root.next!=null) return getNext(root.next);
        return null;
    }
}
