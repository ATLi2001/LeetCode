public class MergeTwoSortedLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
        // set up list 1
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        // set up list 2
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        // expected 1 -> 1 -> 2 -> 3 -> 4 -> 4
        ListNode test = mergeTwoLists(l11, l21);
        while(test != null){
            System.out.print(test.val + " -> ");
            test = test.next;
        }

        System.out.println();

        // expected 1 -> 2 -> 4 (l11)
        ListNode test2 = mergeTwoLists(l11, null);
        while(test2 != null){
            System.out.print(test2.val + " -> ");
            test2 = test2.next;
        }

    }
}
