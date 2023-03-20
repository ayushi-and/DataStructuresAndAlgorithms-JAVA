package TestMixedQuestions;

import java.util.Arrays;
import java.util.Scanner;

//Tic-tac-toe: Build a terminal version of the game. Two player game, turn-based.
//The symbol for each player is assigned automatically at the start. Players give input for position and the current state of the board is printed.
//The game continues until someone wins or it is a draw. Also need to take care of wrong inputs by users and exception handling.
public class TicTacToeWithUserInput {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToeWithUserInput(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public boolean play(int row, int col, int player) {
        if(row < 0 || row >= rows.length || col < 0 || col >= cols.length) {
            throw new IllegalArgumentException("Wrong inputs!");
        }

        int n = rows.length;   //3-1-1
        int currentPlayer = (player == 1) ? 1 : -1;

        rows[row] += currentPlayer;
        cols[col] += currentPlayer;

        if(row == col) {
            diagonal += currentPlayer;
        }

        if(row == n - col - 1) {
            antiDiagonal += currentPlayer;
        }

        if(Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n || Math.abs(rows[row]) == n || Math.abs(cols[col]) == n) {
            System.out.println(player + " won!");
            return true;
        }

        return false; //temp
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        TicTacToeWithUserInput ticTacToe = new TicTacToeWithUserInput(3);

        boolean[][] visited = new boolean[3][3];
        Arrays.fill(visited, false);


        int count = 0;
        int player = 1;

        while(count < 9) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean isWon;
            if (visited[row][col]) {
                System.out.println("Wrong input is provided, position is filled already");
                continue;
            } else {
                visited[row][col] = true;
                isWon = ticTacToe.play(row, col, player);
                count++;
                System.out.println(isWon);
                if (isWon) {
                    break;
                }
                player = (player == 1) ? 2 : 1;
            }
        }
    }
}
