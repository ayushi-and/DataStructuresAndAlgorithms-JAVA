package Mathematics;

//Compute power of a given number (x, n) -> x^n
//Naive Solution
//Time Complexity: Theta(n)
/*public class ComputePower {
    static int power(int x, int n){
        int res = 1;
        for(int i = 0; i < n; i++){
            res = res * x;
        }
        return res;
    }
    public static void main (String[] args) {

        int x = 3, n = 5;

        System.out.println(power(x, n));

    }
}*/

//Efficient Solution : Recursive solution
//Time Complexity: Theta(log(n))
//Auxiliary Space: Theta(log(n))
public class ComputePower {
    static int power(int x, int n)
    {
        if(n == 0)
            return 1;

        int temp = power(x, n/2);

        temp = temp * temp;

        if(n % 2 == 0)
            return temp;
        else
            return temp * x;
    }

    public static void main (String[] args) {

        int x = 3, n = 5;

        System.out.println(power(x, n));

    }
}