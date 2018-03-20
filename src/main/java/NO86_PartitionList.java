/**
 * @author TangBin
 * @version V1.0
 * @date 17/03/2018 9:28 PM
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->3->4->5.
 */
public class NO86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode node = head;
        ListNode smallerHead = new ListNode(0);
        ListNode biggerHead = new ListNode(0);
        ListNode nodeMiner = smallerHead;
        ListNode nodeBigger = biggerHead;

        while(node!=null){
            if(node.val<x){
                nodeMiner.next = node;
                nodeMiner = node;
            }else{
                nodeBigger.next= node;
                nodeBigger = node;
            }
            node = node.next;
        }
        nodeMiner.next= biggerHead.next;
        nodeBigger.next = null;
        return smallerHead.next;
    }

    public static void main(String[] args){
        ListNode nodetemp = new ListNode(2);
        ListNode node = new ListNode(1);
        nodetemp.next = node;
        NO86_PartitionList  partitionList = new NO86_PartitionList();
        partitionList.partition(nodetemp,2);

    }
}
