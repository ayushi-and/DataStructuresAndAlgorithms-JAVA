package TestMixedQuestions;

/*
Given an array arr[0 .. n-1] of distinct integers, the task is to find a local minimum in it. We say that an element arr[x] is a local minimum if it is less than both its neighbors.

For corner elements, we need to consider only one neighbor for comparison.
There can be more than one local minima in an array, we need to find one of them.

2 3 4 1 6

 */
public class LocalMinima {

    public static void main(String args[]) {
        int[] ar = {7, 6, 5, 4, 3};
        System.out.println(findLocalMinima(ar, 0, ar.length - 1));
    }

    public static int findLocalMinima(int[] arr, int left, int right) { //2, 3, 4 ,1, 6
        if(left > right) {

        }
        int mid = left+(right-left)/2;

        if(mid == 0 || arr[mid] < arr[mid - 1] && mid == arr.length - 1 || arr[mid] < arr[mid + 1]) {
            return arr[mid];
        }
        else if(mid > 0 && arr[mid] > arr[mid - 1]) { //2, 3
            return findLocalMinima(arr, left, mid - 1);
        }

        return findLocalMinima(arr, mid + 1, right); //3, 4
    }
}
