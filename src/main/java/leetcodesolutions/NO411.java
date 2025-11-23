package leetcodesolutions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NO411 {
    PriorityQueue<String> abbre;
    public String minAbbreviation(String target, String[] dictionary) {
        abbre = new PriorityQueue<>((a, b) -> a.length() - b.length());
        Set<String> dicSet = new HashSet<>();
        for(String str : dictionary){
            if(str.length() == target.length() && str.compareTo(target) != 0){
                dicSet.add(str);
            }
        }

        if(dicSet.isEmpty()){
            return String.valueOf(target.length());
        }

        findAbbreviation(target, new StringBuilder(), 0, 0);
        String p = "";
        while(!abbre.isEmpty()){
            p = abbre.poll();
            boolean allnotMath = true;
            for(String str : dictionary){
                if(isMatch(str, p)){
                    allnotMath = false;
                    break;
                } else {
                    continue;
                }
            }
            if(allnotMath){
                return p;
            }
        }

        return p;
    }

    public void findAbbreviation(String target, StringBuilder curr, int pos, int skipped){
        //1x1x1x1x1x1x1x1x
        if(pos == target.length()){
            if(skipped == 0)
                abbre.add(curr.toString());
            else
                abbre.add(curr.append(skipped).toString());
            return;
        }

        String ss= curr.toString();
        //choose pos as char
        StringBuilder tmp = new StringBuilder(ss);
        if(skipped > 0){
            tmp.append(target);
        }
        findAbbreviation(target, tmp.append(target.charAt(pos)) , pos + 1, 0);
        tmp = new StringBuilder(curr.toString());
        //choose pos as num
        findAbbreviation(target, tmp, pos + 1, skipped + 1);

    }

    public boolean isMatch(String str, String p){
        int spos = 0;
        int ppos = 0;
        while(ppos < p.length()){
            if(Character.isAlphabetic(p.charAt(ppos))){
                if(str.charAt(spos) == p.charAt(ppos)){
                    spos++;
                    ppos++;
                } else {
                    return false;
                }
            }
            int num = 0;
            while(ppos < p.length() && Character.isDigit(p.charAt(ppos))){
                num = num * 10 + p.charAt(ppos) - '0';
                ppos++;
            }
            spos = spos + num;
        }
        return spos == str.length() && ppos == p.length();
    }

    public static void main(String[] args) {
        NO411 no411 = new NO411();
        String target = "abcdef";
        String[] dictionary = {"ablade","xxxxef","abdefi"};
        System.out.println(no411.minAbbreviation(target, dictionary));
    }
}
