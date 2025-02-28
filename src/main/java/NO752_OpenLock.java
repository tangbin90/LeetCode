import java.util.*;

public class NO752_OpenLock {


    public int openLock(String[] deadends, String target) {
        Set<String> deadEndsSet = new HashSet<>();
        deadEndsSet.addAll(Arrays.asList(deadends));

        if(deadEndsSet.contains(target))
            return -1;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        String initialStr = "0000";
        q1.add(initialStr);
        q2.add(target);
        int count = 0;

        while(!q1.isEmpty()){
            Set<String> temp = new HashSet<>();
            for(String str : q1){
                visited.add(str);
                if(q2.contains(str))
                    return count;
                if(deadEndsSet.contains(str))
                    continue;

                for(int j=0; j< target.length(); j++){
                    String up = plusOne(str, j);
                    if(!visited.contains(up))
                        temp.add(up);

                    String down = minusOne(str, j);
                    if(!visited.contains(down))
                        temp.add(down);
                }
            }
            q1 = q2;
            q2 = temp;
            count ++;
        }

        return -1;
    }

    public String plusOne(String s, int pos){
        char[] ch = s.toCharArray();
        if(ch[pos] == '9')
            ch[pos] = '0';
        else
            ch[pos] += 1;

        return new String(ch);

    }

    public String minusOne(String s, int pos){
        char[] ch = s.toCharArray();
        if(ch[pos] == '0')
            ch[pos] = '9';
        else
            ch[pos] -= 1;

        return new String(ch);
    }
    public static void main(String[] args) {
        String[] deadends = {"1111"};
        String target = "0011";

        NO752_OpenLock openLock = new NO752_OpenLock();

        System.out.println(openLock.openLock(deadends, target));
    }
}
