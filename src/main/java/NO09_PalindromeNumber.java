/**
 * @author TangBin
 * @date 22/03/2017 3:45 PM
 * @version V1.0
 */
public class NO09_PalindromeNumber {
    public boolean isPalindrome(int x) {
        return x >= 0 && x == reversenum(x);
    }

    @SuppressWarnings("Duplicates")
    private int reversenum(int x) {
        int pos=0;

        int temp = x;
        while(temp>0){
            temp=temp/10;
            pos++;
        }
        int reverse=0;
        for(int i=0;i<pos;i++){
            if(i==pos-1){
                if(reverse>(Integer.MAX_VALUE-x%10)/10)
                    return 0;
            }
            reverse=reverse*10+x%10;
            x=x/10;
        }
        return reverse;
    }

    public static void main(String[] args){
        NO09_PalindromeNumber pn = new NO09_PalindromeNumber();
        System.out.println(pn.isPalindrome(121));
    }
}
