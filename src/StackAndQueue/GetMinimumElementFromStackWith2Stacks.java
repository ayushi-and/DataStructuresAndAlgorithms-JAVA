package StackAndQueue;

import java.util.Stack;

//Find the Minimum Element in a Stack
//TC: O(1)
//SC: O(n)
public class GetMinimumElementFromStackWith2Stacks {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    void push(int data) { //4 5 8 1
        int minValue = data;

        if(!minStack.isEmpty() && minValue > minStack.peek()) {
            minValue = minStack.pop();
        }

        stack.push(data);
        minStack.push(minValue);
    }

    void pop() {
        stack.pop();
        minStack.pop();
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinimumElementFromStackWith2Stacks minEle = new GetMinimumElementFromStackWith2Stacks();

        minEle.push(4);
        minEle.push(5);
        minEle.push(8);
        minEle.push(1);

        System.out.println("Minimum Element from Stack : " + minEle.getMin());

        minEle.pop();

        System.out.println("Minimum Element from Stack after Pop : " + minEle.getMin());
        System.out.println("Top Element : " + minEle.top());

    }
}
