import java.util.*; 
public class QuickSort 
{
    private static void swap(int[] arr, int i, int j)
    {
        int t = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = t; 
    }

    private int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        int i = start - 1; 

        for(int j = start; j < end; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, end);
        return i+1;
    }
    private void quickSort (int[] arr, int start, int end)
    {
        if(start < end)
        {
            int partion_index = partition(arr, start, end);
            quickSort(arr, start, partion_index - 1);
            quickSort(arr, partion_index + 1, end);
        }
    }   
    public static void main(String[] args) 
    {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = ob.nextInt();

        int A[] = new int[n]; 
        System.out.print("Enter Array elements : ");
        for(int i=0; i<n; i++)
            A[i] = ob.nextInt(); 

        System.out.print("Original Array : ");
        for(int val : A)
            System.out.print(val+" ");
       
        System.out.println();
        System.out.print("Sorted Array : ");
        new QuickSort().quickSort(A, 0, n-1);
        for(int val : A)
            System.out.print(val+" ");
        ob.close();
    }
}