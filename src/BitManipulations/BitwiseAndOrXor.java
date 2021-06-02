package BitManipulations;

//Note: In java, we have 32 bit binary representation of a number.

public class BitwiseAndOrXor {
    public static void main (String[] args) {
        int x = 3, y = 6;
        System.out.println(x & y); //and
        System.out.println(x | y); //or
        System.out.println(x ^ y); //xor (1 on different bits, 0 on same bits)
    }
}
