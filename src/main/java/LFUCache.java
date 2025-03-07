import java.util.*;

public class LFUCache {
    HashMap<Integer, Integer> keyVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    int cap;
    int minFreq;

    public LFUCache(int capacity){
        this.cap = capacity;

    }

    public Integer get(int key){
        if(!keyVal.containsKey(key))
            return null;
        increaseFrequency(key);
        return keyVal.get(key);
    }

    public void put(int key, int val){
        if(this.cap <= 0) return;

        if(keyToFreq.containsKey(key)){
            keyVal.put(key, val);
            increaseFrequency(key);
            return;
        }

        if(this.cap <= keyVal.size()){
            removeMinFreqKey();
        }

        keyVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        this.minFreq = 1;
    }

    public void removeMinFreqKey(){
        LinkedHashSet<Integer> keys =  freqToKeys.get(this.minFreq);
        int deleteKey = keys.iterator().next();
        freqToKeys.remove(deleteKey);
        if(keys.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        keyToFreq.remove(deleteKey);
        keyVal.remove(deleteKey);


    }

    public void increaseFrequency(int key) {
        int tmp = keyToFreq.get(key);
        keyToFreq.put(key, tmp+1);
        Set<Integer> keys = freqToKeys.get(tmp);
        keys.remove(key);
        if(freqToKeys.containsKey(tmp+1)) {
           keys = freqToKeys.get(key);
           keys.add(key);
        } else {
            Set<Integer> tkeys = new HashSet<>();
            keys.add(key);
            freqToKeys.put(tmp+1, tkeys);
        }





    }


}
