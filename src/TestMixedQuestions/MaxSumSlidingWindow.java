package TestMixedQuestions;

//Window Sliding Technique Basic
//Given an array of integers of size ‘n’.
//Our aim is to calculate the maximum sum of ‘k’
//consecutive elements in the array.
//Input  : arr[] = {100, 200, 300, 400}
//         k = 2
//Output : 700
//window size is end-beg+1 always
//Fixed size sliding window

//Brute Force
/*public class MaxSumSlidingWindow {

    static int maxSum(int arr[], int n, int k){
        int max_sum = Integer.MIN_VALUE;

        for(int i = 0; i < n-k+1; i++){
            int current_sum = 0;
            for(int j = 0; j < k; j++){
                current_sum += arr[i + j];
            }
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }

    public static void main(String[] args){
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        System.out.println(maxSum(arr, arr.length, 4));
    }
}*/


//Optimized : Using Sliding Window Technique -> O(n)

/*
public class MaxSumSlidingWindow {

    static int maxSum(int arr[], int n, int k){

        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        int max_sum = 0;
        for(int i = 0; i < k; i++){
            max_sum += arr[i];
        }

        int window_sum = max_sum;
        for(int i = k; i < n; i++){
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    public static void main(String[] args){
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        System.out.println(maxSum(arr, arr.length, 4));
    }
}*/



//Optimized : Sliding window -> Second way
//Fixed size sliding window

public class MaxSumSlidingWindow {

    static int maxSum(int arr[], int n, int k){

        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        int beg = 0;
        int end = 0;
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;

        while(end < n){
           sum += arr[end];

           if(end - beg + 1 < k){ //window size is end-beg+1 always
               end++;
           }
           else if(end - beg + 1 == k){
               max_sum = Math.max(sum, max_sum);
               sum = sum - arr[beg];
               beg++;
               end++;
           }
        }

        return max_sum;
    }

    public static void main(String[] args){
        int arr[] = { 100, 200, 300, 400};
        System.out.println(maxSum(arr, arr.length, 2));
    }
}