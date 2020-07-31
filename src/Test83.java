public class Test83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null){
            if(curNode.val == curNode.next.val){
                curNode.next = curNode.next.next;
                continue;
            }
            curNode = curNode.next;
        }
        return head;
    }
}
