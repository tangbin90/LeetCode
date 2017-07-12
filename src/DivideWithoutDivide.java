/**
 * Created by tangbin1 on 2017/7/5.
 */
public class DivideWithoutDivide {
    public int divide(int dividend, int divisor) {
        boolean isNegative=(dividend<0)^(divisor<0);
        if(divisor==0||(dividend == Integer.MIN_VALUE && divisor == -1))
         return Integer.MAX_VALUE;
        long diviendl = Math.abs((long)dividend);
        long divisorl = Math.abs((long)divisor);

        long divresult =0;
        long divisorleftshift = divisorl;
        int divresulttemp=1;

        while(diviendl>=divisorl){
            long temp = divisorleftshift<<1;
            if(temp<=diviendl){
                divresulttemp<<=1;
                divisorleftshift=temp;
            }else{
                diviendl = diviendl-divisorleftshift;
                divresult += divresulttemp;
                divresulttemp=1;
                divisorleftshift=divisorl;
            }
        }

        return isNegative==true?(int)divresult*-1:(int)divresult;
    }

    public static void main(String[] args){
        DivideWithoutDivide divideWithoutDivide = new DivideWithoutDivide();
        System.out.println(divideWithoutDivide.divide(-1010369383
                ,-2147483648));
    }
}
