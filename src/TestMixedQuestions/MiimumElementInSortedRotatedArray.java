package TestMixedQuestions;

/*
[4,5,6,7,0,1,2]
Find the minimum element from an array
 */
public class MiimumElementInSortedRotatedArray {

    public static int minElement(int[] arr) {
        int beg = 0;
        int end = arr.length - 1;

        while(beg < end) {
            int mid = beg + (end - beg)/2;

            if(arr[beg] < arr[end]) {
                return arr[beg];
            }

            if(arr[end] < arr[mid])  {
                beg = mid + 1;
            }
            else {
                end = mid;
            }

        }

        return arr[beg];

    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(minElement(arr));

    }
}
