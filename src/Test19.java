public class Test19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < n; i++) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
        if (node1 == null)
            return head.next;
        while (node1.next != null){
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
        return head;
    }
}
