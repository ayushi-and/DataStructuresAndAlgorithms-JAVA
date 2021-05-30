package Mathematics;

//Find LCM of given numbers
//Time Complexity: O(a*b - max(a,b))
/*
public class Lcm {
    static int lcm(int a, int b)
    {
        int res = Math.max(a, b);
        while(true){
            if(res % a == 0 && res % b == 0){
                return res;
            }
            res++;
        }
    }

    public static void main (String[] args) {
        int a = 4, b = 6;
        System.out.println(lcm(a, b));
    }
}
*/


//Efficient Approach
//Time Complexity: O(log(min(a, b))
public class Lcm {
    static int gcd(int a, int b)
    {
        if(b==0)
            return a;

        return gcd(b, a % b);
    }

    static int lcm(int a, int b)
    {
        return (a * b) / gcd(a, b);
    }

    public static void main (String[] args) {

        int a = 4, b = 6;

        System.out.println(lcm(a, b));

    }
}
