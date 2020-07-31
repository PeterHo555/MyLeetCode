public class Test237 {
    public void deleteNode(ListNode node) {
        // 因为无法访问前一个结点，所以可以把要删除的结点的后一个结点的值前移
        node.val = node.next.val;
        // 然后删除掉后一个结点
        node.next = node.next.next;
    }
}
