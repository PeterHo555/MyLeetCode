import java.util.HashSet;
import java.util.Set;

public class Test141 {
    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            //遍历每个节点，若此节点之前遍历过，则是环形链表
//            if (nodesSeen.contains(head)) {
//                return true;
//            } else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
        // 快慢指针。若有循环，指针必然相遇
        // 若无循环，指针必有指为null的情况，此时跳出循环，return false
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
            if(fast == slow) {
                return true;
            }
            slow = slow.next;
        }

        return false;

    }
}
