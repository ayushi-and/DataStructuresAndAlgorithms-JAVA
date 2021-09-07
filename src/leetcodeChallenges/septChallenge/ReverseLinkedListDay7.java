package leetcodeChallenges.septChallenge;

import LinkedList.ReverseOfLinkedList;

public class ReverseLinkedListDay7 {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node tnode = head;
        while(tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node currNode = head;
        Node next = null;
        while(currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        ReverseLinkedListDay7 list = new ReverseLinkedListDay7();
        list.push(10);
        list.push(11);
        list.push(30);
        list.push(20);
        list.push(12);
        list.push(5);

        list.printList();
        list.reverse();
        System.out.println();
        list.printList();
    }
}
