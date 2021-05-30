package Mathematics;

//Count trailing zeroes in factorial of a given number.
//Naive Solution:
//Time Complexity: Theta(n)
//This solution causes overflow for slightly higher values of n.
/*
public class TrailingZeroes {
    static int countTrailingZeros(int n)
    {
        int fact = 1;
        int res = 0;
        for(int i=2; i<=n; i++)
        {
            fact = fact * i;
        }
        while(fact % 10 == 0){
            res++;
            fact = fact / 10;
        }
        return res;
    }
    public static void main (String[] args) {
        int number = 10;
        System.out.println(countTrailingZeros(number));
    }
}
*/

//Efficient Solution:
//Idea is to count how many 2's and 5's we have in the prime factorization of the given factorial.
//And #5's < #2's; so simply count number of 5's only.
//Time Complexity: Theta(log(n))
public class TrailingZeroes {
    static int countTrailingZeros(int n)
    {
        int res = 0;
        for(int i=5; i<=n; i=i*5)
        {
            res = res + (n / i);
        }
        return res;
    }
    public static void main (String[] args) {
        int number = 251;
        System.out.println(countTrailingZeros(number));
    }
}
