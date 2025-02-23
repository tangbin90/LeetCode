/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO119_PascalsTriangleII
 * Date: 2018/2/24 9:45
 * Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/24 9:45
 * @since 1.0.0
 * @description: 〈〉
 */
public class NO119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> li = new ArrayList<>(rowIndex+1);
        if(rowIndex<0)
            return li;
        li.add(1);
        for(int i=1;i<rowIndex+1;i++){
            li.add(0);
            for(int j=i;j>0;j--){
                li.set(j,li.get(j)+li.get(j-1));
            }
        }
        return li;
    }

    public static void main(String[] args) {
        NO119_PascalsTriangleII pascal = new NO119_PascalsTriangleII();
        List<Integer> aa = pascal.getRow(10);
        System.out.println(aa.toString());
    }
}
