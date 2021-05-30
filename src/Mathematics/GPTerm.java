package Mathematics;

//Given the first 2 terms A and B of a Geometric Series. The task is to find the Nth term of the series.

public class GPTerm {
    public static double termOfGP(int A,int B,int N)
    {
        double r = (double)B/A;
        return A * Math.pow(r, N-1);
    }
    public static void main (String[] args) {
        System.out.println(termOfGP(1, 2, 2));
    }
}
