package leetcodesolutions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 20/03/2018 10:23 AM
 */
public class NO89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> li = new LinkedList<>();
        li.add(0);
        if(n==0)
            return li;
        for(int i=0;i<n;i++){
            int length = li.size();
            for (int j = length-1; j >=0 ; j--)
                li.add(li.get(j) + (1 << i));
        }
        return li;
    }

    public static void main(String[] args){
        NO89_GrayCode grayCode = new NO89_GrayCode();
        List<Integer> li = grayCode.grayCode(3);
        System.out.println(li.toString());
    }
}
