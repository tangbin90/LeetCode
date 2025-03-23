package leetcodesolutions;

import entity.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NO140WordBreak {
    //

    private static List<String> rslt = new LinkedList<>();
    public static void wordBreak(String s ,int n ,List<String> wordDict, LinkedList<String> track, List<String> rslt) {
        if(n>=s.length()) {
            rslt.add(String.join(" ", track));
        }

        for(String str : wordDict){
            if(n+str.length()<=s.length() && s.startsWith(str, n)){
                track.addLast(str);
                wordBreak(s, n+str.length(), wordDict, track, rslt);
                track.removeLast();
            }
        }
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode tmp = head.next;
        while(tmp!=null){
            nodeStack.push(tmp);
            tmp = tmp.next;
        }
        tmp = head;

        while(tmp!=null && tmp.next != null && !nodeStack.isEmpty()){
            ListNode endNode = nodeStack.pop();
            ListNode n = tmp.next;
            tmp.next = endNode;
            endNode.next = n;
            if(!nodeStack.isEmpty() )
                nodeStack.peek().next = null;
            tmp = n;
        }
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("apple","pen","applepen","pine","pineapple");
        LinkedList<String> track = new LinkedList<>();
        List<String> rslt = new LinkedList<>();
        NO140WordBreak.wordBreak("pineapplepenapple", 0, strs, track,rslt);
        for(String str : rslt)
            System.out.println(str);
    }
}
