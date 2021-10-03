package TestMixedQuestions;

public class ReverseArray {
    static void reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        int j = arr.length;
        for(int i = 0; i < arr.length; i++) {
            result[j-1] = arr[i];
            j--;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static void reverseArrayInplace(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        reverseArray(ar);
        reverseArrayInplace(ar);
    }
}
