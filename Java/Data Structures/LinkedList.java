import java.util.*;
public class LinkedList 
{
    ListNode head, tail;
    LinkedList()
    {
        head = tail = null;
    }
    private void createList(int[] A)
    {
        for(int val : A)
            insertLast(val);
    }
    private void insertBeginning(int val)
    {
        ListNode temp = new ListNode(val);
        
        if(head == null)
        {
            head = temp; 
            tail = head;
        }
        else
        {
            temp.next = head; 
            head = temp;
        }
    }
    private void insertLast(int val)
    {
        ListNode temp = new ListNode(val);
        
        if(head == null)
        {
            head = temp; 
            tail = head;
        }
        else
        {
            tail.next = temp;
            tail = tail.next;
        }
    }
    private int deleteFirst()
    {
        if(head == null)
            return -1; 

        int value = head.data;

        if(head == tail)
        {
            head = tail = null; 
            return value;
        }

        ListNode curr = head; 
        head = head.next; 
        curr.next = null;
        return value;
    }
    private int deleteLast()
    {
        if(head == null)
            return -1; 

        int value = head.data;

        if(head == tail)
        {
            head = tail = null; 
            return value;
        }

        ListNode curr = head; 
        if(head == tail)
        
        while(curr.next.next != null)
            curr = curr.next;

        value = curr.next.data; 
        tail = curr;
        curr.next = null;
        return value;
    }
    private void display()
    {
        if(head == null)
            System.out.println("EMPTY LIST");

        else
        {
            ListNode curr = head; 
            while(curr != null)
            {
                System.out.print(curr.data+" ");
                curr = curr.next; 
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        Scanner ob = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        System.out.println("1. Insert Beginning");
        System.out.println("2. Insert Last");
        System.out.println("3. Create list from array");
        System.out.println("4. Delete Beginning");
        System.out.println("5. Delete Last");
        System.out.println("6. Display");
        System.out.println("7. Exit");
    
        while(true)
        {
            System.out.print("Enter your choice : ");
            int ch = ob.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter data : ");
                    int data1 = ob.nextInt();
                    ll.insertBeginning(data1);
                    break;

                case 2:
                    System.out.print("Enter data : ");
                    int data2 = ob.nextInt();
                    ll.insertLast(data2);
                    break;
                
                case 3:
                    System.out.print("Enter array size : ");
                    int n = ob.nextInt(); 
                    int A[] = new int[n];

                    System.out.print("Enter array elements : ");
                    for(int i=0; i<n; i++)
                        A[i] = ob.nextInt();
                    
                    ll.createList(A);
                    break; 

                case 4:
                    int val1 = ll.deleteFirst();
                    if(val1 == -1)
                        System.out.println("EMPTY LIST");
                    else
                        System.out.println("DELETED VALUE : " + val1);   
                    break; 

                case 5:
                    int val2 = ll.deleteLast();
                    if(val2 == -1)
                        System.out.println("EMPTY LIST");
                    else
                        System.out.println("DELETED VALUE : " + val2);   
                    break; 

                case 6:
                    ll.display();
                    break;
                
                case 7:
                    ob.close();
                    System.exit(0);

                default:
                    System.out.println("INVALID INPUT");            
            }
        }   
    }
}

