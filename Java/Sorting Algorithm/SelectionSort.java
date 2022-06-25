import java.util.*; 
public class SelectionSort 
{
    private void swap(int[] arr, int i, int j)
    {
        int t = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = t; 
    }

    private void selectionSort(int[] arr, int n)
    {
        for(int i=0; i < n-1; i++)
        {
            int min = i;

            for (int j = i+1; j < n; j++)
            {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i, min);
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
        new SelectionSort().selectionSort(A, n);
        for(int val : A)
            System.out.print(val+" ");
        ob.close();
    }
}