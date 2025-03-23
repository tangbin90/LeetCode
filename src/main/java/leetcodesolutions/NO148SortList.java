package leetcodesolutions;

import entity.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

public class NO148SortList {

    public ListNode sortList(ListNode head) {
        if(head==null)
            return head;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }

        list.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        cur = list.get(0);
        for(int i=1; i< list.size(); i++){
            cur.next = list.get(i);
            cur = list.get(i);
        }
        cur.next = null;

        return list.get(0);
    }
}
