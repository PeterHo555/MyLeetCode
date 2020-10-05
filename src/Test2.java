public class Test2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 计算后节点前插
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        long x1 = 0, x2 = 0;
        int i = 0, j = 0;
        long ans = 0;
        while (l1 != null) {
            x1 += l1.val * (int) Math.pow(10, i);
            l1 = l1.next;
            i++;
        }
        while (l2 != null) {
            x2 += l2.val * (int) Math.pow(10, j);
            l2 = l2.next;
            j++;
        }
        ans = x1 + x2;
        String stringAns = String.valueOf(ans);
        System.out.println(stringAns.length());
        for (int k = 0; k < stringAns.length(); k++) {
            ListNode sumNode = new ListNode((int) ans % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            ans = ans / 10;
        }

        return root;


//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
    }


}
