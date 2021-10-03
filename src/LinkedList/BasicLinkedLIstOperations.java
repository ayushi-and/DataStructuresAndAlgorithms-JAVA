package LinkedList;

public class BasicLinkedLIstOperations {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static void insert(int key) {
        if(head == null) {
            head = new Node(key);
            return;
        }

        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = new Node(key);
    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    static void delete(int key) {
        if(head == null) {
            return;
        }
        if(head.data == key) {
            head = head.next;
        }

        Node current = head;
        Node prev = null;
        while(current != null && current.data != key) {
            prev = current;
            current = current.next;
        }
        if(current != null) {
            prev.next = current.next;
        }

    }


    public static void main(String[] args) {
        insert(1);
        printList(head);
        insert(2);
        insert(3);
        printList(head);
        insert(4);
        insert(5);



        delete(2);

        System.out.println();
        printList(head);
    }
}
