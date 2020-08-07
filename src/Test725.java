public class Test725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        //计算链表长度
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int mod = n % k;
        int size = n / k;
        ListNode[] ans = new ListNode[k];//默认赋值为null
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ans[i] = cur;
            //计算每一部分的链表的长度，前mod份链表长度加1
            int curSize = size + (mod-- > 0 ? 1 : 0);
            //按照计算出的curSize分割链表
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            //开辟下一次分割链表的链表头，并将本次链表末尾置为null
            ListNode nextHead = cur.next;
            cur.next = null;
            cur = nextHead;
        }
        return ans;
    }
}
