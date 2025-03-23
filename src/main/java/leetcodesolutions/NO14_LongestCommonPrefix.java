package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 10/04/2017 10:48 AM
 */
public class NO14_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==0)
            return "";
        String prefix=strs[0];
        if(strs.length==1)
            return prefix;
        for(int i=1;i<strs.length;i++){
            int length = prefix.length()<strs[i].length()?prefix.length():strs[i].length();
            int j=0;
            for(;j<length;j++){
                if(prefix.charAt(j)!=strs[i].charAt(j)) {
                    break;
                }
            }
            prefix=prefix.substring(0,j);

        }
        return prefix;
    }

    public static void main(String[] args){
        System.out.println(NO14_LongestCommonPrefix.longestCommonPrefix(new String[]{"abab","aba",""}));
    }
}
