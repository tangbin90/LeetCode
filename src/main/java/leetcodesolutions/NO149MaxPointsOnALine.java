package leetcodesolutions;

import java.util.*;

public class NO149MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        if (points.length <= 1) return points.length;

        int res = 1;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int samePoint = 1;  // 记录与当前点相同的点数
            int localMax = 0;   // 记录当前点的最大共线点数

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    samePoint++;  // 处理完全相同的点
                    continue;
                }

                // 计算斜率的 gcd，使其归一化
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // 统一正负号
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slopeKey = dx + "," + dy;
                slopeCount.put(slopeKey, slopeCount.getOrDefault(slopeKey, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(slopeKey));
            }

            res = Math.max(res, localMax + samePoint);
        }
        return res;
    }
//最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
