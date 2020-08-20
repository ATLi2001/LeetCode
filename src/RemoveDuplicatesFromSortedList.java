import common.ListNode;

public class RemoveDuplicatesFromSortedList {

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            // since is sorted, check two consecutive values
            int prevVal;
            if(prev != null) {
                prevVal = prev.val;
                int currVal = curr.val;
                // duplicate so point around
                if(prevVal == currVal){
                    prev.next = curr.next;
                }
                else{
                    prev = curr;
                }
            }
            else{
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode curr = deleteDuplicates(l1);
        // expected 1->2->3->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
