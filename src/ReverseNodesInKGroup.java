import common.ListNode;

public class ReverseNodesInKGroup {

    // Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    // k is a positive integer and is less than or equal to the length of the linked list.
    // If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    private static ListNode reverseKGroup(ListNode head, int k) {
        // empty
        if(head == null)
            return null;
        // no swapping
        if(k == 1)
            return head;

        // pointer to begin and end of swapping sections
        ListNode begin = head;
        ListNode end = head;
        // previous reverse end location
        ListNode prevBegin = null;

        // head is index 1
        int index = 1;

        while(end != null){
            ListNode endNext = end.next;

            // reverse from begin to end
            if(index % k == 0){
                ListNode prev = null;
                ListNode curr = begin;
                while(curr != endNext){
                    ListNode next = curr.next;
                    if(prev != null){
                        // reverse
                        curr.next = prev;
                    }
                    prev = curr;
                    curr = next;
                }
                // begin is now end
                begin.next = endNext;
                // previous k group's next pointer to current k group's start
                if(prevBegin != null){
                    prevBegin.next = end;
                }
                prevBegin = begin;
                begin = endNext;
            }
            // for first set need to reset head
            if(index == k){
                head = end;
            }

            index++;
            end = endNext;
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
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode curr = reverseKGroup(l1, 3);
        // expected 3->2->1->5->4->6->7->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
