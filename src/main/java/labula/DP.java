package labula;

import java.util.HashMap;
import java.util.Map;

public class DP {
    //operation number: n
    // cnumber: cn
    //clipboard number: clipn
    // Type A: dp(n-1, cn+1, clipn)
    // CV: dp(n-1, cn+clipn, clipn)
    // Select and copy: dp(n-2, cn, cn)
    public static Map<String, Integer> mem = new HashMap<>();

    public static int chNumber(int n){
        return dp(n, 0, 0);
    }

    public static int dp(int n, int cn, int clipn) {
        if(n<=0)
            return cn;

        if(mem.containsKey(String.valueOf(n) + cn + clipn))
            return mem.get(String.valueOf(n) + cn + clipn);

        mem.put(String.valueOf(n) + cn + clipn,
                Math.max(Math.max(dp(n-1, cn + 1, clipn), dp(n-1, cn+clipn, clipn)), dp(n-2, cn, cn)));

        return mem.get(String.valueOf(n) + cn + clipn);
    }


    // operation number n
    // last operation other A or Ctrl-V
    //
    public static void main(String[] args) {
        System.out.println(chNumber(3));
    }

}
