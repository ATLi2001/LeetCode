import common.ListNode;

public class SortList {

    // Sort a linked list in O(n log n) time using constant space complexity.
    private static ListNode sortList(ListNode head) {
        if(head == null)
            return null;

        // use merge sort
        ListNode prev = null;
        ListNode curr = head;
        int len = 0;

        while(curr != null){
            len++;
            prev = curr;
            curr = curr.next;
        }

        return sortListHelper(head, prev, len);
    }

    // recursive helper function
    private static ListNode sortListHelper(ListNode start, ListNode end, int len){
        if(start == end){
            return start;
        }
        if(start.next == end){
            start.next = null;
            end.next = null;
            return mergeTwoLists(start, end);
        }
        // find the middle node to partition by
        int mid = len / 2;
        int count = 0;
        ListNode curr = start;
        while(count < mid){
            count++;
            curr = curr.next;
        }

        // need to end the list
        ListNode next = curr.next;
        curr.next = null;

        ListNode left = sortListHelper(start, curr, count);
        ListNode right = sortListHelper(next, end, len - count);

        return mergeTwoLists(left, right);
    }

    // merge two sorted lists l1, l2
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode out;

        // special case if one of lists is empty
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        // l1, l2 both not null so initialize out
        else{
            if (l1.val < l2.val) {
                out = l1;
                l1 = l1.next;
            }
            else {
                out = l2;
                l2 = l2.next;
            }
        }
        ListNode curr = out;

        while(l1 != null && l2 != null){
            // current l1 is smaller so do it next
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            // current l2 is smaller so do it next
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            // advance curr pointer
            curr = curr.next;
        }

        // at the end, check which of l1 and l2 is done
        if(l1 == null)
            curr.next = l2;
        if(l2 == null)
            curr.next= l1;

        return out;
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

        ListNode curr = sortList(l1);
        // expected -1->0->3->4->5->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
