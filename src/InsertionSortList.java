import common.ListNode;

public class InsertionSortList {
    private static ListNode insertionSortList(ListNode head) {
        // empty
        if(head == null)
            return null;
        // single node
        if(head.next == null)
            return head;

        // virtual first node for sorted output
        ListNode out = new ListNode(Integer.MIN_VALUE);

        while(head != null){
            ListNode next = head.next;

            // find where in out to insert
            ListNode prev = out;
            ListNode curr = out.next;
            while(curr != null && curr.val < head.val){
                prev = curr;
                curr = curr.next;
            }
            // insert between prev and curr
            prev.next = head;
            head.next = curr;

            head = next;
        }

        return out.next;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode curr = insertionSortList(l1);
        // expected -1->0->3->4->5->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
