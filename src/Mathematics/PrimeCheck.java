package Mathematics;

//Check if a number is prime or not.
//2 is the only even prime number.
//1 is neither prime nor composite.
//Time Complexity: O(n)
/*public class PrimeCheck {
    static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {

        int n = 2;

        System.out.println(isPrime(n));

    }
}*/

//Efficient method: Divisors always appear in pairs. i.e. 25 -> (1, 25), (5, 5)
//Time Complexity: O(sqrt(n))
/*public class PrimeCheck {
    static boolean isPrime(int n)
    {
        if(n==1)
            return false;

        for(int i=2; i*i<=n; i++)
        {
            if(n % i == 0)
                return false;
        }

        return true;
    }

    public static void main (String[] args) {

        int n = 65;

        System.out.println(isPrime(n));

    }
}*/


//More Efficient method: For large numbers
//Time Complexity: O(sqrt(n)) (3 times faster than previous solution)
public class PrimeCheck {
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

        int n = 1031;

        System.out.println(isPrime(n));

    }
}
