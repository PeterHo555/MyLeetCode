import java.util.HashSet;
import java.util.Set;

public class test141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            //遍历每个节点，若此节点之前遍历过，则是环形链表
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
