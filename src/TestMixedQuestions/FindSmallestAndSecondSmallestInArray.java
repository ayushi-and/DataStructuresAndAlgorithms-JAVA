package TestMixedQuestions;

public class FindSmallestAndSecondSmallestInArray {
    public static void main(String[] args)
    {
        int[] elements  = {-4 , 2 , 10 , -2, -3 };
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < elements.length; i++)
        {
            if (smallest>elements[i])
                smallest=elements[i];

        }

        for (int i = 0; i < elements.length; i++)
        {
            if (secondSmallest>elements[i] && elements[i]>smallest)
                secondSmallest=elements[i];

        }

        System.out.println("The smallest element is: " + smallest + "\n"+  "The second smallest element is: " + secondSmallest);
    }
}
