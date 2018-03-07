import java.util.*;

/**
 * Created by tangbin1 on 2017/7/3.
 */
public class NO20_ValidParentheses {
    public Map<Character, Character> brankChar;
    public Boolean isValid(String s){
        if(s.equals(""))
            return true;
        brankChar = new HashMap<>();
        brankChar.put('(',')');
        brankChar.put('{','}');
        brankChar.put('[',']');
        return isValid(s, 0, s.length());
    }

    public Boolean isValid(String s, int start, int end){
        if(start==end)
            return true;
        if(!brankChar.containsKey(s.charAt(start)))
            return false;
        char c = s.charAt(start);
        int count=0;
        for(int i=start;i<end;i++){
            if(s.charAt(i)==c){
                count++;
            }else if(s.charAt(i)==brankChar.get(c)){
                count--;
            }
            if(count==0)
                return isValid(s,start+1,i)&&isValid(s,i+1,end);
        }
        return count==0?true:false;
    }

    public boolean simpleFastIsValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
                // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
    public static void main(String[] args){
        NO20_ValidParentheses parent = new NO20_ValidParentheses();
        System.out.println(parent.isValid("()[]{}"));
    }
}
