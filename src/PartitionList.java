import common.ListNode;

public class PartitionList {
    // Given a linked list and a value x, partition it such that all nodes
    // less than x come before nodes greater than or equal to x.
    // You should preserve the original relative order of the nodes in each of the two partitions.
    private static ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        // the head pointers are the start of the partitions less than (lt) and greater than (gt)
        // the curr pointers are the current location in those linked lists
        ListNode ltHead = null;
        ListNode ltCurr = ltHead;
        ListNode gtHead = null;
        ListNode gtCurr = gtHead;

        ListNode curr = head;
        while(curr != null){
            int currVal = curr.val;
            if(currVal < x){
                if(ltHead == null){
                    ltHead = curr;
                    ltCurr = curr;
                }
                else{
                    ltCurr.next = curr;
                    ltCurr = curr;
                }
            }
            else{
                if(gtHead == null){
                    gtHead = curr;
                    gtCurr = curr;
                }
                else{
                    gtCurr.next = curr;
                    gtCurr = curr;
                }
            }
            curr = curr.next;
        }
        // rearrange the less than and greater than portions
        if(ltHead == null)
            return head;
        ltCurr.next = gtHead;
        // end the list
        if(gtCurr != null)
            gtCurr.next = null;
        return ltHead;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode curr = partition(l1, 3);
        // expected 1->2->2->4->3->5
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
