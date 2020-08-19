public class SwapNodesInPairs {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Given a linked list, swap every two adjacent nodes and return its head.
    // You may not modify the values in the list's nodes, only nodes itself may be changed.
    private static ListNode swapPairs(ListNode head) {
        // empty
        if(head == null)
            return null;
        // single so nothing to swap
        if(head.next == null)
            return head;

        // at least one swap
        ListNode prev = head;
        ListNode curr = head.next;

        // head will be changed
        head = head.next;

        // is it time to swap?
        boolean swap = true;

        while(curr != null){
            // save the original next
            ListNode next = curr.next;
            // swap
            if(swap){
                prev.next = curr.next;
                curr.next = prev;
            }
            // prepare for next swap if there is room
            else{
                if(curr.next != null)
                    prev.next = curr.next;
                // only do this since no swap occurred
                // when swapped, prev essentially moved forward already
                prev = curr;
            }

            // advance pointers
            curr = next;
            // flip swap
            swap = !swap;
        }

        return head;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode curr = swapPairs(l1);
        // expected 2->1->4->3->5->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
