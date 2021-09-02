package TestMixedQuestions;

//Remove duplicate elements from sorted array in O(n) time and O(1) space complexity
//No extra space, data structures to be used.
public class RemoveDuplicatesFromSortedArray {
    public static void removeDuplicate(int arr[]) {

        int next = 0;
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            if (arr[i] != arr[i+1])
            {
                arr[next] = arr[i];
                next++;
            }
        }
        arr[next++] = arr[n-1];
        for (int i = 0; i < next; i++)
        {
            System.out.print(arr[i]+" ");
        }

    }

    public static void main (String[] args)
    {
        int arr[] = {100, 100, 500, 600, 700, 800, 800};
            removeDuplicate(arr);
    }
}
