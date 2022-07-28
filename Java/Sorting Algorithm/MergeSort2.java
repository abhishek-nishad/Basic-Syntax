import java.util.*; 
public class MergeSort2
{
    private void merge(int[] arr, int low, int mid, int high)
    {
        int left = low, right = mid + 1;
        List<Integer> temp = new ArrayList<>();
     
        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
                temp.add(arr[left++]);

            else
                temp.add(arr[right++]);
        }
        
        while(left <= mid)
            temp.add(arr[left++]); 
        
        while(right <= high)
            temp.add(arr[right++]); 
        
        for(int i = low; i <= high; i++)
            arr[i] = temp.get(i - low); 
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
        new MergeSort2().mergeSort(A, 0, n-1);
        
        for(int val : A)
            System.out.print(val+" ");
        ob.close();
    }
}