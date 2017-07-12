import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by tangbin1 on 2017/7/3.
 */

public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null||lists.length==0)
            return null;

        ListNode head = new ListNode(0);
        ListNode temp = head;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
        while(!queue.isEmpty()){
            temp.next=queue.poll();
            temp = temp.next;
            if(temp.next!=null)
                queue.add(temp.next);
        }
        return head.next;
    }


    public static void main(String[] args){
        ListNode l2 = new ListNode(1);
        ListNode[] lists = new ListNode[1];
        lists[0] = l2;
        MergeKLists mk = new MergeKLists();
        ListNode ln = mk.mergeKLists(lists);
    }
}
