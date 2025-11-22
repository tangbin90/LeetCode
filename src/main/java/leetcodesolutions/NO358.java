package leetcodesolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NO358 {
    public String rearrangeString(String s, int k) {
        //s = "abacadfa"
        // abcdabcda
        // a.b.a.b.a
        //贪心算法， 平均分配剩余的slot
        char[] chs = s.toCharArray();
        Map<Character, Integer> chnum = new HashMap<>();
        for(char ch : chs){
            chnum.put(ch, 1 + chnum.getOrDefault(ch, 0));
        }

        PriorityQueue<CHNum> queue = new PriorityQueue<>((a, b) -> b.getNum() - a.getNum());
        for(Character key : chnum.keySet()){
            CHNum chn = new CHNum(key, chnum.get(key));
            queue.add(chn);
        }

        int slotNumber = s.length();
        boolean[] occupied = new boolean[slotNumber];
        char[] rslt = new char[s.length()];

        while(!queue.isEmpty()){
            CHNum cNum = queue.poll();
            char ch = cNum.getCH();
            int num = cNum.getNum();

            int distance = slotNumber / num;
            if(distance < k){
                distance = k;
            }
            slotNumber = slotNumber - num;
            int i = 0;
            int pre = -1;
            int currPos = 0;
            while(currPos < s.length() && rslt[currPos] != 0){
                currPos++;
            }
            while(i < num){
                currPos = currPos + i * distance;
                while(currPos < s.length() && rslt[currPos] != 0){
                    currPos++;
                }
                if(pre == -1 && currPos < s.length()){
                    pre = currPos;
                    rslt[currPos] = ch;
                    i++;
                    continue;

                }

                if(currPos - pre < k || currPos == s.length()){
                    return "";
                }
                if(currPos >= s.length()){
                    currPos = pre + k;
                    while(currPos < s.length() && rslt[currPos] != 0){
                        currPos++;
                    }
                    if(currPos == s.length()){
                        return "";
                    }
                }
                pre = currPos;
                rslt[currPos] = ch;
                i++;

            }


        }

        return new String(rslt);

    }

    public static void main(String[] args) {
        NO358 no358 = new NO358();
        String s = "abacabcd";
        int k = 2;
        String rslt = no358.rearrangeString(s, k);
        System.out.println(rslt);

    }

    class CHNum implements Comparable<CHNum>{
        private Character ch;
        private int num;
        public CHNum(char ch, int num){
            this.ch = ch;
            this.num = num;
        }
        public Character getCH(){
            return ch;
        }

        public int getNum(){
            return num;
        }

        @Override
        public int compareTo(CHNum other) {
            return this.num - other.num;
        }

        @Override
        public String toString(){
            return ch + " " + num + "times";
        }

    }


}
