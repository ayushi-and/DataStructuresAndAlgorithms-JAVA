package TestMixedQuestions;

import java.util.HashMap;
import java.util.Map;

/*
The LRU caching scheme is to remove the least recently used frame when the cache is full
Size 4
1, 2, ,3 ,1, 4 ,5

1  -->
2 , 1
3 , 2 , 1
1 , 3, 2
4 ,1 , 3 , 2
5 ,4 ,1 ,3

Implement custom object for data structure planning to use

put(int input)
display()
 */
public class LRUCacheImpl {


    static class Node {
        int key;
        Node next;
        Node prev;

        Node(int key) {
            this.key = key;
        }
    }


    private int size;

    private Map<Integer, Node> map = new HashMap<>();

    Node head = null;

    Node last = null;

    public LRUCacheImpl(int size) {
        this.size = size;

        //head.next = last;
        //last.prev = head;
    }

    public void put(int input) {
        Node node = new Node(input);

        if(map.containsKey(input)) {
            Node nodeToRemove = map.get(input);
            map.remove(nodeToRemove.key);
            remove(nodeToRemove);
            insert(node);
        }

        else if(map.size() == size) {
            map.remove(last.key);
            remove(last);
            insert(node);
        }

        else {
            insert(node);
        }
        map.put(input, node);
    }


    public void insert(Node node) { //1
        if(head == null) {
            head = node;
            last = node;
            return;
        }

        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;


    }

    public void remove(Node node) {

        if(node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            head = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        else {
            last = node.prev;
        }

    }

    public void display() {
        Node current = head;

        while(current != null){
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        LRUCacheImpl lruCache = new LRUCacheImpl(4);

        lruCache.put(1);
        lruCache.display();
        lruCache.put(2);
        lruCache.display();
        lruCache.put(3);
        lruCache.display();
        lruCache.put(1);
        lruCache.display();
        lruCache.put(4);
        lruCache.display();
        lruCache.put(5);
        lruCache.display();







    }



}
