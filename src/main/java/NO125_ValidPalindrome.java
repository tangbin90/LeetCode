/**
 * @author TangBin
 * @version V1.0
 * @date 26/03/2018 4:13 PM
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.


 */
public class NO125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0)
            return true;
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(!Character.isLetterOrDigit(s.charAt(start)))
                start++;
            else if(!Character.isLetterOrDigit(s.charAt(end)))
                end--;
            else if(Character.toLowerCase(s.charAt(start))==Character.toLowerCase(s.charAt(end))) {
                start++;
                end--;
            }else
                return false;
        }

        return true;
    }
}
