import java.util.*; 
public class BubbleSort 
{
    private void bubbleSort(int[] arr, int n)
    {
        for(int i=0; i < n-1; i++)
        {
            for(int j=0; j < n-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int t = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = t;
                }
            }
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
        new BubbleSort().bubbleSort(A, n);
        for(int val : A)
            System.out.print(val+" ");
        ob.close();
    }
}