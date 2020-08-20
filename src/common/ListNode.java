package common;
// definition for singly linked list
public class ListNode {
    // make sure variables have general access
    public int val;
    public ListNode next;
    // three constructors
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
