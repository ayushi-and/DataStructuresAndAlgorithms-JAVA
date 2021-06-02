package BitManipulations;

//Note: Negative numbers are stored in 2's complement form if the starting bit from left is 1, no is positive else negative if 0.

public class BitwiseNotLeftShift {
    public static void main (String[] args) {
        int p = -1;
        System.out.println(p << 1); //Bitwise left shift with negative number; p*(2^1)

        int x = 3;
        System.out.println(x << 1); //Bitwise left shift; x*(2^1)
        System.out.println(x << 2);
        int y = 4;
        int z = (x << y);
        System.out.println(z);

        int q = 1;
        System.out.println(~ q); //Bitwise NOT

    }
}
