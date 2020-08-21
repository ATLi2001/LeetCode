import common.ListNode;

public class PalindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
        // empty
        if(head == null)
            return false;
        // one node
        if(head.next == null)
            return true;

        // fast slow pointers to get to midpoint
        // when fast reaches end, slow will be at mid
        // prev will be one before slow
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // first half
        prev.next = null;

        // reverse second half
        prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // at this point, prev is at the end of the list
        while(head != null && prev != null){
            if(head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        // expected true
        System.out.println(isPalindrome(l1));
        // expected false
        System.out.println(isPalindrome(l2));
    }
}
