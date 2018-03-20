/**
 * @author TangBin
 * @version V1.0
 * @date 17/03/2018 8:32 PM
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.


 */
public class NO83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode  fakeHead= new ListNode(0);
        fakeHead.next = head;
        ListNode  preNode = fakeHead;
        ListNode node = head;

        while(node!=null){
            while(node.next!=null&&node.val==node.next.val){
                node = node.next;
            }
            preNode.next = node;
            preNode = node;
            node = node.next;
        }
        return fakeHead.next;
    }
}
