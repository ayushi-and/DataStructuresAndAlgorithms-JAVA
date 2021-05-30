package Mathematics;

//Iterative Solution:
//Time Complexity: Theta(n)
//Auxiliary Space: O(1)
public class Factorial {
    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i;
        }
        return res;
    }
    public static void main(String[] args) {

        int number = 5;
        System.out.println(fact(number));
    }
}

//Recursive Solution (n>=0):
//Time Complexity: Theta(n)
//Auxiliary Space: Theta(n) because of function call stack. (Extra overhead)
/*public class Factorial {

    static int fact(int n) {
        if (n == 0)
            return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {

        int number = 5;

        System.out.println(fact(number));

    }
}*/
