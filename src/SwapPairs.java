/**
 * Created by tangbin1 on 2017/7/3.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        ListNode pairPrevious = new ListNode(0);
        ListNode temp = pairPrevious;
        pairPrevious.next = head;
        ListNode pairFirst = head;
        ListNode pairSecond = head.next;
        while(pairFirst!=null&&pairSecond!=null){
            pairPrevious.next = pairSecond;
            pairFirst.next = pairSecond.next;
            pairSecond.next = pairFirst;
            pairPrevious = pairFirst;
            pairFirst = pairFirst.next;
            if(pairFirst==null)
                pairSecond = null;
            else
                pairSecond = pairFirst.next;
        }
        return temp.next;
    }

    public static void main(String[] args){
        SwapPairs swapPairs = new SwapPairs();
        ListNode ln = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3  = new ListNode(3);
        ln.next=ln2;
        ln2.next = ln3;
        swapPairs.swapPairs(ln);
    }

}
