public class OddEvenLinkedList {
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

    // Given a singly linked list, group all odd nodes together followed by the even nodes
    // The first node is considered odd, the second node even and so on
    private static ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;

        // heads are virtual nodes to start the lists
        // currs are the current location in that list
        ListNode oddHead = new ListNode(0);
        ListNode oddCurr = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenCurr = evenHead;

        // track odd/even index
        int index = 1;
        while(head != null){
            // odd
            if(index % 2 != 0){
                oddCurr.next = head;
                oddCurr = oddCurr.next;
            }
            // even
            else{
                evenCurr.next = head;
                evenCurr = evenCurr.next;
            }
            // advance head pointer
            head = head.next;
            index++;
        }

        // connect odd to even
        oddCurr.next = evenHead.next;
        // end the list
        evenCurr.next = null;

        return oddHead.next;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode curr = oddEvenList(l1);
        // expected 2->3->6->7->1->5->4->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
