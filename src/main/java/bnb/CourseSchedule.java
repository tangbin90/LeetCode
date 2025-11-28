package bnb;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 */

public class CourseSchedule {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] visited;
    boolean valid = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.visited = new int[numCourses];

        for(int[] course : prerequisites){
            List<Integer> li = graph.getOrDefault(course[1], new ArrayList<>());
            li.add(course[0]);
            graph.put(course[1], li);
        }

        for(int i=0; i < numCourses; i++){
            if(!graph.containsKey(i))
                graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;

    }

    public void dfs(int i){
        visited[i] = 1;

        List<Integer> to = graph.get(i);
        for(int node : to){
            if(visited[node] == 0){
                dfs(node);
                if(!valid)
                    return;
            } else if(visited[node] == 1){
                valid = false;
            }
        }
        visited[i] = 2;

    }
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inNum = new int[numCourses];
        int n = prerequisites.length;
        for(int i=0; i< numCourses; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++){
            List<Integer> nodes = graph.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            nodes.add(prerequisites[i][0]);
            inNum[prerequisites[i][0]]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<inNum.length; i++){
            if(inNum[i] == 0){
                dq.add(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i=0; i<size; i++){
                int tmp = dq.poll();
                order.add(tmp);
                for(int nxt : graph.get(tmp)){
                    inNum[nxt]--;
                    if(inNum[nxt] == 0){
                        dq.add(nxt);
                    }
                }
            }
        }

        return order.size() == numCourses;


    }


}
