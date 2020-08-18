import java.util.Stack;

public class AddTwoNumbers2 {
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

    // most significant digit comes first
    // don't reverse lists and then use previous addTwoNumbers
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // still need to do least significant digits first
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        // to return
        ListNode outHead = null;

        int carry = 0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int sum = s1.pop() + s2.pop() + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }

            // add the nodes to beginning of outHead
            ListNode temp = new ListNode(sum);
            temp.next = outHead;
            outHead = temp;
        }
        // different size stacks
        Stack<Integer> curr = null;
        if(!s1.isEmpty()){
            curr = s1;
        }
        else if(!s2.isEmpty()){
            curr = s2;
        }

        if(curr != null){
            while(!curr.isEmpty()){
                int sum = curr.pop() + carry;
                if(sum >= 10){
                    carry = 1;
                    sum = sum % 10;
                }
                else{
                    carry = 0;
                }

                ListNode temp = new ListNode(sum);
                temp.next = outHead;
                outHead = temp;
            }
        }

        if(carry != 0){
            ListNode temp = new ListNode(1);
            temp.next = outHead;
            outHead = temp;
        }

        return outHead;
    }

    public static void main(String[] args) {
        // 243
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        // 564
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode curr = addTwoNumbers(l11, l21);
        // expected 8->0->7->
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
        // expected 1->0->1->0->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
