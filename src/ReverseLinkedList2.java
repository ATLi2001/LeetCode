public class ReverseLinkedList2 {
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

    // Reverse a linked list from position m to n. Do it in one-pass.
    // Note: 1 ≤ m ≤ n ≤ length of list.
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;

        // do nothing in this case
        if(m == n)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        // 1 indexed list
        int index = 1;
        // get to starting position
        while(index < m){
            prev = curr;
            curr = curr.next;
            index++;
        }

        ListNode prevM = prev;
        ListNode nodeM = curr;

        // reverse
        while(index <= n){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index++;
        }

        // if m wasn't beginning of list, need to change the next pointer
        if(prevM != null){
            prevM.next = prev;
        }
        // if m was 1, need to change head to index n node
        else{
            head = prev;
        }
        // change node m's next pointer to be to node n+1
        nodeM.next = curr;

        return head;
    }

    public static void main(String[] args) {
        // set up a test case
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode curr = reverseBetween(l1, 2, 4);
        // expected 1->4->3->2->5->
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
