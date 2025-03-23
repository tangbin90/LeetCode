package leetcodesolutions;

import java.util.LinkedHashMap;

public class NO146LRUCache {
    private LinkedHashMap<Integer, Integer> hashMap;

    private int cap;
    public NO146LRUCache(int capacity) {
        cap = capacity;
        hashMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(!hashMap.containsKey(key))
            return -1;
        makeRecently(key);
        return hashMap.get(key);
    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            hashMap.put(key, value);
            makeRecently(key);
            return;
        }

        if(hashMap.size() >= cap){ // Corrected condition
            int oldest = hashMap.keySet().iterator().next();
            hashMap.remove(oldest);
        }

        hashMap.put(key,value);
    }

    public void makeRecently(int key){
        int val = hashMap.get(key);
        hashMap.remove(key);
        hashMap.put(key, val);
    }

    public static void main(String[] args) {
        NO146LRUCache cache = new NO146LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
