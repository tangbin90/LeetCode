package bnb;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RoundPrices {
    public int[] roundPrices(double[] prices) {
        int n = prices.length;
        int[] floor = new int[n];
        int[] ceil = new int[n];

        double[] gapsToFloor = new double[n];
        int floorSum = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            floor[i] = (int) Math.floor(prices[i]);
            ceil[i] = floor[i] + 1;
            gapsToFloor[i] = prices[i] - floor[i];
            floorSum += floor[i];
            sum += prices[i];
        }

        int target = (int)Math.round(sum);
        int ceilNum = target - floorSum;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(gapsToFloor[a], gapsToFloor[b])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(i);
            if (pq.size() > ceilNum) pq.poll();    // 弹掉最小 fractional 的
        }

        boolean[] useCeil = new boolean[n];
        for (int idx : pq) useCeil[idx] = true;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (useCeil[i]) res[i] = floor[i] + 1;
            else res[i] = floor[i];
        }
        return res;
    }
}
