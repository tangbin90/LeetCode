package bnb.firstround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static labula.Balloon.res;

public class MinTransfers {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balance = new HashMap<>();

        for (int[] t : transactions) {
            int from = t[0], to = t[1], amt = t[2];
            balance.put(from, balance.getOrDefault(from, 0) - amt);
            balance.put(to, balance.getOrDefault(to, 0) + amt);
        }

        // 2. 只保留非 0 的人
        List<Integer> debtsList = new ArrayList<>();
        for (int v : balance.values()) {
            if (v != 0) debtsList.add(v);
        }

        int n = debtsList.size();
        int[] debts = new int[n];
        for (int i = 0; i < n; i++) debts[i] = debtsList.get(i);

        return dfs(0, debts);
    }


    private int dfs(int start, int[] debts) {
        while(debts[start] == 0) start ++;

        if(start == debts.length) return 0;

        int rslt = Integer.MAX_VALUE;

        for(int i=start + 1; i< debts.length; i++){
            if(debts[start] * debts[i] < 0){
                debts[i] += debts[start];
                res = Math.min(res, dfs(start + 1, debts));
                debts[i] -= debts[start];
            }

            if(debts[start] + debts[i] == 0)
                break;

            // 剪枝 2：跳过后面相同值的 i，避免重复状态
            while (i + 1 < debts.length && debts[i + 1] == debts[i]) i++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

}
