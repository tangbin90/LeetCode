package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 12/03/2018 3:45 PM
 */
public class NO67_AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int[] aInts = new int[a.length()];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<a.length();i++){
            aInts[i] = a.charAt(i)-'0';
        }

        int[] res = new int[Math.max(a.length(),b.length())+1];
        for(int i=b.length()-1;i>=0;i--){
            res[res.length+i-b.length()] = b.charAt(i)-'0';
        }
        for(int i=res.length-1;i>=0;i--){
            int temp;
            if(i+a.length()>=res.length)
                temp = res[i] + aInts[i+a.length()-res.length]+ carry;
            else
                temp = res[i]+carry;
            res[i] = temp%2;
            carry = temp/2;
        }
        int i = res[0]==0?1:0;
        for(;i<res.length;i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NO67_AddBinary addBinary = new NO67_AddBinary();
        System.out.println(addBinary.addBinary("11","1"));
    }
}
