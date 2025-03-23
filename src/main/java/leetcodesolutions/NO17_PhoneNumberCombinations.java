package leetcodesolutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangbin1 on 2017/6/29.
 */
public class NO17_PhoneNumberCombinations {
    private final String[] strs = {"0", "1", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> combinationList = new LinkedList<String>();
        if(digits.equals(""))
            return combinationList;
        combinationList.add("");
        for(int i=0;i<digits.length();i++) {
            List<String> combinationListTemp = new LinkedList<String>();
            int x = Character.getNumericValue(digits.charAt(i));
            String str = strs[x];
            for(char c: str.toCharArray())
                for(int j=0;j<combinationList.size();j++){
                    String temp = combinationList.get(j);
                    temp+=c;
                    combinationListTemp.add(temp);
                }
            combinationList=combinationListTemp;
        }
        return combinationList;
    }

    public static void main(String[] args){
        if("".equals(null))
            System.out.println("right");
        else
            System.out.println("wrong");
        NO17_PhoneNumberCombinations phoneNumberCombinations = new NO17_PhoneNumberCombinations();
        List<String> listStr = phoneNumberCombinations.letterCombinations("234");
        System.out.println(listStr.toString());
    }
}
