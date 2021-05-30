package Mathematics;

//Find GCD or HCF of given numbers.| Relation of this GCD with tiling problem(Find side of the largest square using which you can tile the whole rectangle a*b)
//If two numbers do not have any common divisors except 1, then these two numbers need not to be prime.(9,10)
//Time Complexity: O(min(a, b))
/*public class Gcd {
    static int gcd(int a, int b){
        int res = Math.min(a, b);
        while(res > 0){
            if(a % res == 0 && b % res == 0){
                break;
            }
            res--;
        }
        return res;
    }
    public static void main (String[] args) {
        int a = 12, b = 15;
        System.out.println(gcd(a, b));

    }
}*/

//Efficient Solution: Euclidean Algorithm (Repeated Subtraction)
//Time Complexity: O(log(min(a, b))
/*public class Gcd {
    static int gcd(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    public static void main(String[] args) {

        int a = 12, b = 15;

        System.out.println(gcd(a, b));

    }
}*/


//More Efficient Solution: Optimized Euclidean Algorithm (Modular division)
//Time Complexity: O(log(min(a, b))
public class Gcd {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        int a = 12, b = 15;
        System.out.println(gcd(a, b));

    }
}