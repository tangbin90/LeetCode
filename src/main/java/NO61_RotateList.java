import entity.ListNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 12/03/2018 11:18 AM
 * Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
 */
public class NO61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode node = head;
        ListNode preNode = null;
        int count=0;
        while(node!=null){
            preNode = node;
            node = node.next;
            count++;
        }
        preNode.next = head;
        node = head;
        for(int i=0;i<count-k%count;i++){
            preNode = node;
            node = node.next;
        }
        preNode.next= null;
        return node;

    }

    public static void main(String[] args){
        NO61_RotateList rotateList = new NO61_RotateList();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i=2;i<6;i++){
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = temp;
        }

        head = rotateList.rotateRight(head,2);
        while(head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
