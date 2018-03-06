/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO38_CountAndSay
 * Date: 2018/3/6 16:22
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/6 16:22
 * @since 1.0.0
 * @description: 〈
 *
 * 1.     1
2.     11
3.     21
4.     1211
5.     111221
 * 〉
 */
public class NO38_CountAndSay {
    public String countAndSay(int n) {
        String res="1";

        for(int i=1;i<n;i++){
            char temp=res.charAt(0);
            int count = 0;
            String tempRes="";
            for(int j=0;j<res.length();j++){
                if(res.charAt(j)==temp){
                    count++;
                }else{
                    tempRes = tempRes+String.valueOf(count)+temp;
                    temp=res.charAt(j);
                    count=1;
                }
            }
            res = tempRes+String.valueOf(count)+temp;
        }
        return res;
    }

    public static void main(String[] args) {
        NO38_CountAndSay countAndSay = new NO38_CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
    }
}
