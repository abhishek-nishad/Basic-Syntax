import java.util.*; 
public class MergeSort 
{
    private void merge(int[] arr, int start, int mid, int end)
    {
        int n1 = mid - start + 1;
        int n2 = end - mid; 
        int L[] = new int[n1+1]; 
        int R[] = new int[n2+1];

        for(int i = 0; i < n1; i++)
            L[i] = arr[start + i];

        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + i + 1];

        L[n1] = R[n2] = Integer.MAX_VALUE;

        int i=0, j=0;
        for(int k = start; k <= end; k++)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i]; 
                i++;
            }
            else
            {
                arr[k] = R[j]; 
                j++;
            }
        }
    }
    private void mergeSort(int[] arr, int start, int end)
    {
        if(start < end)
        {
            int mid = start + (end - start)/2; 
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
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
        new MergeSort().mergeSort(A, 0, n-1);
        for(int val : A)
            System.out.print(val+" ");
        ob.close();
    }
}