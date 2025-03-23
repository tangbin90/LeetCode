package leetcodesolutions;

import entity.ListNode;

public class NO143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        mergeList(head, head2);

    }

    public ListNode reverseList(ListNode head){
        if(head==null)
            return head;

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;

        }
        return pre;
    }

    public void mergeList(ListNode head1, ListNode head2){
        ListNode n1 = head1;
        ListNode n2 = head2;

        while(n1 != null && n2 != null){
            ListNode n1n = n1.next;
            ListNode n2n = n2.next;
            n1.next = n2;
            n2.next = n1n;

            n1 = n1n;
            n2 = n2n;
        }
    }

    public static void main(String[] args) {
        NO143ReorderList n143 = new NO143ReorderList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        n143.reorderList(l1);
        ListNode tmp = l1;
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }



}
