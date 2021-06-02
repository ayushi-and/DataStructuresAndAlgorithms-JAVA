package BitManipulations;

//We have two numbers n and k, we have to find whether kth bit in n is set or not. (Kth bit from the right side)
//n=5, k=1  -> o/p=yes (5 -> 000...0101)
//k <= No of bits in binary representation
//Method 1: Using Left Shift
public class CheckKthBitSetOrNot {
    public static void isKthBitSet(int n,
                                   int k)
    {
        if ((n & (1 << (k - 1))) == 1)
            System.out.print("SET");
        else
            System.out.print("NOT SET");
    }

    // driver code
    public static void main(String[] args)
    {
        int n = 5, k = 1;
        isKthBitSet(n, k);
    }
}


//Method 2: Using Right Shift
/*
public class CheckKthBitSetOrNot {
    static void isKthBitSet(int n,
                            int k)
    {
        if (((n >> (k - 1)) &
                1) == 1)
            System.out.println("SET");
        else
            System.out.println("NOT SET");
    }

    // Driver code
    public static void main (String[] args)
    {
        int n = 5, k = 1;
        isKthBitSet(n, k);
    }
}*/
