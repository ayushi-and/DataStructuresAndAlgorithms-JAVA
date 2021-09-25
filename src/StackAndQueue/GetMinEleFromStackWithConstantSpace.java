package StackAndQueue;

import java.util.Stack;

//Find the Minimum Element in a Stack
//TC: O(1)
//SC: O(1)
public class GetMinEleFromStackWithConstantSpace {
    Stack<Integer> stack = new Stack<>();
    int min;

    void push(int data) { //4 5 8 1
        if(stack.isEmpty()) {
            min = data;
            stack.push(data);
            return;
        }
        if(data < min) {
            stack.push(2 * data - min);
            min = data;
        }
        else {
            stack.push(data);
        }
    }

    void getMin() {
        if(stack.isEmpty()) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("Minimum element : " + min);
        }
    }

    void pop() { //4 5 8 1
        if (stack.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Popped element : ");
        int data = stack.pop();

        if(data < min) {
            System.out.println(min);
            min = 2 * min - data;
        }
        else{
            System.out.println(data);
        }
    }

    public static void main(String[] args){
        GetMinEleFromStackWithConstantSpace s = new GetMinEleFromStackWithConstantSpace();

        s.push(30);
        s.push(20);
        s.push(10);
        s.getMin();
        s.pop();
        s.getMin();

    }
}
