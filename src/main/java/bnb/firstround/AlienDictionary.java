package bnb.firstround;

import java.util.*;

/**
 * There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are sorted lexicographically by the rules of this new language.
 *
 * If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".
 *
 * Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */
public class AlienDictionary {
    public String alienOrder(String[] words){
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for(String word : words){
            char[] chs = word.toCharArray();
            for(char ch : chs){
                graph.putIfAbsent(ch, new HashSet<>());
                inDegree.put(ch, 0);
            }
        }

        for(int i=0; i < words.length -1 ; i++){
            String before = words[i];
            String after = words[i + 1];
            int len = Math.min(before.length(), after.length());
            int j = 0;
            for(; j< len ;j++){

                if(before.charAt(j) == after.charAt(j)){
                    continue;
                } else {
                    if(!graph.get(before.charAt(j)).contains(after.charAt(j))){
                        graph.get(before.charAt(j)).add(after.charAt(j));
                        inDegree.put(after.charAt(j), inDegree.get(after.charAt(j)) + 1);
                    }

                    break;
                }
            }

            if(j == len && before.length() > after.length()){
                return "";
            }
        }

        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder rslt = new StringBuilder();

        for(Character ch : inDegree.keySet()){
            if(inDegree.get(ch) == 0){
                dq.add(ch);
            }
        }

        while(!dq.isEmpty()){
            char ch = dq.poll();
            rslt.append(ch);
            for(char nei : graph.get(ch)){
                inDegree.put(nei, inDegree.get(nei) - 1);
                if(inDegree.get(nei) == 0) dq.offer(nei);
            }

        }



        if(rslt.length() != inDegree.size()){
            return "";
        }

        return rslt.toString();

    }

}
