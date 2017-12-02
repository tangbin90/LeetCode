/**
 * Created by tangbin1 on 2017/7/5.
 */
public class NeedleInHaystack {
    public int strStr(String haystack, String needle){
        if(haystack.equals(needle))
            return 0;
        if(needle.length()==0)
            return 0;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=0;
                for(;j<needle.length();j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j))
                        break;
                }
                if(j==needle.length())
                    return i;
            }
        }
        return -1;
    }

    public static void main(String... args){
        NeedleInHaystack needleInHaystack = new NeedleInHaystack();
        int pos = needleInHaystack.strStr("mississippi","pi");
        System.out.println(pos);
    }
}
