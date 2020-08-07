[toc]

# Leetcode练习之PeterHo的刷题记录

>本文从 Leetcode 中精选大概 200 左右的题目，去除了某些繁杂但是没有多少算法思想的题目，同时保留了面试中经常被问到的经典题目。

## 数据结构相关

### 链表

1. 找出两个链表的交点 --160--Easy

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

   

2. 链表反转--206--Easy

   ```java
   class Solution {
       public ListNode reverseList(ListNode head) {
           ListNode newHead = null;
         	//使用临时节点进行交换，实际上就是改变每个节点指的方向，并将原末尾节点置为头节点
           while (head != null) {
               ListNode nextNode = head.next;
               head.next = newHead;
               newHead = head;
               head = nextNode;
           }
           return newHead;
       }
   }
   ```

   

3. 归并两个有序的链表--21--Easy

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

   

4. 从有序链表中删除重复节点--83--Easy

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



5. 删除链表的倒数第 n 个节点--19--Medium

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



6. 交换链表中的相邻结点--24--Medium

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

   



7. 链表求和--445--Medium

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

   

8. 回文链表--234--Easy

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

   

9. 分隔链表--725--Medium

   ```java
   class Solution {
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
   ```

   

10. 链表元素按奇偶聚集--328--Medium

    ```java
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            //思路简单，将奇数节点与偶数节点分别生成一条链表，最后再相连
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                odd = odd.next;
                even.next = even.next.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
    ```

    

---

### 树

#### 递归

1. 树的高度--104--Easy

   ```java
   
   ```

   

2. 平衡树--110--Easy

   ```java
   
   ```

   

3. 两节点的最长路径--543--Easy

   ```java
   
   ```

   

4. 翻转树--226--Easy

   ```java
   
   ```

   

5. 归并两棵树--617--Easy

   ```java
   
   ```

   

6. 判断路径和是否等于一个数--112--Easy

   ```java
   
   ```

   

7. 统计路径和等于一个数的路径数量--437--Easy

   ```java
   
   ```

   

8. 子树--572--Easy

   ```java
   
   ```

   

9. 树的对称--101--Easy

   ```java
   
   ```

   

10. 最小路径--111--Easy

    ```java
    
    ```

    

11. 统计左叶子节点的和--404--Easy

    ```java
    
    ```

    

12. 相同节点值的最大路径长度--678--Easy

    ```java
    
    ```

    

13. 间隔遍历--337--Medium

    ```java
    
    ```

    

14. 找出二叉树中第二小的节点--671--Easy

    ```java
    
    ```

    

#### 层次遍历

1. 一棵树每层节点的平均数--637--Easy

   ```java
   
   ```

   

2. 得到左下角的节点--513--Easy

  ```java
  
  ```

  

#### 前中后序遍历

1. 非递归实现二叉树的前序遍历--144--Medium

   ```java
   
   ```

   

2. 非递归实现二叉树的后序遍历--145--Medium

   ```java
   
   ```

   

3. 非递归实现二叉树的中序遍历--94--Medium

  ```java
  
  ```

  

#### BST

1. 修剪二叉查找树--669--Easy

   ```java
   
   ```

   

2. 寻找二叉查找树的第 k 个元素--230--Easy

   ```java
   
   ```

   

3. 把二叉查找树每个节点的值都加上比它大的节点的值--538--Easy

   ```java
   
   ```

   

4. 二叉查找树的最近公共祖先--235--Easy

   ```java
   
   ```

   

5. 二叉树的最近公共祖先--236--Medium

   ```java
   
   ```

   

6. 从有序数组中构造二叉查找树--108--Easy

   ```java
   
   ```

   

7. 根据有序链表构造平衡的二叉查找树--109--Medium

   ```java
   
   ```

   

8. 在二叉查找树中寻找两个节点，使它们的和为一个给定值--653--Easy

   ```java
   
   ```

   

9. 在二叉查找树中查找两个节点之差的最小绝对值--530--Easy

   ```java
   
   ```

   

10. 寻找二叉查找树中出现次数最多的值--501--Easy

    ```java
    
    ```

    

#### Trie

1. 实现一个 Trie--208--Medium

   ```java
   
   ```

   

2. 实现一个 Trie，用来求前缀和--677--Medium

   ```java
   
   ```

   

---

### 栈和队列

1. 用栈实现队列--232--Easy

   ```java
   class MyQueue {
   
       private Stack<Integer> a;// 输入栈
       private Stack<Integer> b;// 输出栈
   
       public MyQueue() {
           a = new Stack<>();
           b = new Stack<>();
       }
   
       public void push(int x) {
           a.push(x);
       }
   
       public int pop() {
           // 如果b栈为空，则将a栈全部弹出并压入b栈中，然后b.pop()
           if(b.isEmpty()){
               while(!a.isEmpty()){
                   b.push(a.pop());
               }
           }
           return b.pop();
       }
   
       public int peek() {
           if(b.isEmpty()){
               while(!a.isEmpty()){
                   b.push(a.pop());
               }
           }
           return b.peek();
       }
   
       public boolean empty() {
           return a.isEmpty() && b.isEmpty();
       }
   }
   ```

   

2. 用队列实现栈--225--Easy

   ```java
   class MyStack {
   
       private Queue<Integer> a;//输入队列
       private Queue<Integer> b;//输出队列
   
       public MyStack() {
           a = new LinkedList<>();
           b = new LinkedList<>();
       }
   
       public void push(int x) {
           a.offer(x);
           // 将b队列中元素全部转给a队列
           while(!b.isEmpty())
               a.offer(b.poll());
           // 交换a和b,使得a队列没有在push()的时候始终为空队列
           Queue temp = a;
           a = b;
           b = temp;
       }
   
       public int pop() {
           return b.poll();
       }
   
       public int top() {
           return b.peek();
       }
   
       public boolean empty() {
           return b.isEmpty();
       }
   }
   ```

   

3. 最小值栈--155--Easy

   ```java
   // 链表解决
   class MinStack {
   
       private Node head;
       
       public void push(int x) {
           if(head == null) 
               head = new Node(x, x);
           else 
               head = new Node(x, Math.min(x, head.min), head);
       }
   
       public void pop() {
           head = head.next;
       }
   
       public int top() {
           return head.val;
       }
   
       public int getMin() {
           return head.min;
       }
       //定义私有节点类
       private class Node {
           int val;
           int min;
           Node next;
           
           private Node(int val, int min) {
               this(val, min, null);
           }
           
           private Node(int val, int min, Node next) {
               this.val = val;
               this.min = min;
               this.next = next;
           }
       }
   }
   
   //用栈解决
   class MinStack {
   
       private Stack<Integer> dataStack;
       private Stack<Integer> minStack;
       private int min;
   
       public MinStack() {
           dataStack = new Stack<>();
           minStack = new Stack<>();
           min = Integer.MAX_VALUE;
       }
     
   
       public void push(int x) {//最主要注意push进来的时候更新min的值
           dataStack.add(x);
           min = Math.min(min, x);
           minStack.add(min);
       }
   
       public void pop() {
           dataStack.pop();
           minStack.pop();
           min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
       }
   
       public int top() {
           return dataStack.peek();
       }
   
       public int getMin() {
           return minStack.peek();
       }
   }
   ```

   

4. 用栈实现括号匹配--20--Easy

   ```java
   class Solution {
       public boolean isValid(String s) {
           if (s.isEmpty()){
               return true;
           }
           Stack<Character> stack = new Stack<Character>();
           for (Character c : s.toCharArray()) {
               //当字符分别为({[，向栈中存入)}],如果字符串括号字符匹配，则栈顶字符会与其一致
               if(c=='(')
                   stack.push(')');
               else if(c=='{')
                   stack.push('}');
               else if(c=='[')
                   stack.push(']');
               else if(stack.empty()||c!=stack.pop())
                   return false;
           }
           return stack.empty();
       }
   }
   ```

   

5. 数组中元素与下一个比它大的元素之间的距离--739--Medium

   ```java
   //暴力，用时击败19%
   class Solution {
       public int[] dailyTemperatures(int[] T) {
           int len = T.length;
           int[] ans = new int[len];
           for (int i = 0; i < len; i++) {
               for (int j = i; j < len; j++) {
                   if (T[j] > T[i]) {
                       ans[i] = j - i;
                       break;
                   }
               }
           }
           return ans;
       }
   }
   //结合栈，用时击败69%,Java中new一个数组，其中元素的默认值为0
   class Solution {
       public int[] dailyTemperatures(int[] T) {
           int n = T.length;
           int[] dist = new int[n];
           Stack<Integer> indexs = new Stack<>();
           for (int curIndex = 0; curIndex < n; curIndex++) {
               //下标栈不为空，且当前温度大于上一次下标的温度
               while (!indexs.isEmpty() && T[curIndex] > T[indexs.peek()]) {
                   int preIndex = indexs.pop();
                   dist[preIndex] = curIndex - preIndex;
               }
               indexs.add(curIndex);
           }
           return dist;
       }
   }
   ```

   

6. 循环数组中比当前元素大的下一个元素--503--Medium

   ```java
   class Solution {
       //思路：
       //1.将数组中所有元素全部置为-1
       //2.遍历两次，相当于循环遍历
       //3.第一遍遍历，入栈索引i
       //4.只要后面元素比栈顶索引对应的元素大，索引出栈，ans[pre.pop()]的数值
       //5.最后栈里面剩余的索引对应的数组值，都为默认的-1（因为后面未找到比它大的值）
       public int[] nextGreaterElements(int[] nums) {
           int n = nums.length;
           int[] ans = new int[n];
           Arrays.fill(ans, -1);
           Stack<Integer> pre = new Stack<>();
           for (int i = 0; i < n * 2; i++) {
               int num = nums[i % n];
               while (!pre.isEmpty() && nums[pre.peek()] < num) {
                   ans[pre.pop()] = num;
               }
               if (i < n){
                   pre.push(i);
               }
           }
           return ans;
       }
   }
   ```

   

---

### 哈希表

1. 数组中两个数的和为给定值--1--Easy

   ```java
   
   ```

   

2. 判断数组是否含有重复元素--217--Easy

   ```java
   
   ```

   

3. 最长和谐序列--594--Easy

   ```java
   
   ```

   

4. 最长连续序列--128--Hard

   ```java
   
   ```

   

---

### 字符串

1. 字符串循环移位包含--编程之美3.1

   ```java
   
   ```

   

2. 字符串循环移位--编程之美2.17

   ```java
   
   ```

   

3. 字符串中单词的翻转--程序员代码面试指南

   ```java
   
   ```

   

4. 两个字符串包含的字符是否完全相同--242--Easy

   ```java
   
   ```

   

5. 计算一组字符集合可以组成的回文字符串的最大长度--409--Easy

   ```java
   
   ```

   

6. 字符串同构--205--Easy

   ```java
   
   ```

   

7. 回文子字符串个数--647--Medium

   ```java
   
   ```

   

8. 判断一个整数是否是回文数--9--Easy

   ```java
   
   ```

   

9. 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数--696--Easy

   ```java
   
   ```

   

---

### 数据与矩阵

1. 把数组中的 0 移到末尾--283--Easy

   ```java
   
   ```

   

2. 改变矩阵维度--566--Easy

   ```java
   
   ```

   

3. 找出数组中最长的连续 1--485--Easy

   ```java
   
   ```

   

4. 有序矩阵查找--240--Medium

   ```java
   
   ```

   

5. 有序矩阵的 Kth Element--378--Medium

   ```java
   
   ```

   

6.  一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数--645--Easy

   ```java
   
   ```

   

7. 找出数组中重复的数，数组值在 [1, n] 之间--287--Medium

   ```java
   
   ```

   

8. 数组相邻差值的个数--667--Medium

   ```java
   
   ```

   

9. 数组的度--697--Easy

   ```java
   
   ```

   

10. 对角元素相等的矩阵--766--Easy

    ```java
    
    ```

    

11. 嵌套数组--565--Medium

    ```java
    
    ```

    

12. 分隔数组--769--Medium

    ```java
    
    ```

    

---

### 图

#### 二分图

1. 判断是否为二分图--785--Medium

   ```java
   
   ```

   

#### 拓扑排序

1. 课程安排的合法性--207--Medium

  ```java
  
  ```

  

2. 课程安排的顺序--210--Medium

  ```java
  
  ```

  

#### 并查集

1. 冗余连接--684--Medium

   ```java
   
   ```

   



---

### 位运算

0. 原理

   **基本原理** 

   0s 表示一串 0，1s 表示一串 1。

   ```java
   x ^ 0s = x      x & 0s = 0      x | 0s = x
   x ^ 1s = ~x     x & 1s = x      x | 1s = 1s
   x ^ x = 0       x & x = x       x | x = x
   ```

   利用 x ^ 1s = \~x 的特点，可以将一个数的位级表示翻转；利用 x ^ x = 0 的特点，可以将三个数中重复的两个数去除，只留下另一个数。

   ```
   1^1^2 = 2
   ```

   利用 x & 0s = 0 和 x & 1s = x 的特点，可以实现掩码操作。一个数 num 与 mask：00111100 进行位与操作，只保留 num 中与 mask 的 1 部分相对应的位。

   ```java
   01011011 &
   00111100
   --------
   00011000
   ```

   利用 x | 0s = x 和 x | 1s = 1s 的特点，可以实现设值操作。一个数 num 与 mask：00111100 进行位或操作，将 num 中与 mask 的 1 部分相对应的位都设置为 1。

   ```java
   01011011 |
   00111100
   --------
   01111111
   ```

   **位与运算技巧** 

   n&(n-1) 去除 n 的位级表示中最低的那一位 1。例如对于二进制表示 01011011，减去 1 得到 01011010，这两个数相与得到 01011010。

   ```java
   01011011 &
   01011010
   --------
   01011010
   ```

   n&(-n) 得到 n 的位级表示中最低的那一位 1。-n 得到 n 的反码加 1，也就是 -n=\~n+1。例如对于二进制表示 10110100，-n 得到 01001100，相与得到 00000100。

   ```java
   10110100 &
   01001100
   --------
   00000100
   ```

   n-(n&(-n)) 则可以去除 n 的位级表示中最低的那一位 1，和 n&(n-1) 效果一样。

   **移位运算** 

   \>\> n 为算术右移，相当于除以 2n，例如 -7 \>\> 2 = -2。

   ```java
   11111111111111111111111111111001  >> 2
   --------
   11111111111111111111111111111110
   ```

   \>\>\> n 为无符号右移，左边会补上 0。例如 -7 \>\>\> 2 = 1073741822。

   ```java
   11111111111111111111111111111001  >>> 2
   --------
   00111111111111111111111111111111
   ```

   << n 为算术左移，相当于乘以 2n。-7 << 2 = -28。

   ```java
   11111111111111111111111111111001  << 2
   --------
   11111111111111111111111111100100
   ```

   **mask 计算** 

   要获取 111111111，将 0 取反即可，\~0。

   要得到只有第 i 位为 1 的 mask，将 1 向左移动 i-1 位即可，1<<(i-1) 。例如 1<<4 得到只有第 5 位为 1 的 mask ：00010000。

   要得到 1 到 i 位为 1 的 mask，(1<<i)-1 即可，例如将 (1<<4)-1 = 00010000-1 = 00001111。

   要得到 1 到 i 位为 0 的 mask，只需将 1 到 i 位为 1 的 mask 取反，即 \~((1<<i)-1)。

   **Java 中的位操作**  

   ```java
   static int Integer.bitCount();           // 统计 1 的数量
   static int Integer.highestOneBit();      // 获得最高位
   static String toBinaryString(int i);     // 转换为二进制表示的字符串
   ```

   

1. 统计两个数的二进制表示有多少位不同--461--Easy

   ```java
   
   ```

   

2. 数组中唯一一个不重复的元素--136--Easy

   ```java
   
   ```

   

3. 找出数组中缺失的那个数--268--Easy

   ```java
   
   ```

   

4. 数组中不重复的两个元素--260--Easy

   ```java
   
   ```

   

5. 翻转一个数的比特位--190--Easy

   ```java
   
   ```

   

6. 不用额外变量交换两个整数--程序员面试指南--P317

   ```java
   
   ```

   

7. 判断一个数是不是 2 的 n 次方--231--Easy

   ```java
   
   ```

   

8. 判断一个数是不是 4 的 n 次方--342--Easy

   ```java
   
   ```

   

9. 判断一个数的位级表示是否不会出现连续的 0 和 1--693--Easy

   ```java
   
   ```

   

10. 求一个数的补码--476--Easy

    ```java
    
    ```

    

11. 实现整数的加法--461--Easy

    ```java
    
    ```

    

12. 字符串数组最大乘积--371--Easy

    ```java
    
    ```

    

13. 统计从 0 \~ n 每个数的二进制表示中 1 的个数--318--Medium

    ```java
    
    ```

    

---

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

