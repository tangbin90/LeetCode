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
        return null;
    }

    public ArrayList<String> getNeighbors(String word, HashSet<String> dictionary){
        int wordlength = word.length();
        char chs[] = word.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<wordlength;i++){
            for(int j='a';j<='z';j++){
                if(chs[i]==j) continue;
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
        String[] strs = new String[]{"asd","ask","jdk","aaa","abv"};
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.addAll(Arrays.asList(strs));
        NO126_WordLadderII wordLadderII = new NO126_WordLadderII();
        List<String> ls = wordLadderII.getNeighbors("asd",dictionary);
        System.out.println(ls.toString());
    }
}
