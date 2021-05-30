package Mathematics;

//Given two integers ‘a’ and ‘m’. The task is to find the smallest modular multiplicative inverse of ‘a’ under modulo ‘m’.
// x is the modular multiplicative inverse if (a*x)%m == 1, else 1; can never be 0.
//And (a*x)%m = ((a % m) * (x % m)) % m
public class ModularMultiplicativeInverse {
    public static int modInverse(int a, int m)
    {
        for(int x = 1; x < m; x++){
            if(((a % m) * (x % m)) % m == 1){
                return x;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        System.out.println(modInverse(3, 11));
    }
}
