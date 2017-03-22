import static java.lang.Math.abs;

/**
 * Created by TangBin on 22/03/2017.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        return x==reversenum(x)?true:false;
    }

    public int reversenum(int x) {
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
}
