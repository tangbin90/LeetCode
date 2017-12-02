/**
 * @author TangBin
 * @version V1.0
 * @date 05/04/2017 3:52 PM
 */
public class IntegerToRoman {
    public final String[] M={"","M","MM","MMM"};
    public final String[] C={"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    public final String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public final String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public String intToRoman(int num) {
        return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[(num%10)];
    }


    public static void main(String[] args){
        IntegerToRoman iToR=new IntegerToRoman();
        System.out.println(iToR.intToRoman(12));
    }
}
