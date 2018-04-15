/**
 * @author TangBin
 * @version V1.0
 * @date 2018/4/14 10:44 AM
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


 */
public class NO132_PalindromePartitioningII {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] palindrome = new boolean[length][length]; //isPalindr[i][j] = true means s[i:j) is a valid palindrome
        int[] results = new int[length];
        //Start looping
        for (int start=length-1;start>=0;start--){
            results[start]=length-start-1;//Worst case:need length-start-i cuts
            for (int end=start;end<length;end++){
                if (s.charAt(start)==s.charAt(end)){
                    if (end-start<2)//Refer to these two cases: xx OR xyx
                        palindrome[start][end]=true;
                    else //Depends on the inner substring,if the inner substring is palindrome,the outer is
                        palindrome[start][end]=palindrome[start+1][end-1];
                }
                if (palindrome[start][end])
                    if (end==length-1)
                        results[start]=0;
                    else
                        results[start]=Math.min(results[start],results[end+1]+1);
            }
        }
        return results[0];
    }

    public static void main(String[] args) {
        NO132_PalindromePartitioningII palindromePartitioningII = new NO132_PalindromePartitioningII();
        palindromePartitioningII.minCut("aabb");
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
