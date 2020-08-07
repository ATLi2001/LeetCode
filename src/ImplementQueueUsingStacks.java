import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static class MyQueue{

        private Stack<Integer> stack;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            Stack<Integer> temp = new Stack<>();
            // push into correct order
            temp.push(x);
            while(!stack.isEmpty())
                temp.push(stack.pop());

            stack = temp;
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
