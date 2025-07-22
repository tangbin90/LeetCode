package leetcodesolutions;

public class NO201 {
    public int rangeBitwiseAnd(int left, int right) {
        int result = left;

        for(int i=left+1; i <= right; i++){
            result = result & i;
            if(result == 0)
                return 0;
        }

        return result;
    }

    public String shortestPalindrome(String s) {
        String revStr = new StringBuilder(s).reverse().toString();

        for(int i=s.length(); i >=0; i--){
            if(s.substring(0, i).equals(revStr.substring(s.length()-i, s.length())))
                return revStr.substring(0, s.length() - i) +s;
        }

        return revStr+s;
    }

    public static void main(String[] args) {
        NO201 no201 = new NO201();
        System.out.println(no201.shortestPalindrome("aacecaaa")); // Output: 4

    }

}
