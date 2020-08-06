public class Test328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        //思路简单，将奇数节点与偶数节点分别生成一条链表，最后再相连
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
