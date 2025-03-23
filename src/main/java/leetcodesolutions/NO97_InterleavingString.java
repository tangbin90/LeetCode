package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 22/03/2018 4:44 PM
 */
public class NO97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();
        char[] charS3 = s3.toCharArray();
        boolean[][] mem = new boolean[s2.length()+1][s1.length()+1];
        mem[0][0] = true;
        for(int i=1;i<=s2.length();i++){
            mem[i][0] = mem[i-1][0]&&(charS3[i-1]==charS2[i-1]);
        }
        for(int i=1;i<=s1.length();i++){
            mem[0][i] = mem[0][i-1]&&(charS3[i-1]==charS1[i-1]);
        }

        for(int i= 1; i<=s2.length();i++)
            for(int j = 1;j<=s1.length();j++){
                mem[i][j] = (charS1[j-1]==charS3[i+j-1]&&mem[i][j-1])||(charS2[i-1]==charS3[i+j-1]&&mem[i-1][j]);
            }
        return mem[s2.length()][s1.length()];
    }



    public static void main(String[] args){
        NO97_InterleavingString interleavingString = new NO97_InterleavingString();
        System.out.println( interleavingString.isInterleave("ab","bc","bcab"));
    }
}
