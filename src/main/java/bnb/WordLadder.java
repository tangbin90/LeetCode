package bnb;

import java.sql.Array;
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        for(String word : wordList){
            for(int i=0; i<=word.length()-1; i++){
                String str = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> ls = graph.getOrDefault(str, new ArrayList<>());
                ls.add(word);
                graph.put(str, ls);
            }
        }

        int steps = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Map<String, List<String>> neibours = new HashMap<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                String word = queue.poll();

                for(int j = 0; j < word.length(); j++){
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    List<String> neighbors = graph.getOrDefault(pattern, Collections.emptyList());
                    for (String next : neighbors) {
                        if (next.equals(endWord)) {
                            return steps + 1;  // 当前层 + 1
                        }
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }

            }
            steps++;
        }

        return 0;
    }


}
