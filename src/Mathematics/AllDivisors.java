package Mathematics;

//Print all divisors of a given number in increasing order.
//Naive solution
//Time Complexity: Theta(n)
//Time Complexity: Theta(1)
/*public class AllDivisors {
    static void printDivisors(int n){
        for(int i=1; i <= n; i++){
            if(n % i == 0){
                System.out.print(i+" ");
            }
        }
    }
    public static void main (String[] args) {
        int n = 15;
        printDivisors(n);
    }
}*/

//Efficient code : Not in order
//Time Complexity: Theta(sqrt(n))
/*public class AllDivisors {
    static void printDivisors(int n)
    {
        for(int i=1; i*i <= n; i++)
        {
            if(n % i == 0)
            {
                System.out.print(i+" ");

                if(i != n / i)
                    System.out.print((n / i)+" ");
            }
        }
    }

    public static void main (String[] args) {

        int n = 25;

        printDivisors(n);

    }

}*/

//More Efficient code : In Sorted order
//Time Complexity: Theta(sqrt(n))
//Auxiliary space: Theta(1)
public class AllDivisors {
    static void printDivisors(int n)
    {
        int i = 1;
        for(i=1; i*i < n; i++) //Print all divisors from 1(inclusive) to sqrt(n)(exclusive)
        {
            if(n % i == 0)
            {
                System.out.print(i+" ");
            }
        }

        for(; i >= 1; i--) //Print all divisors from sqrt(n)(inclusive) to n(exclusive)
        {
            if(n % i == 0)
            {
                System.out.print((n / i)+" ");
            }
        }
    }

    public static void main (String[] args) {

        int n = 15;

        printDivisors(n);

    }
}


