import common.ListNode;

public class DeleteNodeInALinkedList {

    // node is the one to delete
    private static void deleteNode(ListNode node) {
        if(node == null)
            return;

        // shift the value in next
        node.val = node.next.val;
        // point around next
        node.next = node.next.next;
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

        deleteNode(l3);
        ListNode curr = l1;
        // expected -1->5->4->0->
        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

    }
}
