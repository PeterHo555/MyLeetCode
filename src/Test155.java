import java.util.Stack;

public class Test155 {
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


//class MinStack {
//
//    private Stack<Integer> dataStack;
//    private Stack<Integer> minStack;
//    private int min;
//
//    public MinStack() {
//        dataStack = new Stack<>();
//        minStack = new Stack<>();
//        min = Integer.MAX_VALUE;
//    }
//
//    public void push(int x) {//最主要注意push进来的时候更新min的值
//        dataStack.add(x);
//        min = Math.min(min, x);
//        minStack.add(min);
//    }
//
//    public void pop() {
//        dataStack.pop();
//        minStack.pop();
//        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
//    }
//
//    public int top() {
//        return dataStack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}
