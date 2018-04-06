/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO126_WordLadderII
 * Date: 2018/2/27 18:55
 * Description: Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:  Only one letter can be changed at a time Each transformed word must exist in the word list. Note that beginWord is not a transformed word. For example,  Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log","cog"] Return   [     ["hit","hot","dot","dog","cog"],     ["hit","hot","lot","log","cog"]   ]
 */

import java.util.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/27 18:55
 * @since 1.0.0
 * @description: 〈Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:  Only one letter can be changed at a time Each transformed word must exist in the word list. Note that beginWord is not a transformed word. For example,  Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log","cog"] Return   [     ["hit","hot","dot","dog","cog"],     ["hit","hot","lot","log","cog"]   ]〉
 */
public class NO126_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();
        dictionary.add(beginWord);
        distance.put(beginWord,0);
        bfs(beginWord, endWord, dictionary, nodeNeighbors,distance);
        dfs(beginWord, endWord,nodeNeighbors,distance,solution,res);

        return res;
    }

    private void bfs(String start, String end, HashSet<String> dictionary, HashMap<String, ArrayList<String>> nodeNeighbors,HashMap<String, Integer> distance) {
        for(String word : dictionary){
            nodeNeighbors.put(word,getNeighbors(word,dictionary));
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word = queue.poll();
                int curDistance = distance.get(word);
                ArrayList<String> neighbors = nodeNeighbors.get(word);
                for(String neighbor : neighbors){
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))
                            break;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
        }
    }

    private void dfs(String start, String end,  HashMap<String, ArrayList<String>> nodeNeighbors,HashMap<String, Integer> distance,
    ArrayList<String> individualSequence, List<List<String>> results) {
        individualSequence.add(start);
        if(end.equals(start)){
            results.add(new ArrayList<>(individualSequence));
        }else {
            ArrayList<String> neighbors = nodeNeighbors.get(start);
            for (String neighbor : neighbors){
                if(distance.containsKey(neighbor)&&distance.get(start)+1==distance.get(neighbor))
                    dfs(neighbor,end, nodeNeighbors,distance,individualSequence,results);
            }
        }
        individualSequence.remove(individualSequence.size()-1);
    }

    public ArrayList<String> getNeighbors(String word, HashSet<String> dictionary){
    int wordlength = word.length();
    char chs[] = word.toCharArray();
    ArrayList<String> res = new ArrayList<>();
    for(int i=0;i<wordlength;i++){
        for(int j='a';j<='z';j++){
            if(chs[i]==j)
                continue;
            char save = chs[i];
            chs[i] = (char)j;
            if(dictionary.contains(String.valueOf(chs)))
                res.add(String.valueOf(chs));
            chs[i] = save;
        }
    }
    return res;
}

    public static void main(String[] args){
        String[] strs = new String[]{"most","fist","lost","cost","fish"};
        String begin = "lost";
        NO126_WordLadderII wordLadderII = new NO126_WordLadderII();
        List<String> list = Arrays.asList(strs);
        List<List<String>> ls = wordLadderII.findLadders(begin,"cost",list);
        System.out.printf(ls.toString());
    }
}
