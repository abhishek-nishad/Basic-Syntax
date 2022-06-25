import java.util.*; 
public class InsertionSort 
{
    private void insertionSort(int[] arr, int n)
    {
        for(int i=1; i<n; i++)
        {
            int key = arr[i];
            int j = i-1; 

            while(j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
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
        new InsertionSort().insertionSort(A, n);
        for(int val : A)
            System.out.print(val+" ");
        ob.close();
    }
} 