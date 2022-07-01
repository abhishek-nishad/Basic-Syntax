import java.util.Scanner;

public class Stack 
{
    ListNode tos; 
    Stack()
    {
        this.tos = null;
    }

    private void push(int data)
    {
        ListNode temp = new ListNode(data);
        
        if(tos == null)
            tos = temp;
        
        else
        {
            temp.next = tos; 
            tos = temp; 
        }        
    }
    private int pop()
    {
        if(tos == null)
            return -1; 

        int value = tos.data;
        tos = tos.next;
        return value; 
    }
    private int peek()
    {
        if(tos == null)
            return -1;

        return tos.data;
    }
    private void display()
    {
        if(tos == null)
        {
            System.out.println("EMPTY STACK");
            return;
        }
        ListNode curr = tos; 
        
        while(curr != null)
        {
            System.out.println(curr.data);
            curr = curr.next; 
        }
    }

    public static void main(String[] args) 
    {
        Scanner ob = new Scanner(System.in); 
        Stack stack = new Stack();

        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Display");
        System.out.println("5. Exit");
    
        while(true)
        {
            System.out.print("Enter your choice : ");
            int ch = ob.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter data : ");
                    int data = ob.nextInt();
                    stack.push(data);
                    break;

                case 2:
                    int val = stack.pop();
                    if(val == -1)
                        System.out.println("EMPTY STACK");
                    else
                        System.out.println("POPPED VALUE : " + val);   
                    break; 

                case 3:
                    int val1 = stack.peek();
                    if(val1 == -1)
                        System.out.println("EMPTY LIST");
                    else
                        System.out.println("PEEK VALUE : " + val1);  


                case 4:
                    stack.display();
                    break;
                
                case 5:
                    ob.close();
                    System.exit(0);

                default:
                    System.out.println("INVALID INPUT");            
            }
        }   
    }
}
