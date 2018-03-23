import entity.ListNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/03/2018 5:03 PM
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */
public class NO02_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        ListNode fakeHead = new ListNode(0);
        ListNode resTemp =fakeHead;
        int carry = 0;
        while(listNode1!=null && listNode2!=null){
            int temp = listNode1.val + listNode2.val + carry;
            carry = temp/10;
            ListNode node = new ListNode(temp%10);
            resTemp.next = node;
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
            resTemp = resTemp.next;
        }

        while(listNode1!=null){
            int temp = listNode1.val+carry;
            carry = temp/10;
            resTemp.next = new ListNode(temp%10);
            listNode1 = listNode1.next;
            resTemp = resTemp.next;
        }

        while(listNode2 != null){
            int temp = listNode2.val +carry;
            carry = temp/10;
            resTemp.next = new ListNode(temp%10);
            listNode2 = listNode2.next;
            resTemp = resTemp.next;
        }

        if(carry!=0){
            resTemp.next = new ListNode(carry);
        }

        return fakeHead.next;
    }
}
