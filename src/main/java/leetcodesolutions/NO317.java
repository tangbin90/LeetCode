package leetcodesolutions;

import java.util.LinkedList;
import java.util.Queue;

public class NO317 {
    public int shortestDistance(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int buildNum = 0;
        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                if(grid[i][j] == 1)
                    buildNum++;
            }
        }
        int min = Integer.MAX_VALUE;
        int[][] rslt = new int[r][c];
        for(int i=0; i< r; i++){
            for(int j = 0; j < c; j++){
                rslt[i][j] = bfs(i, j, grid, buildNum);
                if(rslt[i][j] == -1)
                    continue;
                else
                    min = Math.min(rslt[i][j], min);
            }
        }
        return min;

    }
    private final static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};

    private int bfs(int i, int j, int[][] grid, int buildNum){
        if(grid[i][j] > 0)
            return -1;

        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        Queue<Pair<Integer, Integer>> pairs = new LinkedList<>();
        int rslt = 0;
        pairs.add(new Pair<Integer, Integer>(i, j));
        visited[i][j] = true;
        while(!pairs.isEmpty() && buildNum > 0){
            rslt += buildNum;
            int size = pairs.size();
            for(int k=0; k<size; k++) {
                Pair<Integer, Integer> node = pairs.poll();

                for (int[] direction : directions) {
                    int x = node.getKey() + direction[0];
                    int y = node.getValue() + direction[1];
                    if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            buildNum--;
                        } else if (grid[x][y] == 0) {
                            pairs.add(new Pair<Integer, Integer>(x, y));
                        }
                        visited[x][y] = true;
                    }
                }
            }
        }
        return rslt;
    }

    public static void main(String[] args) {
        NO317 no317 = new NO317();
        int[][] grid = {
                {1, 0, 2},
                {0, 0, 0},
                {2, 0, 1}
        };
        int rslt = no317.shortestDistance(grid);
        System.out.println(rslt); // Expected output: 7
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
