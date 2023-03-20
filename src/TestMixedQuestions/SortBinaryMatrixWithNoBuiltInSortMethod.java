package TestMixedQuestions;


public class SortBinaryMatrixWithNoBuiltInSortMethod {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0},
                {0, 0, 1},
                {1, 0, 0}};

        sortMatrix(arr);
    }

    public static void sortMatrix(int[][] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n - j - 1; k ++) {
                    if(arr[i][k] > arr[i][k+1]) {
                        int temp = arr[i][k];
                        arr[i][k] = arr[i][k+1];
                        arr[i][k+1] = temp;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
