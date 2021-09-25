package testDemo;

//Find 5 in the array
//7, 5, 3, 2, 1
//Binary Search
public class sortTest {

    //7, 5, 3, 2, 1
    int sort(int[] arr) {
        int beg = arr.length - 1;
        int end = 0;

        while(end < beg) {
            int mid = (beg + end)/2;

            if(arr[mid] == 5) {
                return mid;
            }
            else if(arr[mid] > 5) {
                end = mid + 1;
            }
            else {
                beg = mid - 1;
            }
        }
        return 0;
    }

    //end = 2, beg = 4
    //end =

}
