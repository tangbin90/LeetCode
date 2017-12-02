/**
 * Created by tangbin1 on 2017/6/30.
 */
public class RemoveNthNodeFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;
        ListNode nthNode = head;
        ListNode pointToEnd = head;
        ListNode previousNode = null;
        for(int i=0;i<n;i++) {
            if(pointToEnd!=null)
                pointToEnd = pointToEnd.next;
            else
                return head;
        }

        while(pointToEnd!=null){
            previousNode =nthNode;
            nthNode = nthNode.next;
            pointToEnd = pointToEnd.next;
        }

        if(nthNode==head)
            head=head.next;
        else
            previousNode.next = nthNode.next;

        return head;
    }
}
