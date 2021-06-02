package BitManipulations;

//Note : (2^32)-1 = 111...1(32 1's); eg, (2^32)-1-1 = 11...110(since ones place got subtracted i.e. 2^0(1))

public class BitwiseRightShiftCases {
    public static void main (String[] args) {
        int x = 33;
        System.out.println(x >> 1); //Bitwise Right Shift; x*(2^1) //Append 0's as leading zeroes since number is positive

        int y = -2;
        System.out.println(y >> 1); //Bitwise Signed Right Shift with negative number //Append 1's as leading ones to keep sign since number is negative

        int z = -2;
        System.out.println(z >>> 1); //Bitwise Unsigned Right Shift //Append 0's to the empty places.

    }
}
