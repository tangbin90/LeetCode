import entity.ListNode;

import static com.sun.org.apache.xerces.internal.impl.xs.opti.SchemaDOM.traverse;

public class Palindrome {
    String palindrome(String str, int l, int r){
         while(l>=0 && r < str.length() && str.charAt(l)==str.charAt(r)){
             l--;
             r++;
         }

         return str.substring(l+1, r-l-1);
    }

    boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }

    ListNode left;
    boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right){
        if(right == null) return true;

        Boolean res = traverse(right.next);
        res = res && (left.val==right.val);
        left = left.next;
        return res;
    }



    ListNode reverse(ListNode head){
        ListNode pre = null, curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    ListNode reverse2(ListNode head){
        if(head==null || head.next == null)
            return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode reverse3(ListNode a, ListNode b){
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        next = a;

        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    ListNode reverseKGroup(ListNode head, int k){
        if(head==null) return null;

        ListNode a, b;
        a=b=head;
        for(int i=0; i< k; i++){
            if(b==null) return head;
            b = b.next;
        }

        ListNode newHead = reverse3(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
