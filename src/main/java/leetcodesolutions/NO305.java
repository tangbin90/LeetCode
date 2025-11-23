package leetcodesolutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NO305 {
    private int[][] directions = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
    };

    private boolean[][] visited;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> li = new LinkedList<>();
        visited = new boolean[m][n];
        UnionFind unionFind = new UnionFind(m*n);
        for(int[] position : positions){
            int inX = position[0];
            int inY = position[1];
            int pos = inX*n + inY;
            visited[inX][inY] = true;
            unionFind.count++;
            for(int[] direction : directions){
                int newInx = direction[0] + inX;
                int newIny = direction[1] + inY;

                if(isIsland(newInx, newIny, m, n)){
                    int newPos = newInx*n + newIny;
                    unionFind.union(pos, newPos);
                }
            }
            li.add(unionFind.count);

        }

        return li;
    }

    private boolean isIsland(int i, int j, int m, int n){
        return i>=0&& j>=0 && i<m && j<n && visited[i][j];
    }
    class UnionFind {
        public int count;
        public int[] parents;
        public int[] groupSize;

        public UnionFind(int num){
            parents = new int[num];
            for(int i=0; i< num; i++){
                parents[i] = i;
            }
            count = 0;
            groupSize = new int[num];
            Arrays.fill(groupSize, 1);
        }
        public int find(int x){
            while(parents[x] != x){
                x = parents[x];
            }

            return x;
        }

        public void union(int i, int j){
            int rooti = find(i);
            int rootj = find(j);

            if(rooti == rootj){
                return;
            }

            if(groupSize[i] > groupSize[j]){
                parents[rootj] = rooti;
                groupSize[rooti] = groupSize[rooti] + groupSize[rootj];
            }
            else {
                parents[rooti] = rootj;
                groupSize[rootj] = groupSize[rooti] + groupSize[rootj];
            }
            count--;

        }
    }

    public static void main(String[] args) {
        NO305 no305 = new NO305();
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        List<Integer> li = no305.numIslands2(3, 3, positions);
        for(Integer i : li){
            System.out.println(i);
        }
    }
}
