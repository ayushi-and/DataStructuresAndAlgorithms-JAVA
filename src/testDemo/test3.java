package testDemo;


import LinkedList.ReverseOfLinkedList;

/*
function palindrome(head){

    if(!head) return head

    let current = head
    let listToBeReversed = head
    let reverseLinkedlist = reverse(listToBeReversed)

    while(current !== null){
        if(current.value !== reverseLinkedlist.value){
            return false
        }else {
            current = current.next
            reverseLinkedlist = reverseLinkedlist.next
        }
    }

    return true

}

function reverse(list){
    let prev = null
    let current = list

    while(current !== null){
        next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev
}
 */
public class test3 {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static boolean palindromeCheck(Node head) {
        Node current = head;
        Node reversedList = getReverse(current);
        Node reverse = reversedList;

        while(head != null) {
            if(head.data != reverse.data) {
                return false;
            }
            else {
                System.out.print(current.data + " " + reverse.data);
                current = current.next;
                reverse = reverse.next;
            }
        }
        return true;

    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    static Node getReverse(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        boolean check = palindromeCheck(head);
        printList(head);
        if(check == true) {
            System.out.print("Palindrome!");
        }
        else {
            System.out.print("Not a palindrome!");
        }

    }

}
