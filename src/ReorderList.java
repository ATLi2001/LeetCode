import common.ListNode;

public class ReorderList {

    // Given a singly linked list L: L0, L1, ..., L_(n-1), Ln,
    // reorder it to: L0, Ln, L1, L_(n-1), L2, L_(n-2), ...
    // You may not modify the values in the list's nodes, only nodes itself may be changed.
    private static void reorderList(ListNode head) {
        // following cases don't need reorder
        // empty
        if(head == null)
            return;
        // length 1
        if(head.next == null)
            return;
        // length 2
        if(head.next.next == null)
            return;

        // count length
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        // find midway point
        // better way - use fast and slow pointers
        int mid = (len - 1) / 2;
        int count = 0;
        curr = head;
        while(count < mid){
            count++;
            curr = curr.next;
        }
        // curr is at last node of first half (won't be rearranged)
        // reverse the list after curr
        ListNode prev = curr;
        ListNode next = curr.next;
        curr.next = null;
        curr = next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // at this point, prev is at end of the list
        // start reordering
        curr = head;
        while(curr != prev && curr != prev.next){
            ListNode tailNext = prev.next;

            // insert prev after curr
            prev.next = curr.next;
            curr.next = prev;

            prev = tailNext;
            curr = curr.next.next;
        }

        // depending on odd/even length, need to end it differently
        if(curr == prev){
            curr.next = null;
        }
        if(curr == prev.next){
            curr.next = prev;
            prev.next = null;
        }

    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;

        reorderList(l1);
        ListNode curr = l1;
        // expected 1->5->2->4->3->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
