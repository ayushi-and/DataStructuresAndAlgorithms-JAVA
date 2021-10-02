package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

//Count of days remaining for the next day with higher temperature
//Given a list arr[] of everyday temperatures. For each day, the task is to find the count of days remaining for the next day with warmer temperatures.
//If there is no such day for which warmer temperature is possible then print -1.
/*
Examples:
Input: arr[] = {73, 74, 75, 71, 69, 72, 76, 73}
Output: {1, 1, 4, 2, 1, 1, -1, -1}
Explanation:
For 73 temperature, next warmer temperature is 74 which at a distance 1
For 74 temperature, next warmer temperature is 75 which at a distance 1
For 75 temperature, next warmer temperature is 76 which at a distance 4
For 71 temperature, next warmer temperature is 72 which at a distance 2
For 69 temperature, next warmer temperature is 72 which at a distance 1
For 72 temperature, next warmer temperature is 76 which at a distance 1
For 76 temperature, there is no valid next warmer day
For 73 temperature, there is no valid next warmer day
Input: arr[] = {75, 74, 73, 72}
Output: {-1, -1, -1, -1}
 */

//Time Complexity: O(N)
//Auxiliary Space: O(N)
public class CountOfDaysWithNextHigherTemp {

    static void dailyTemp(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result,-1);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(" "  + result[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] arr2 = {75, 74, 73, 72};
        dailyTemp(arr1);
        System.out.println();
        dailyTemp(arr2);
    }
}
