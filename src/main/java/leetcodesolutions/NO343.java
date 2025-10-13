package leetcodesolutions;

import java.util.HashMap;
import java.util.Map;

public class NO343 {
    Map<Integer, Integer> mem = new HashMap<>();
    public int integerBreak(int n){
        mem.put(0,0);
        mem.put(1, 1);
        return integerBreakHelp(n);
    }
    public int integerBreakHelp(int n) {
        if(mem.containsKey(n)){
            return Math.max(mem.get(n), n);
        }
        int rslt = 0;
        for(int i=1; i<n; i++){
            rslt =  Math.max(rslt, i * integerBreak(n - i));
        }

        mem.put(n, rslt);
        return rslt;
    }

    public static void main(String[] args) {
        NO343 n = new NO343();
        System.out.println(n.integerBreak(10));
    }
}
