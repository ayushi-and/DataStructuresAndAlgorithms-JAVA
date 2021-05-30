package Mathematics;

//Print prime factors of a given number.(n > 1) (eg: n=12, o/p- 2 2 3)
//Prime factors are those divisors of a given number which are prime.
//Naive Solution
//Time Complexity: O(n*n*log(n))
/*public class PrimeFactors {
    static void printPrimeFactors(int n){
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                int x = i;
                while(n % x == 0){
                    System.out.println(i);
                    x = x * i;
                }
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
        int n = 450;
        printPrimeFactors(n);
    }
}*/

//Efficient Solution : Divisors always appear in pairs; A number can be written as multiplications of powers of prime factors.(12 = 2^2 * 3, 13 = 13^1)
//Time Complexity: Theta(Sqrt(n))
/*
public class PrimeFactors {
    static void printPrimeFactors(int n)
    {
        if(n <= 1)
            return;

        for(int i=2; i*i<=n; i++)
        {
            while(n % i == 0)
            {
                System.out.print(i+" ");

                n = n / i;
            }
        }

        if(n > 1)
            System.out.print(n+" ");

        System.out.println();
    }

    public static void main (String[] args) {

        int n = 450;

        printPrimeFactors(n);

    }
}*/



//More Efficient Solution
//Time Complexity: Theta(Sqrt(n))/6 = Theta(Sqrt(n))
public class PrimeFactors {

    static void printPrimeFactors(int n)
    {
        if(n <= 1)
            return;

        while(n % 2 == 0)
        {
            System.out.print(2+" ");

            n = n / 2;
        }

        while(n % 3 == 0)
        {
            System.out.print(3+" ");

            n = n / 3;
        }

        for(int i=5; i*i<=n; i=i+6)
        {
            while(n % i == 0)
            {
                System.out.print(i+" ");

                n = n / i;
            }

            while(n % (i + 2) == 0)
            {
                System.out.print((i + 2)+" ");

                n = n / (i + 2);
            }
        }

        if(n > 3)
            System.out.print(n+" ");

        System.out.println();
    }

    public static void main (String[] args) {

        int n = 450;

        printPrimeFactors(n);

    }
}
