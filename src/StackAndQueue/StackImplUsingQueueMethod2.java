package StackAndQueue;

//Implement Stack using Queues
//We are given a Queue data structure that supports standard operations like enqueue() and dequeue().
//We need to implement a Stack data structure using only instances of Queue and queue operations allowed on the instances.
//A stack can be implemented using two queues.

import java.util.LinkedList;
import java.util.Queue;

//Method 1 (By making pop operation costly)
public class StackImplUsingQueueMethod2 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int key) {
        queue1.add(key);
    }

    int pop() {
        if(queue1.isEmpty()) {
            return -1;
        }

        while(queue1.size() != 1) {
            queue2.add(queue1.remove());
        }

        int temp = queue1.remove();

        Queue queue = queue1;
        queue1 = queue2;
        queue2 = queue;

        return temp;
    }

    public static void main(String[] args) {
        StackImplUsingQueueMethod2 s = new StackImplUsingQueueMethod2();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
