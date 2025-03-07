package entity;

public class DoubleList {
    public int size = 0;
    private Node head;

    private Node tail;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.previous = head;
        size = 0;
    }

    public void addLast(Node x){
        tail.next = x;
        x.previous = tail.previous;
        tail.previous.next = x;
        tail = x;
        size ++;
    }

    public void remove(Node x){
        if(size == 0)
            return;

        x.previous.next = x.next;
        x.next.previous = x.previous;
    }

    public Node removeFirst(){
        if(head.next==tail)
            return null;

        Node first = head.next;
        remove(first);
        return first;
    }
}
