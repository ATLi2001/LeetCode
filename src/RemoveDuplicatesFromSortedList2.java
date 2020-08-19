public class RemoveDuplicatesFromSortedList2 {
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

    // leave only distinct numbers from the original list
    private static ListNode deleteDuplicates(ListNode head) {
        // empty
        if(head == null)
            return null;
        // single node
        if(head.next == null)
            return head;

        // distinct points to most recent distinct number
        ListNode distinct = null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(next != null){
            // general case
            if(prev != null){
                // distinct number at curr
                if(prev.val != curr.val && curr.val != next.val){
                    distinct = curr;
                }
                // prev and curr are same, next is distinct
                else if(prev.val == curr.val && curr.val != next.val){
                    // point around to next
                    if(distinct != null)
                        distinct.next = next;
                    else
                        head = next;
                }
            }
            // head node
            else{
                if(curr.val != next.val) {
                    distinct = curr;
                }
            }
            // advance pointers
            prev = curr;
            curr = next;
            next = next.next;
        }

        // check ending node
        if(curr.val == prev.val){
            if(distinct != null)
                distinct.next = null;
            // no distinct
            else
                return null;
        }

        return head;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode curr = deleteDuplicates(l1);
        // expected 3->5->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
