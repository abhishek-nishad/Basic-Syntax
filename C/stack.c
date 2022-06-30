#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

/*	
	Stack is a linear data structure. 
	It follows the LIFO order.
	That is the element pushed at the last will be at the top of the stack and poped first.
	
	The common structure of a stack node is:
	
	[int data, Stack next] : * where data stores the value pushed in the stack and 
				   	   		 * next contains the address of the value below the current
				       		   position in the stack.

*/

//Definition of a node in stack
struct stack
{
	int data;  
	struct stack *next;
};

typedef struct stack Stack;  /*Instead of writing the complete definition of the stack everytime
							   we can provide it a new name for easier implementation*/

Stack *top = NULL;	// Variable to store the top of stack(TOS). DO NOT CHANGE UNTIL THERE IS CHANGE IN THE NO. OF NODES.
Stack *push(Stack*, int); //Function to push value to the TOS
Stack *display(Stack*);	  //Function to display the values of stack in top-down order.
Stack *pop(Stack*); 	  // Function to remove TOS.
int main() 				  //Driver Code
{
	int value, option;  //Option stores the id of operation user wants to perform
	do			// Operation menu
	{
		printf("\n\t*****MAIN MENU*****\n");
		printf("\n\t1. PUSH");
		printf("\n\t2. POP");
		printf("\n\t3. DISPLAY");
		printf("\n\t4. EXIT");
		printf("\n\tEnter your option : ");
		scanf("%d", &option);
		switch(option)
		{
			case 1:
				printf("\n\tEnter the number to be pushed on stack: ");
				scanf("%d", &value); //value contains the value to be pushed
				top = push(top, value); 
				break;
				
			case 2:
				top = pop(top);
				break;
				
			case 3:
				top = display(top);
				break;
				
			case 4: break;
			default: printf("\n\tINVALID CHOICE INPUT!!!\n");
		}
	}while(option != 4);
	return 0;
}
Stack *push(Stack *top, int value)
{
	/*
		To push a value into stack, we first need to create a new node.
		After creating the new node, push the value into the Node.
		Now, check if the stack is empty.
		If YES: assign the current node as TOS and return.
		Else: Store the address of current TOS in Node->next and assign the current node as TOS.
	*/
	
	Stack *ptr;  		//New node
	ptr = (Stack*)malloc(sizeof(Stack));
	ptr -> data = value;
	if(top == NULL) 	//Test for empty node
	{
		ptr -> next = NULL;
		top = ptr;
	}
	else
	{
		ptr -> next = top;
		top = ptr;
	}
	return top;
}
Stack *display(Stack *top)
{
	/* 
		To display, first check for empty stack, 
		if the stack is not empty, make a new Node = TOS
		print Node->data until Node is null
	*/
	
	Stack *ptr;
	ptr = top;
	if(top == NULL)  // Empty TOS implies that there are no values in the stack. 
		printf("\n\tSTACK IS EMPTY\n");
	else
	{
		while(ptr != NULL)
		{
			printf("\n\t%d", ptr -> data);
			ptr = ptr -> next;
		}
	}
	return top;
}
Stack *pop(Stack *top)
{
	/* 
		To pop(remove) an element, first check for empty stack, 
		If the stack is not empty, shift the tos to next value TOS = TOS->next
		Deallocate the current node.
	*/
	Stack *ptr;
	ptr = top;
	if(top == NULL)
		printf("\n\tSTACK UNDERFLOW\n");
	else
	{
		top = top -> next;
		printf("\n\tThe value being deleted is: %d\n", ptr -> data);
		free(ptr);
	}
	return top;
}

