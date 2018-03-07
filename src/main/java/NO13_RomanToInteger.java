/**
 * @author TangBin
 * @version V1.0
 * @date 10/04/2017 9:19 AM
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question.
 */
public class NO13_RomanToInteger {
    public final String[] M={"","M","MM","MMM"};
    public final String[] C={"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    public final String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public final String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static int romanToInt(String s) {
        int result=0;
        for(int i=s.length()-1;i>=0;i--){
            switch (s.charAt(i)){
                case 'I':result+=result>=5?-1:1;
                    break;
                case 'V':result+=5;
                    break;
                case 'X':result+=result>=50?-10:10;
                    break;
                case 'L':result+=50;
                    break;
                case 'C':result+=result>=500?-100:100;
                    break;
                case 'D':result+=500;
                    break;
                case 'M':result+=1000;
                    break;
                default:result+=0;
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(NO13_RomanToInteger.romanToInt("MCMXCIV"));
    }
}
