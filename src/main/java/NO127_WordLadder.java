import java.util.*;

/**
 * @author TangBin
 * @version V1.0
 * @date 28/03/2018 11:06 AM
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */
public class NO127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<String>(wordList);
        HashMap<String, Integer> disMap = new HashMap<>();
        Queue<String> qStr = new LinkedList<>();
        qStr.offer(beginWord);
        disMap.put(beginWord, 1);
        return bfs(qStr,beginWord, endWord, dictionary, disMap);
    }

    private int bfs(Queue<String> qStr,String beginWord, String endWord, Set<String> wordList, HashMap<String, Integer> map){
        if(beginWord.equals(endWord))
            return map.get(beginWord);

        while(!qStr.isEmpty()){
            int size = qStr.size();

            for(int i=0;i<size;i++){
                String word = qStr.poll();
                List<String> neighbors = neighbor(word, wordList);
                for(String str :neighbors){
                    if(str.equals(endWord))
                        return map.get(word)+1;
                    else if(!map.containsKey(str)){
                        map.put(str,map.get(word)+1);
                        qStr.offer(str);
                    }
                }
            }
        }
        return 0;
    }
    public List<String> neighbor(String word, Set<String> wordList){
        List<String> res= new LinkedList<>();
        char[] chars = word.toCharArray();

        for(int i=0;i<chars.length;i++){
            for(char j='a';j<='z';j++){
                if(chars[i]==j) {
                    continue;
                } else{
                    char temp = chars[i];
                    chars[i] = j;
                    if(wordList.contains(String.valueOf(chars)))
                        res.add(String.valueOf(chars));
                    chars[i] = temp;
                }
            }
        }
        return res;
    }

    /**
     * "hit"
     "cog"
     ["hot","dot","dog","lot","log","cog"]
     * @param args
     */
    public static void main(String[] args) {
        NO127_WordLadder wordLadder = new NO127_WordLadder();
        String[] strs = new String[]{"hot","dot","dog","lot","log","cog"};
        LinkedList<String> lli = new LinkedList<>();
        lli.addAll(Arrays.asList(strs));

        System.out.println(wordLadder.ladderLength("hit","cog",lli));
    }
}
