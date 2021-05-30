package Mathematics;

import java.util.ArrayList;

//Given a quadratic equation in the form ax2 + bx + c. Find its roots. If roots are imaginary, the returning list should contain only 1 integer ie -1.
public class QuadraticRoots {
    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        double D = (b*b) - (4*a*c);
        if(D < 0){
            list.add(-1);
            return list;
        }
        double sqrt = Math.sqrt(D);
        double r1 = Math.floor((-b + sqrt)/(2*a));
        double r2 = Math.floor((-b - sqrt)/(2*a));
        if(r1>r2){
            list.add((int)r1);
            list.add((int)r2);
        }
        else{
            list.add((int)r2);
            list.add((int)r1);
        }
        return list;
    }

    public static void main (String[] args) {
        System.out.println(quadraticRoots(1, -7, 12));
    }
}
