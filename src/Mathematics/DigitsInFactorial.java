package Mathematics;

public class DigitsInFactorial {
    public static int digitsInFactorial(int N){
        double logSum = 0;

        if(N == 0 || N == 1){
            return 1;
        }
        for(int i = 1; i <= N; i++){
            logSum += Math.log10(i); //Since we can have large numbers also for factorial
        }

        return (int)Math.floor(logSum + 1);
    }

    public static void main (String[] args) {
        System.out.println(digitsInFactorial(120));
    }
}
