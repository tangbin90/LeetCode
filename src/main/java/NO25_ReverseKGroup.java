/**
 * @author TangBin
 * @version V1.0
 * @date 04/07/2017 10:04 PM
 */
public class NO25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count=0;
        while(count!=k&&curr!=null){
            curr = curr.next;
            count++;
        }
        if(count==k){
            curr=reverseKGroup(curr, k);
            while(count--!=0){
                ListNode temp=head.next;
                head.next = curr;
                curr=head;
                head=temp;
            }
            head=curr;
        }
        return head;
    }

    public static void main(String... args){
        NO25_ReverseKGroup reverseKGroup = new NO25_ReverseKGroup();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode result = reverseKGroup.reverseKGroup(l1, 2);

        System.out.print(result.val);
    }
}
