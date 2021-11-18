package TestMixedQuestions;

import java.util.Arrays;

//Sort 2D array row wise and col wise.
//Time Complexity:O(n2log2n)
//Auxiliary Space: O(1)
public class SortTheMatrix {

    static void sort(int[][] arr) {
        sortRowWise(arr);
        transpose(arr);
        sortRowWise(arr);
        transpose(arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void sortRowWise(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
        }
    }

    private static void transpose(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }


    //Time Complexity:O(n*m)
    //Auxiliary Space: O(n*m)
    static void sortOptimized(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int index = 0;
        int[] elements = new int[rows * cols];

        for(int[] row : arr) {
            for(int j = 0; j < cols; j++) {
                elements[index] = row[j];
                index++;
            }
        }

        Arrays.sort(elements);

        index = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                arr[i][j] = elements[index];
                index++;
            }
        }


        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }



    //Performance Analysis:
    //* Time Complexity:In the given approach, we are sorting the elements in the matrix by considering the elements in the 1D-Array using Bubble sort, so the overall complexity will beO(N * M>)
    //* Space Complexity:In the given approach, no extra space is used, so the overall space complexity will beO(1)


    public static void main(String[] ar) {
        int[][] arr = {  {5, 4, 7},
                         {1, 3, 8},
                         {2, 9, 6}
                      };
        sort(arr);
        System.out.println();
        sortOptimized(arr);
    }
}
