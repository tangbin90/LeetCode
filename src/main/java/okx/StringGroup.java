package okx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringGroup {
    public static List<List<String>> groupByUniqueChars(List<String> arr) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('a' <= c && c <= 'z') {
                    mask |= 1 << (c - 'a');
                } else {
                    // 如需严格限制，仅小写字母；否则可改用通用版
                    // 这里也可以直接 fallback 到通用方法
                }
            }
            map.computeIfAbsent(mask, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("cbc");
        arr.add("cbb");


        List<List<String>> grouped = groupByUniqueChars(arr);
        for (List<String> group : grouped) {
            System.out.println(group);
        }
    }
}
