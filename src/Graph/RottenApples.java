package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenApples {

    static final int row = 3;
    static final int col = 5;

    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1},
        };
        System.out.println(minTime(arr));
    }

    public static int minTime(int[][] arr) {

        Queue<Dummy> queue = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new Dummy(i, j));
                }
            }
        }

        queue.add(new Dummy(-1, -1));

        Dummy element;
        int ans = 0;

        while (!queue.isEmpty()) {

            boolean flag = false;
            while(!checkDummy(queue.peek())) {

                element = queue.peek();

                if(element.x+1 >= 0 && element.x+1 < row && element.y >= 0 && element.y < col && arr[element.x+1][element.y] == 1) {
                    arr[element.x+1][element.y] = 2;

                    element.x++;
                    queue.add(new Dummy(element.x, element.y));
                    element.x--;

                    if(!flag) {
                        flag = true;
                        ans ++;
                    }
                }

                if(element.x-1 >= 0 && element.x-1 < row && element.y >= 0 && element.y < col && arr[element.x-1][element.y] == 1) {
                    arr[element.x-1][element.y] = 2;

                    element.x--;
                    queue.add(new Dummy(element.x, element.y));
                    element.x++;

                    if(!flag) {
                        flag = true;
                        ans ++;
                    }
                }

                if(element.x >= 0 && element.x < row && element.y+1 >= 0 && element.y+1 < col && arr[element.x][element.y+1] == 1) {
                    arr[element.x][element.y+1] = 2;

                    element.y++;
                    queue.add(new Dummy(element.x, element.y));
                    element.y--;

                    if(!flag) {
                        flag = true;
                        ans ++;
                    }
                }

                if(element.x >= 0 && element.x < row && element.y-1 >= 0 && element.y-1 < col && arr[element.x][element.y-1] == 1) {
                    arr[element.x][element.y-1] = 2;

                    element.y--;
                    queue.add(new Dummy(element.x, element.y));
                    element.y++;

                    if(!flag) {
                        flag = true;
                        ans ++;
                    }
                }

                queue.remove();

            }

            queue.remove();

            if(!queue.isEmpty()) {
                queue.add(new Dummy(-1, -1));
            }



        }

        return checkOnes(arr) ? -1 : ans;

    }

    public static boolean checkDummy(Dummy d) {
        return d.x == -1 && d.y == -1;
    }

    public static boolean checkOnes(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}

class Dummy {
    int x;
    int y;

    Dummy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
