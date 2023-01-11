package TestMixedQuestions;

import java.io.IOException;

class Outcome {

    /*
     * Find a number whose sum of digits is s and number of digits is n.
     * Implement method/function with name 'solve' below.
     * The function accepts following as parameters.
     *  1. n is of type int.
     *  2. s is of type int.
     * return long.
     */

    public static long solve(int n, int s) {
        //Write your code here


        int i = 1;
        while (true) {
            if (getSum(i) == s && getCountDigits(i) == n) {
                return i;
            }
            i++;
        }
        //return type "long".

    }

    static int getSum(int s) {
        int sum = 0;
        while (s != 0) {
            sum = sum + s % 10;
            s = s / 10;
        }
        return sum;
    }

    static int getCountDigits(int d) {
        int count = 0;
        while (d != 0) {
            d = d/10;
            count++;

        }
        return count;
    }

        public static void main(String[] args) throws IOException {


            long outcome = Outcome.solve(1, 5);
            System.out.println(outcome);

        }
    }
