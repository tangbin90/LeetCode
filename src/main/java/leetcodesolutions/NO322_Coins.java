package leetcodesolutions;

import java.util.HashMap;
import java.util.Map;

public class NO322_Coins {
    public static Map<Integer, Integer> mem = new HashMap<>();

    public int coinChange(int[] coins, int amount) {

        if(mem.containsKey(amount))
            return mem.get(amount);

        if(coins==null||coins.length==0)
            return -1;

        if (amount < 0)
            return -1;

        if (amount == 0)
            return 0;

        int result = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            int resultTmp = coinChange(coins, amount-coins[i]);
            if(resultTmp == -1)
                continue;
            result = Math.min(result, resultTmp+1);
        }
        result = result==Integer.MAX_VALUE?-1:result;
        mem.put(amount, result);
        return result;
    }


    public static void main(String[] args) {
        NO322_Coins solution = new NO322_Coins();
        int[] coins = {2};
        int amount = 3;
        System.out.println(solution.coinChange(coins, amount));
    }
}


