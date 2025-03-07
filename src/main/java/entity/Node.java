package entity;

public class Node {
    public int key;
    public int val;

    public Node next;
    public Node previous;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
