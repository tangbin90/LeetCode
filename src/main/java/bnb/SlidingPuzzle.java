package bnb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    int[][] neighbors = {
            {1, 3},      // 0
            {0, 2, 4},   // 1
            {1, 5},      // 2
            {0, 4},      // 3
            {1, 3, 5},   // 4
            {2, 4}       // 5
    };

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();
        String target = "123450";

        // 如果一开始就已经是目标状态
        if (start.equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 一层一层扩展
            for (int s = 0; s < size; s++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return steps;
                }

                int zeroIdx = curr.indexOf('0');  // 找到空格的位置

                // 尝试把 0 和它能交换的每个邻居交换
                for (int nei : neighbors[zeroIdx]) {
                    String next = swap(curr, zeroIdx, nei);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }

        return -1; // 无解
    }

    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return new String(arr);
    }

}
