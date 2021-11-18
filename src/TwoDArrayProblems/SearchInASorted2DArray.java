package TwoDArrayProblems;

//Given an integer ‘K’ and a row-wise sorted 2-D Matrix i.e. the matrix has the following properties:
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//The task is to find whether the integer ‘K’ is present in the matrix or not. If present then print ‘Found’ else print ‘Not found’.
//using binary search
public class SearchInASorted2DArray {

    static void search(int[][] arr, int row, int col, int searchKey) {

    }

    public static void main(String[] args) {
        int[][] arr = {{11, 12, 13, 14},
                       {21, 22, 23, 24},
                       {31, 32, 33, 34},
                       {41, 42, 43, 44}};

        search(arr, 4, 4, 32);
    }
}
