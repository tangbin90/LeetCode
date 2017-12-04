/**
 * @author TangBin
 * @version V1.0
 * @date 04/12/2017 10:53 PM
 */
public class NO66_PlusOne {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int temp = digits[i];
            digits[i]=(carry+temp)%10;
            carry=(temp+carry)/10;
        }

        if(carry==1){
            int[] result = new int[digits.length+1];
            result[0]=carry;
            for(int i=1;i<result.length;i++)
                result[i]=digits[i-1];
            return result;
        }
        return digits;
    }

    public int[] plusOneII(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        NO66_PlusOne plusOne = new NO66_PlusOne();
        plusOne.plusOne(new int[]{9});
    }
}
