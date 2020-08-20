import common.ListNode;

public class RemoveNthNodeFromEndOfList {

    // do in one pass
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        // keep pointer prev n behind curr
        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while(count <= n && curr != null){
            count++;
            curr = curr.next;
        }
        // means remove head
        if(curr == null){
            return head.next;
        }
        // prev will be offset from curr such that when curr reaches null,
        // prev will be one behind the node to remove
        prev = head;
        while(curr != null){
            prev = prev.next;
            curr = curr.next;
        }

        // remove the node in front of prev
        prev.next = prev.next.next;

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
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode curr = removeNthFromEnd(l1, 6);
        // expected 1->2->3->4->6->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
