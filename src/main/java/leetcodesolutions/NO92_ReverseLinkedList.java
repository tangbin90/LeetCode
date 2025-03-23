package leetcodesolutions;

import entity.ListNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 20/03/2018 6:37 PM
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.


 */
public class NO92_ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        int count = 1;

        ListNode node = head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = node;
        ListNode preNode = fakeHead;
        ListNode startNode = head;
        while(node!=null){
            if(count==m){
                startNode = preNode;
            }
            if(count==n)
                break;
            count++;
            preNode = node;
            node = node.next;
        }


        ListNode last = node.next;
        ListNode first = startNode.next;
        ListNode tempFirst = first;
        ListNode subPreNode = new ListNode(0);
        subPreNode.next = first;
        while(first!=last){
            ListNode temp = first.next;
            first.next = subPreNode;
            subPreNode = first;
            first = temp;
        }
        startNode.next = node;
        tempFirst.next = last;
        return fakeHead.next;
    }

    public static void main(String[] args) {
        NO92_ReverseLinkedList reverseLinkedList = new NO92_ReverseLinkedList();
        ListNode node = new ListNode(3);
        ListNode next  = new ListNode(5);
        node.next = next;
        reverseLinkedList.reverseBetween(node,1,2);
    }
}
