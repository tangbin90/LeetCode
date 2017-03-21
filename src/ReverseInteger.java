import static java.lang.Math.abs;

/**
 * Created by TangBin on 21/03/2017.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int pos=0;

        Boolean isPositive = true;
        if(x<0) {
            isPositive = false;
            x = abs(x);
        }
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
        if(!isPositive)
            reverse*=-1;
        return reverse;
    }

    
    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1534236469));
    }
}
