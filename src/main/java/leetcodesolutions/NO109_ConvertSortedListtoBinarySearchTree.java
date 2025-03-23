package leetcodesolutions;

import entity.ListNode;
import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/03/2018 10:00 PM
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

0
/ \
-3   9
/   /
-10  5
 */
public class NO109_ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail){
        if(head==null)
            return null;
        if(head==tail)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head, slow);
        node.right = sortedListToBST(slow.next,tail);
        return node;
    }
}
