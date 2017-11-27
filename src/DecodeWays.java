import java.util.concurrent.Delayed;

/**
 * @author TangBin
 * @version V1.0
 * @date 19/11/2017 2:53 PM
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if(s.isEmpty())
            return 0;

        int[] result = new int[s.length()];
        for(int i=0;i<s.length();i++)
            result[i] = 0;

        if(insideRange(s.substring(s.length()-1)))
             result[s.length()-1]=1;
        else
             result[s.length()-1]=0;

        if(s.length()==1)
            return result[0];

        if(insideRange(s.substring(s.length()-2))){
            result[s.length()-2]+=1;
        }

        if(insideRange(s.substring(s.length()-1))&&insideRange(s.substring(s.length()-2,s.length()-1))){
            result[s.length()-2]+=1;
        }

        if(s.length()>=3) {
            for (int i = s.length() - 3; i >= 0; i--) {
                if (insideRange(s.substring(i, i + 1)))
                    result[i] += result[i + 1];
                if (insideRange(s.substring(i, i + 2)))
                    result[i] += result[i + 2];
            }
        }
        return result[0];
    }

/*    public int numDecoding(String s, int start, int[] result){
        if(start==s.length()-1){
            if(insideRange(s.substring(start,s.length())))

                return 1;
            else
                return 0;
        }
        if(start==s.length())
            return 1;


        int fn=0;
        if(insideRange(s.substring(start,start+1))){
            fn = numDecoding(s,start+1);
        }

        int fn2=0;
        String sub = s.substring(start,start+2);
        if(insideRange(sub)){
            fn2 = numDecoding(s,start+2);
        }

        return fn+fn2;


    }*/

    public boolean insideRange(String str){
        if(str.length()==1){
            if(str.compareTo("1")<0){
                return false;
            }
        }
        if(str.length()==2){
            if(str.compareTo("10")<0||str.compareTo("27")>=0)
                return false;
        }
            return true;

    }

    public static void main(String... args){
        DecodeWays decodeWays = new DecodeWays();

        System.out.println(decodeWays.numDecodings("123123123121231231"));
    }
}
