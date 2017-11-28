import java.util.*;

/**
 * Created by tangbin1 on 2017/7/10.
 */
public class FindSubstringStartPosition {
    public List<Integer> findSubString(String s, String[] words){
        List<Integer> li = new LinkedList<>();
        if(s==null || words==null|| words.length==0||s.length()<words.length*words[0].length()) return li;
        Map<String, Integer>  strCount= new HashMap<>();
        for(String str: words)
            strCount.put(str, strCount.containsKey(str)? strCount.get(str)+1:1);

        int singleWordLen = words[0].length();
        int wordsTotalLen = words.length*singleWordLen;
        for(int i=0;i<=s.length()-wordsTotalLen;i++){
            Map<String, Integer> mapCopy = new HashMap<>(strCount);
            for(int j=i;j<i+wordsTotalLen;j+=singleWordLen){
                String strTemp = s.substring(j,j+singleWordLen);
                if(mapCopy.containsKey(strTemp)){
                    int count = mapCopy.get(strTemp);
                    if(count==1)
                        mapCopy.remove(strTemp);
                    else
                        mapCopy.put(strTemp,count-1);
                }else
                    break;
            }
            if(mapCopy.isEmpty())
                li.add(i);
        }
        return li;
    }

    public static void main(String[] args){
        FindSubstringStartPosition findSubstringStartPosition = new FindSubstringStartPosition();
        String[] words = {"a"};
        findSubstringStartPosition.findSubString("taa",words);
    }


}
