import common.ListNode;

public class AddTwoNumbers {
        // You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order and each of their nodes contain a single digit.
    // Add the two numbers and return it as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode();
        // outHead is a virtual node
        ListNode outHead = out;

        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;

            // set carry
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            // current sum digit
            out.next = new ListNode(sum);
            out = out.next;

            // move to next digit
            l1 = l1.next;
            l2 = l2.next;
        }



        // one list may be longer than the other
        ListNode curr = null;
        if(l1 != null){
            curr = l1;
        }
        else if(l2 != null){
            curr = l2;

        }

        // remaining digits
        while(curr != null){
            int sum = curr.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }

            // current sum digit
            out.next = new ListNode(sum);
            out = out.next;

            curr = curr.next;
        }

        // create new digit if need
        if(carry != 0){
            out.next = new ListNode(1);
            out = out.next;
            carry = 0;
        }

        return outHead.next;
    }

    public static void main(String[] args) {
        // 342
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        // 465
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode curr = addTwoNumbers(l11, l21);
        // expected 7->0->8->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println();

        // 11
        ListNode l31 = new ListNode(1);
        ListNode l32 = new ListNode(1);
        l31.next = l32;

        // 999
        ListNode l41 = new ListNode(9);
        ListNode l42 = new ListNode(9);
        ListNode l43 = new ListNode(9);
        l41.next = l42;
        l42.next = l43;

        curr = addTwoNumbers(l31, l41);
        // expected 0->1->0->1->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

    }
}
