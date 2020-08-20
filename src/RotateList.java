import common.ListNode;

public class RotateList {

    // Given a linked list, rotate the list to the right by k places, where k is non-negative.
    private static ListNode rotateRight(ListNode head, int k) {
        // empty
        if(head == null)
            return null;
        // no rotation
        if(k == 0)
            return head;

        // note that it is possible for k to be greater than list length
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        k = k % len;
        // no rotation if a multiple of the length
        if(k == 0)
            return head;

        // where the rotation portion begins
        ListNode rotateBegin = head;
        // curr will be k in front of rotate begin
        curr = head;
        int count = 0;
        while(count < k){
            count++;
            curr = curr.next;
        }

        while(curr.next != null){
            rotateBegin = rotateBegin.next;
            curr = curr.next;
        }
        // at this point, curr will be last node and thus rotated to connect to head
        // rotateBegin will be the new end of list
        // rotateBegin.next will be new start of list
        curr.next = head;
        ListNode out = rotateBegin.next;
        rotateBegin.next = null;

        return out;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode curr = rotateRight(l1, 2);
        // expected 5->6->1->2->3->4->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
