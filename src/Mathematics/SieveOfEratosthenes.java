package Mathematics;

import java.util.Arrays;

//Find all prime numbers smaller than or equal to a given number.
//naive solution
//Time Complexity: O(n*sqrt(n))
/*public class SieveOfEratosthenes {
    static void sieve(int n){
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
    static boolean isPrime(int n)
    {
        if(n==1)
            return false;

        if(n==2 || n==3)
            return true;

        if(n%2==0 || n%3==0)
            return false;

        for(int i=5; i*i<=n; i=i+6)
        {
            if(n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }
    public static void main (String[] args) {

        int n = 18;

        sieve(n);

    }
}*/


//Efficient Solution
//Time Complexity: O(n*log(log(n)))
public class SieveOfEratosthenes {
    static void sieve(int n)
    {
        if(n <= 1)
            return;

        boolean isPrime[] = new boolean[n+1];

        Arrays.fill(isPrime, true);

        for(int i=2; i*i <= n; i++)
        {
            if(isPrime[i])
            {
                for(int j = 2*i; j <= n; j = j+i) //2*i == i*i to reduce iterations
                {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2; i<=n; i++)
        {
            if(isPrime[i])
                System.out.print(i+" ");
        }
    }

    public static void main (String[] args) {

        int n = 18;

        sieve(n);

    }
}