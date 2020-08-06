public class Test24 {
    public ListNode swapPairs(ListNode head) {
        // node1与node2为需要交换的节点，pre与next节点为这两个节点的前置与后置节点。
        ListNode node1, node2, pre, next;
        // 构造一个前置节点
        ListNode node = new ListNode(-1);
        node.next = head;
        pre = node;
        while (pre.next != null && pre.next.next != null) {
            // 赋值node1，node2，next节点
            node1 = pre.next;
            node2 = pre.next.next;
            next = node2.next;
            // 交换节点
            node1.next = next;
            node2.next = node1;
            pre.next = node2;
            // 将前置节点替换为下一轮的前置节点
            pre = node1;
        }
        return node.next;
    }
}
