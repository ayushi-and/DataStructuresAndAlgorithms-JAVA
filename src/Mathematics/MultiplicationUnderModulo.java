package Mathematics;

//You are given two numbers a and b. You need to find the multiplication of a and b under modulo M (M as (10^9)+7).
public class MultiplicationUnderModulo {
    static long multiplicationUnderModulo(long a, long b)
    {
        double power = Math.pow(10, 9);
        long M = (long)power + 7;
        a = a % M;
        b = b % M;
        long result = (a * b) % M;
        return result;

    }
    public static void main (String[] args) {
        System.out.println(multiplicationUnderModulo(1000000007, 1000000007));
    }
}
