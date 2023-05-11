package TreeDS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//
/*
mat[][] = {{1, 3, 3},
           {2, 1, 4},
           {0, 6, 4}};
2 -> 6 -> 4
12 gold
 */
public class PrintBottomViewOfTree {

/*            20(0)
        8(-1)       25(1)
    6(-2)      10(0) 22   27
 3           12*/


    static class Node {

        int key;
        Node left;
        Node right;
        int index;

        Node(int key) {
            this.key = key;
            this.index = Integer.MAX_VALUE;
        }

    }

    public static void printBottomView(Node root) {

        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        root.index = index;
        q.add(root);

        while(!q.isEmpty()) {
            Node node = q.remove();
            index = node.index;

            map.put(index, node.key);

            if (node.left != null)
            {
                node.left.index = index-1;
                q.add(node.left);
            }

            if (node.right != null)
            {
                node.right.index = index+1;
                q.add(node.right);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");

        }


    }

    /*public int getHeight(Node node) {

        if(node == null) {
            return 0;
        }
        return 1+ Math.max(node.left.key, node.right.key);
    }

    public void printView(int level, Node root) {

        if(level == 0) {
            System.out.println();
        }

        else if(level > 0) {
            printView(level - 1, root.left);
            printView(level - 1, root.right);
        }

    }*/


    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(25);
        root.left.left = new Node(6);
        root.left.right = new Node(10);
        root.right.left = new Node(22);
        root.right.right = new Node(27);
        root.left.right.left = new Node(12);

        printBottomView(root);
    }

    /*            20(0)
        8(-1)       25(1)
    6(-2)      10(0) 22   27
 3           12*/


//    public int maxGold(int[][] mat, int m, int n) {
//
//        int noGold = 0;
//        //for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//
//                calc(0, j, mat, noGold); //0, 0
//
//            }
//       // }
//    }
//
//    public static int calc(int i, int j, int[][] mat, int maxGold) {//0, 0, 1
//
//        maxGold += mat[i][j] + Math.max(calc(i-1, j-1, mat, maxGold), calc(i+1, j+1, mat, maxGold)); //1
//
//
//
//
//    }
//
}
