package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO32_LongestValidParentheses
 * Date: 2018/3/6 16:45
 * Description:
 */

import java.util.Stack;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/6 16:45
 * @since 1.0.0
 * @description: 〈〉
 */
public class NO32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }


    public int longestValidParentheses2(String s) {
        boolean valid[] = new boolean[s.length()];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (!stack.isEmpty()) {
                valid[stack.pop()] = valid[i] = true;
            }
        }

        return longest(valid);
    }

    private int longest(boolean[] valid) {
        int max = 0;
        int len = 0;

        for (boolean v : valid) {
            max = Math.max(max,len = v ? len + 1 : 0);
        }

        return max;
    }
    public static void main(String[] args){
        NO32_LongestValidParentheses longestValidParentheses = new NO32_LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses2("()()(()"));
    }
}
