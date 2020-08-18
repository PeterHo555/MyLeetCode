public class Test109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //利用快慢指针法，找到链表的中点p
        while(q!=null && q.next!=null){
            System.out.println("q:"+q.val);
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        System.out.println(p.val);
        //将中点左边的链表分开
        pre.next = null;
        //递归求两边的子树
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}
