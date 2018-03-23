import java.util.HashMap;
import java.util.Map;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/03/2018 5:16 PM
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class NO03_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> cpMap = new HashMap<>();
        int length = 0;
        int start = 0;

        for(int i=0;i<chars.length;i++){
            if(!cpMap.containsKey(chars[i])) {
                cpMap.put(chars[i], i);
            }
            else{
                if(cpMap.get(chars[i])+1>start)
                    start = cpMap.get(chars[i])+1;
                cpMap.put(chars[i], i);
            }
            if(length<(i-start+1))
                length = i-start+1;
        }
        return length;
    }

    public static void main(String[] args) {
        NO03_LongestSubstringWithoutRepeatingCharacters Longest = new NO03_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(Longest.lengthOfLongestSubstring("pwwkew"));
    }
}
