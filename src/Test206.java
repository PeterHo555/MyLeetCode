public class Test206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null,curNode;
        curNode = head;
        //错的
//        while (curNode !=null){
//            ListNode tempNode = curNode;
//            curNode.next = preNode;
//            preNode = curNode;
//            curNode = tempNode.next;
//        }
        //对的
        while (curNode !=null){
            ListNode tempNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tempNode;
        }
        return preNode;
    }
}

