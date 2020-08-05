public class MinStack {

    // node structure
    private static class Node{
        int val;
        Node next;
        // minimum value before this node was inserted
        int min;
        public Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    // instance variables for MinStack
    private int min;
    // singly linked list
    private Node first;

    public MinStack() {
        min = Integer.MAX_VALUE;
        first = null;
    }

    public void push(int x) {
        Node newNode = new Node(x, first, min);
        first = newNode;
        if(x < min)
            min = x;
    }

    public void pop() {
        this.min = first.min;
        first = first.next;
    }

    public int top() {
        return first.val;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
