package leetcodesolutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NO310 {
    private int[] inDegree;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rslt = new LinkedList<>();
        List<Integer>[] graph = new List[n];
        inDegree = new int[n];

        if(n == 1){
            rslt.add(0);
            return rslt;
        }

        for(int i=0; i<n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i < inDegree.length; i++){
            if(inDegree[i]==1){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            rslt = new LinkedList<>();
            for(int i=0; i<size; i++){
                int node = queue.poll();
                inDegree[node]--;
                rslt.add(node);
                for(Integer k : graph[node]){
                    inDegree[k]--;
                    if(inDegree[k]==1){
                        rslt.add(k);
                        queue.add(k);
                    }
                }
            }
        }

        return rslt;
    }

    public static void main(String[] args) {
        NO310 no310 = new NO310();
        int[][] edges ={{1,0},{1,2},{1,3}};
        List<Integer> rslt = no310.findMinHeightTrees(4, edges);
        System.out.println(rslt.toString());
    }
}
