package Mathematics;

//Given two numbers a and b, find the sum of a and b. Since the sum can be very large, find the sum modulo (10^9)+7.
public class AdditionUnderModulo {
    public static long sumUnderModulo(long a, long b){

        double power = Math.pow(10, 9);
        long M = (long)power + 7;
        a = a % M;
        b = b % M;
        long sum = (a + b ) % M;
        return sum;
    }
    public static void main (String[] args) {
        System.out.println(sumUnderModulo(1000000007, 1000000007));
    }
}
