package TestMixedQuestions;

//2, 1, 0, 0, 1, 2, 2, 2

public class Sort012InArray {

    public static void sortNumbers(int[] arr) {
        int n = arr.length;

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                c1++;
            }
            else if(arr[i] == 1) {
                c2++;
            }
            else {
                c3++;
            }
        }

        int i = 0;
        while(c1 > 0) {
            arr[i] = 0;
            i++;
            c1--;
        }
        while(c2 > 0) {
            arr[i] = 1;
            i++;
            c2--;
        }
        while(c3 > 0) {
            arr[i] = 2;
            i++;
            c3--;
        }

        for(Integer val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 0, 1, 2, 2, 2};
        sortNumbers(arr);
    }
}
