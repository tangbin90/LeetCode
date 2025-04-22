package labula;

import entity.DoubleList;
import entity.Node;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;

    private DoubleList cache;

    private int cap;


    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public void makeRecently(int key){
        cache.remove(map.get(key));
        cache.addLast(map.get(key));
    }

    public void addRecently(int key, int val){
        Node n = new Node(key, val);
        cache.addLast(new Node(key, val));
        map.put(key, n);
    }

    private void add(int key, int val){
        if(map.containsKey(key)){
            Node node = map.get(key);
            cache.remove(node);
            map.remove(key);
        }

        if(cache.size == cap){
            Node node = cache.removeFirst();
            map.remove(node.key);
        }

        addRecently(key, val);
    }

    private int get(int key){
        if(!map.containsKey(key))
            return -1;
        makeRecently(key);
        return map.get(key).val;
    }
}
