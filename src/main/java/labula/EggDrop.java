package labula;

import java.util.Map;

public class EggDrop {
    //dp(k, N)
    //K: egg number
    //N: floor number

    public static Map<String, Integer> mem;

    public static int eggDrop(int K, int N){
        return dp(K, N);
    }

    public static int dp(int K, int N){
        if(K == 1)
            return N;
        if(N == 0)
            return 0;

        String key = String.valueOf(K) + ':' + N;
        if(mem.containsKey(key))
            return mem.get(key);

        int res = Integer.MIN_VALUE;
        for(int i=1; i <= N; i++){
            res = Math.min(res, Math.max(dp(K, N-i), dp(K-1, i-1))) + 1;

        }
        mem.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(eggDrop(1, 20));
    }

}
