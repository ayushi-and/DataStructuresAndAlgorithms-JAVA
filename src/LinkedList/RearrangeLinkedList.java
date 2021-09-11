package LinkedList;

/**
 * Rearrange a given linked list in-place.
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that
 * the nodes from the second half of the LinkedList are inserted alternately to the nodes from the
 * first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
 *
 */
//Time Complexity: O(n)
//Auxiliary Space: O(1)
public class RearrangeLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static void rearrangeList(Node head) {

        //find middle point
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Split the linked list in two halves
        //node1, head of first half    1 -> 2 -> 3
        //node2, head of second half   4 -> 5 -> 6
        Node node1 = head;
        Node node2 = slow.next;
        slow.next = null;

        //Reverse the second half, i.e., 6 -> 5 -> 4
        node2 = reverseList(node2);

        //Merge alternate nodes
        head = new Node(0);
        Node curr = head;
        while (node1 != null || node2 != null) {

            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            // Then add the element from second list
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        // Assign the head of the new list to head pointer since head was initialized with 0 value
        head = head.next;

    }

    static Node reverseList(Node node)
    {
        Node prev = null, curr = node, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    static void printList(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        printList(head);
        rearrangeList(head);
        printList(head);
    }
}
