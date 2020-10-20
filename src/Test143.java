import java.util.ArrayList;
import java.util.List;

public class Test143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //存到 list 中去
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //头尾指针依次取元素
        int l = 0, r = list.size() - 1;
        while (l < r) {
            list.get(l).next = list.get(r);
            l++;
            //偶数个节点的情况，会提前相遇
            if (l == r) {
                break;
            }
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;
    }
}
