[toc]

# Leetcode练习之PeterHo的刷题记录

>本文从 Leetcode 中精选大概 200 左右的题目，去除了某些繁杂但是没有多少算法思想的题目，同时保留了面试中经常被问到的经典题目。

## 数据结构相关

### 链表

1.找出两个链表的交点 --160--Easy

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        //判断两个指针所指节点的值是否相同，若不相同则执行循环语句
        //总体思路是指针各自遍历一遍链表，遍历完成后，然后遍历另一条链表，当指针指向同一元素时，表明此处为相交节点
        //若无相交节点，则遍历完两条链表，pA与pB都为null，跳出循环
        while(pA != pB) {
            //若pA为空，则pA指向headB，否则指向下一点
            pA = pA == null ? headB : pA.next;
            //若pB为空，则pB指向headA，否则指向下一点
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
```



2.链表反转--206--Easy

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        //使用临时节点进行交换
        while (curNode !=null){
            ListNode tempNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tempNode;
        }
        return preNode;
    }
}
```



3.归并两个有序的链表--21--Easy

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        //递归法解
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```



4.从有序链表中删除重复节点--83--Easy

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null){
            if(curNode.val == curNode.next.val){
                curNode.next = curNode.next.next;
                continue;
            }
            curNode = curNode.next;
        }
        return head;
    }
}
```



5.删除链表的倒数第 n 个节点--19--Medium

```java
//思路是先让一个指针先跑n步
public class Test19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < n; i++) {
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
```



6.交换链表中的相邻结点--24--Medium

```java
class Solution {
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
```



7.链表求和--445--Medium

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        //计算栈顶元素相加的结果，判断是否需要进位
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            //链表前插法保留计算的每一位的值
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }
    //用链表的元素构造栈
    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
```



8.回文链表--234--Easy

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 用快慢指针确定链表的中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
        cut(head, slow);                     // 切成两个链表
        return isEqual(head, reverse(slow));
    }
    //切断链表
    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }
    // 链表反转
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
    //判断链表是否相等
    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
```



9.分隔链表--725--Medium

```java

```



10.链表元素按奇偶聚集--328--Medium

```java

```



---

### 树

#### 递归

1. 树的高度
2. 平衡树
3. 两节点的最长路径
4. 翻转树
5. 归并两棵树
6. 判断路径和是否等于一个数
7. 统计路径和等于一个数的路径数量
8. 子树
9. 树的对称
10. 最小路径
11. 统计左叶子节点的和
12. 相同节点值的最大路径长度
13. 间隔遍历
14. 找出二叉树中第二小的节点

#### 层次遍历

1. 一棵树每层节点的平均数
2. 得到左下角的节点

#### 前中后序遍历

1. 非递归实现二叉树的前序遍历
2. 非递归实现二叉树的后序遍历
3. 非递归实现二叉树的中序遍历

#### BST

1. 修剪二叉查找树
2. 寻找二叉查找树的第 k 个元素
3. 把二叉查找树每个节点的值都加上比它大的节点的值
4. 二叉查找树的最近公共祖先
5. 二叉树的最近公共祖先
6. 从有序数组中构造二叉查找树
7. 根据有序链表构造平衡的二叉查找树
8. 在二叉查找树中寻找两个节点，使它们的和为一个给定值
9. 在二叉查找树中查找两个节点之差的最小绝对值
10. 寻找二叉查找树中出现次数最多的值

#### Trie

1. 实现一个 Trie
2. 实现一个 Trie，用来求前缀和

---

### 栈和队列

1. 用栈实现队列（232. Implement Queue using Stacks (Easy)）

   

2. 用队列实现栈（225. Implement Stack using Queues (Easy)）

   

3. 最小值栈（155. Min Stack (Easy)）

   

4. 用栈实现括号匹配（20. Valid Parentheses (Easy)）

   

5. 数组中元素与下一个比它大的元素之间的距离（739. Daily Temperatures (Medium)）

   

6. 循环数组中比当前元素大的下一个元素（503. Daily Temperatures (Medium)）

   

---

### 哈希表



---

### 字符串



---

### 数据与矩阵



---

### 图



---

### 位运算



----

## 算法思想

### 双指针



---

### 排序



---

### 贪心思想



---

### 二分查找



---

### 分治



---

### 搜索



---

### 动态规划



---

### 数学



---

