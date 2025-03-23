package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO49_GroupAnagrams
 * Date: 2018/3/9 14:39
 * Description:
 */

import java.util.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/9 14:39
 * @since 1.0.0
 * @description: 〈Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
["ate", "eat","tea"],
["nat","tan"],
["bat"]
]
Note: All inputs will be in lower-case.〉
 */
public class NO49_GroupAnagrams {
    int[] primeNums = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> arrayList = new LinkedList<>();
        if(strs==null||strs.length==0)
            return arrayList;
        Map<Integer,List<String>> strMap = new HashMap<>();
        for(String str : strs){
            int key = charToInt(str);
            if(strMap.containsKey(key))
                strMap.get(key).add(str);
            else{
                ArrayList<String> newArrayList = new ArrayList<>();
                newArrayList.add(str);
                strMap.put(key,newArrayList);
            }
        }
        arrayList.addAll(strMap.values());
        return arrayList;
    }

    public int charToInt(String str){
        char[] characters = str.toCharArray();
        int res=1;
        for(int i=0;i<str.length();i++){
            res *= primeNums[characters[i]-'a'];
        }
        return res;
    }


}
