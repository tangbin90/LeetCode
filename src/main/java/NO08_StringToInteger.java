/**
 * Created by TangBin on 22/03/2017.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical
 * digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters,
 no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values,
 INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class NO08_StringToInteger {
    private int myAtoi(String str){
        str = str.trim();
        int length = str.length();
        if(length==0)
            return 0;

        char[] carray = str.toCharArray();
        int result = 0;
        int i=0;
        boolean isPositive = true;
        if(carray[i]=='-') {
            isPositive = false;
            i+=1;
        }else if(carray[i]=='+'){
            i+=1;
        }

        while(i<str.length()){
            if(carray[i]>='0'&&carray[i]<='9'){
                int num = carray[i]-'0';

                if(result>(Integer.MAX_VALUE-num)/10)
                    return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
                result = result*10+num;
            }else{
                return isPositive?result:result*(-1);
            }
            i++;
        }
        return isPositive?result:result*(-1);
    }

    public static void main(String[] args){
        NO08_StringToInteger sti = new NO08_StringToInteger();
        System.out.println(sti.myAtoi("-2147483647"));
    }
}


