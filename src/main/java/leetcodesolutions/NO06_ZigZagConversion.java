package leetcodesolutions;

/**
 * Created by TangBin on 21/03/2017.
 *
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 Subscribe to see which companies asked this question.
 */

public class NO06_ZigZagConversion {
    @SuppressWarnings("WeakerAccess")
    public String convert(String s, int numRows) {

        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i=0;i<sb.length;i++) sb[i]=new StringBuffer();

        int i=0;
        while(i<s.length()){
            for(int index = 0;index<numRows&&i<s.length();index++)
                sb[index].append(s.charAt(i++));
            for(int index=numRows-2;index>0&&i<s.length();index--)
                sb[index].append(s.charAt(i++));
        }
        String result = "";
        for (int m=0;m<numRows;m++ ) {
            result+=sb[m]+"\n";
        }
        return result;
    }

    public static void main(String[] args){
        NO06_ZigZagConversion zig = new NO06_ZigZagConversion();
        System.out.println(zig.convert("tangbingogo",18));
    }
}
