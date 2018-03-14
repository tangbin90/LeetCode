/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO71_SimplifyPath
 * Date: 2018/3/14 16:55
 * Description:
 */

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/14 16:55
 * @since 1.0.0
 * @description: 〈Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"〉
 */
public class NO71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str : strs){
            if(str.equals("..")&&!stack.isEmpty())
                stack.pop();
            else {
                if (!str.equals("..")&&!str.equals(".") && !str.isEmpty())
                    stack.push(str);
            }
        }
        StringBuilder res = new StringBuilder();
        for(String strPath : stack){
            res.append("/");
            res.append(strPath);
        }
        return res.toString().isEmpty()?"/":res.toString();
    }

    public static void main(String[] args){
        NO71_SimplifyPath simplifyPath = new NO71_SimplifyPath();
        System.out.println( simplifyPath.simplifyPath("/.."));
    }
}
