import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 21/03/2018 4:26 PM
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class NO93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();

        if(s.length()>12)
            return res;
        restoreIpAddressesDP(s, res, "",0,0);
        return res;
    }

    public void restoreIpAddressesDP(String s, List<String> res, String str, int pos, int count){
        if(count==4&& pos == s.length())
            res.add(str);

        for (int i=1; i<4; i++) {
            if (pos+i > s.length()) break;
            String subStr = s.substring(pos,pos+i);
            if ((subStr.startsWith("0") && subStr.length()>1) || (i==3 && Integer.parseInt(subStr) >= 256)) continue;
            restoreIpAddressesDP(s, res, str+subStr+(count==3?"" : "."), pos+i,count+1);
        }
    }

    public static void main(String[] args) {
        NO93_RestoreIPAddresses restoreIPAddresses = new NO93_RestoreIPAddresses();
        restoreIPAddresses.restoreIpAddresses("0000");
    }
}
