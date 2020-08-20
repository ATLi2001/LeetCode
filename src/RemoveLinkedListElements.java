import common.ListNode;

public class RemoveLinkedListElements {

    // remove all nodes with value val
    private static ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;

        // special case if need to remove head
        while(head != null && head.val == val){
            head = head.next;
        }


        // use classic previous and current pointers
        ListNode curr = head;
        ListNode prev = head;

        while(curr != null){
            // remove
            if(curr.val == val){
                curr = curr.next;
                prev.next = curr;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode curr = removeElements(l1, 6);
        // expected 3->4->5->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
