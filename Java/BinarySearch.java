import java.util.*; 
public class BinarySearch 
{
    private int binarySearch(int[] arr, int n, int value)
    {
        int low = 0, high = n-1; 

        while (low <= high)
        {
            int mid = low + (high-low)/2;
    
            if (value == arr[mid])
                return mid;
            else if( value > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
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

        System.out.print("Enter value to be searched : ");
        int value = ob.nextInt();

        int index = new BinarySearch().binarySearch(A, n, value);
        
        if(index != -1)
            System.out.println("Found at index : " + index);

        else    
            System.out.println("Absent");

        ob.close();
    }
}

