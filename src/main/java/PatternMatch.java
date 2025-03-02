import java.util.HashMap;
import java.util.Map;

public class PatternMatch {
    //* none and repeated char
    //. any char
    //dp(s, i, p, j)
    private static Map<String, Boolean> mem = new HashMap<>();
    public static boolean dp(String s, int i, String p, int j){
        if(j==p.length())
            return i==s.length();
        String key = String.valueOf(i)+','+ j;
        if(mem.containsKey(key))
            return mem.get(key);

        if(i==s.length()){
            return matchEmpty(p, j);

        }
        boolean res = false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j) =='.'){
            if(j < s.length() - 1 && p.charAt(j + 1) =='*'){
                return dp(s, i,p, j+2) || dp(s, i+1, p, j+2) || dp(s, i+1, p, j);
            } else {
                return dp(s, i+1, p, j+1);
            }

        } else {
            if(j < s.length() - 1  && p.charAt(j+1) == '*') {
                return dp(s, i, p, j+2);
            } else
                res = false;
        }

        mem.put(key, res);
        return res;
    }

    public static boolean matchEmpty(String p, int j){
        for(; j+1 < p.length(); j+=2)
            if(p.charAt(j+1) != '*')
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(dp("a",0, ".*", 0));
    }
}
