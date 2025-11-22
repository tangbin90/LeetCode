package leetcodesolutions;

import java.util.*;

public class NO282 {
    private Set<Character> operator = new HashSet<>();
    private List<String> rslt = new LinkedList<>();

    public List<String> addOperators(String num, int target) {
        char[] nums = num.toCharArray();

        operator.add('+');
        operator.add('-');
        operator.add('*');
        List<Character> lc = new LinkedList<Character>();
        lc.add(nums[0]);
        addOperatorHelp(lc, 1, nums, target);

        return rslt;
    }

    void addOperatorHelp(List<Character> lc,  int pos, char[] nums ,int target){
        if(pos==nums.length){
            StringBuilder sb = new StringBuilder();
            for (Character c : lc) {
                sb.append(c);
            }
            String str = sb.toString();
            if(calculate(str)==target){
                rslt.add(str);
            }
            return;
        }
        for(char i : operator){
            lc.add(i);
            lc.add(nums[pos]);
            addOperatorHelp(lc, pos+1, nums, target);
            lc.removeLast();
            lc.removeLast();
        }
        if ((lc.size()==1||operator.contains(lc.get(lc.size()-2))) && lc.getLast() == '0'){
                System.out.println("skip " + nums[pos] + " at pos " + pos);
        } else {
            lc.add(nums[pos]);
            addOperatorHelp(lc,  pos+1, nums, target);
            lc.removeLast();
        }
    }

    long calculate(String str) {
        char sign = '+';
        long rslt = 0;
        long num = 0;
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num = num * 10 + str.charAt(i) - '0';
            }
            if (str.charAt(i) == '-' || str.charAt(i) == '+' || str.charAt(i) == '*' || i == str.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    long tmp = stack.pop();
                    stack.push(tmp * num);
                }
                sign = str.charAt(i);
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            rslt += stack.pop();
        }
        return rslt;
    }

    public static void main(String[] args) {
        NO282 no282 = new NO282();
        no282.addOperators("00",0);
        for(String str : no282.rslt){
            System.out.println(str);
        }

        System.out.println(no282.rslt.size());
    }

}
