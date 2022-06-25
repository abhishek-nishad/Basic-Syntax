import java.util.*; 
public class HeapSort 
{
    private void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void buildMaxHeap(int arr[], int n)
    {
        int t = (int)Math.floor(n/2) - 1;
        for (int i = t; i >= 0; i--)
            heapify(arr, i, n);
    }
    private void heapify(int arr[], int i, int n)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) 
        {
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }  
    }
    public void heapSort(int arr[], int n)
    {
        buildMaxHeap(arr, n);

        for(int i = n-1; i>0; i--)
        {
            swap(arr, 0, i);
            heapify(arr, 0, i);
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
        new HeapSort().heapSort(A, n);
        for(int val : A)
            System.out.print(val+" ");
        ob.close();
    }
} 