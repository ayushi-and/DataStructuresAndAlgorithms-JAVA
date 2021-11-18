package TwoDArrayProblems;

public class CountIslands {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1 ,0 ,0, 0},
                {1 ,1, 0, 1},
                {0 ,0 ,0 ,1},
                {1 ,0 ,0 ,1}};

        int res = findIslands(arr, 4, 4);
        System.out.println(res);
    }

    static int findIslands(int[][] arr, int r, int c) {

        int count = 0;
        boolean v[][] = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[j][j] == 1) {
                    if(!v[i][j]) {
                        checkPairs(arr, i, j, v);
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    static void checkPairs(int[][] arr, int i, int j, boolean[][] v) {
        if(v[i][j]) {
            return;
        }
        int rowArray[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        int colArray[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};


        v[i][j] = true;

        for(int p = 0; p < 8; p++) {
            if(i+rowArray[p] >= 0 && i+rowArray[p] < v.length && j + colArray[p] >= 0 && j + colArray[p] < v[0].length && arr[i][j] == 1) {
                checkPairs(arr, i + rowArray[p], j + colArray[p], v);
            }
        }
    }
}
