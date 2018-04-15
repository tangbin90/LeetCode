import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 2018/4/14 10:47 AM
 */
public class NO131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res =  new LinkedList<>();
        partition(new ArrayList<String>(),0,s, res);
        return res;
    }

    private  void partition(List<String> ls, int count, String s, List<List<String>> res){
        if(count==s.length()) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=count;i<s.length();i++){
            if(isPalindrome(s.substring(count, i+1))){
                ls.add(s.substring(count, i+1));
                partition(ls,i+1,s,res);
                ls.remove(ls.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str){
        if(str.length()==1)
            return true;
        int start = 0;
        int end = str.length()-1;

        while(start<=end){
            if(str.charAt(start)==str.charAt(end)){
                start++;
                end--;
            }else
                return false;
        }
        return true;
    }
}
