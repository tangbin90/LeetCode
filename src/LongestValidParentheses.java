import java.util.Stack;

/**
 * @author TangBin
 * @version V1.0
 * @date 18/07/2017 4:54 PM
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Character> sc = new Stack<>();
        int length = 0;
        int lengthtemp = 0;
        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(c =='(')
                sc.push(c);
            else if(c==')'&& !sc.empty()) {
                sc.pop();
                lengthtemp+=2;
            }else if(c==')'&& sc.empty()){
                length=length<lengthtemp?lengthtemp:length;
                lengthtemp=0;
            }
        }

        return length<lengthtemp?lengthtemp:length;
    }

    public static void main(String... args){
        LongestValidParentheses longestValidParentheses =  new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("()"));
    }
}
