package TestMixedQuestions;

/*
<4,5,6,7,1,2,3>
sorted rotated array
find the max element from this
 */
public class MaximumElementInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = {-1, -8, -5, -2};
        int left = 0;
        int right = arr.length - 1;

        System.out.println(maxElement(arr, left, right));
    }

    public static int maxElement(int[] arr, int left, int right) {

        if(left == right) {
            return arr[left];
        }

        int mid = left + (right - left) / 2;  //2

        if(arr[left] > arr[mid]) {
            return maxElement(arr, left, mid - 1);
        }

        else if(arr[mid] > arr[mid + 1]) {
            return arr[mid];
        }

        else {
            return maxElement(arr, mid + 1, right);
        }
    }
}
