import java.util.*; 
public class LinearSearch 
{
    private int linearSearch(int[] arr, int n, int value)
    {
        for(int i=0; i<n; i++)
        {
            if(arr[i] == value)
                return i;
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

        int index = new LinearSearch().linearSearch(A, n, value);
        
        if(index != -1)
            System.out.println("Found at index : " + index);

        else    
            System.out.println("Absent");

        ob.close();
    }
}

