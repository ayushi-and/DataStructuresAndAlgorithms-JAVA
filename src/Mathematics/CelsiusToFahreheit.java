package Mathematics;

public class CelsiusToFahreheit {
    public static double cToF(int C)
    {
        return ((C*9)/5)+32;
    }
    public static void main (String[] args) {
        System.out.println(cToF(32));
    }
}
