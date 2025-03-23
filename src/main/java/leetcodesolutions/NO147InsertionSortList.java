package leetcodesolutions;

import entity.ListNode;

public class NO147InsertionSortList {
    /**
     * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
     *
     * The steps of the insertion sort algorithm:
     *
     * Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
     * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
     * It repeats until no input elements remain.
     * The following is a graphical example of the insertion sort algorithm.
     * The partially sorted list (black) initially contains only the first element in the list.
     * One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;

        while(cur!=null){
            if(cur.val < pre.val){
                ListNode tmp = head;
                ListNode pretmp = null;
                while(tmp != cur){
                    if(tmp.val > cur.val){
                        break;
                    }
                    pretmp = tmp;
                    tmp = tmp.next;
                }
                pre.next = cur.next;
                cur.next = tmp;
                if(pretmp != null){
                    pretmp.next = cur;
                }else {
                    head = cur;
                }

                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }


    public void swapNode(ListNode node1, ListNode node2){

    }
}
