/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO82_RemoveDuplicatesFromSoredListII
 * Date: 2018/3/15 17:11
 * Description:
 */

import entity.ListNode;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/15 17:11
 * @since 1.0.0
 * @description: 〈Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.〉
 */
public class NO82_RemoveDuplicatesFromSoredListII {
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

            if(preNode.next==node) {
                preNode = node;
            }else {
                preNode.next = node.next;
            }

            node = node.next;
        }
        return fakeHead.next;
    }


    public static void main(String[] args) {
    }
}
