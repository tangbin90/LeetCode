package bnb.firstround;

import java.util.*;

public class Itinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ls : tickets){
            String from = ls.get(0);
            String to = ls.get(1);

            PriorityQueue<String> pq =  graph.getOrDefault(from, new PriorityQueue<>());
            pq.add(to);
            graph.put(from, pq);
        }

        List<String> path = new ArrayList<>();
        dfs("JFK", graph, path);

        Collections.reverse(path);
        return path;
    }

    private void dfs(String airPort, Map<String, PriorityQueue<String>> mp, List<String> path){
        PriorityQueue<String> pq = mp.getOrDefault(airPort, new PriorityQueue<String>());

        while(!pq.isEmpty()){
            String port = pq.poll();
            dfs(port, mp, path);
        }

        path.add(airPort);
    }
}
