public class Test148 {
    public ListNode sortList(ListNode head) {
        // 插入排序
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;
        while(head != null && head.next != null) {
            // 找到未排序的点
            if(head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            // 每一次插入都从头开始遍历
            pre = dummy;
            // 找到比未排序的点小的第一个点，设为pre
            while (pre.next.val < head.next.val)
                pre = pre.next;
            ListNode curr = head.next; // 这里开始交换插入
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}
