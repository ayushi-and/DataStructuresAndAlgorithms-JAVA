package LinkedList;

//Sorting the nodes of a Singly Linked list in ascending order
//Time complexity: O(n log n)
//Space complexity: O(1)
public class SortALinkedListMergeSort {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node sortList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddleNode(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = sortList(head);
        Node right = sortList(nextOfMiddle);

        Node sortedList = merge(left, right);

        return sortedList;
    }

    static Node merge(Node left, Node right) {
        Node result = null;

        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        if(left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        }
        else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    static Node getMiddleNode(Node head) {

        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    static void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(3);
        head.next.next = new Node(13);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(33);
        head.next.next.next.next.next = new Node(13);
        head.next.next.next.next.next.next = new Node(1);

        printList(head);
        Node result = sortList(head);
        System.out.println();
        printList(result);
    }
}
