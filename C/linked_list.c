#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

/*	
	Linked List is a linear data structure. 
	It is a collection of nodes that contain data and link for next node.
	
	The common structure of a linked list node is:
	
	[int data, LinkedList next] : * where data stores the value of the node 
				   	   		 	  * next contains the address of the value after the current
				       		 	    node in the list.

*/

//Definition of a node in Linked List 

struct node
{
	int value;  
	struct Node *next;
};


typedef struct node List;  /*Instead of writing the complete definition of the node everytime
							   we can provide it a new name for easier implementation*/

List* head = NULL;	// Variable to store the head of Linked List. DO NOT CHANGE UNTIL THERE IS CHANGE IN THE HEAD NODES.

List* insertAtBeginning(List*, int); //Function to insert node at the beginning of list.
List* insertAtLast(List*, int); //Function to insert node at the of list.
List* display(List*); 			//Function to display the values of list in sequential order. 
List* deleteFirstNode(List*);	//Function to delete first node from the list.
List* deleteByValue(List*, int);	  	//Function to delete a node by value from the list.
List* deleteLastNode(List*); 	//Function to delete last node from the list.

int main() 				  //Driver Code
{
	int value, option;  //Option stores the id of operation user wants to perform
	do			// Operation menu
	{
		
		printf("\n\n\t*****MAIN MENU*****\n");
		printf("\n\t1. INSERT AT BEGINNING");
		printf("\n\t2. INSERT AT LAST");
		printf("\n\t3. DELETE FIRST NODE");
		printf("\n\t4. DELETE LAST NODE");
		printf("\n\t5. DELETE BY VALUE");
		printf("\n\t6. DISPLAY LIST");
		printf("\n\t7. EXIT");
		printf("\n\tEnter your option : ");
		scanf("%d", &option);
		switch(option)
		{
		
			case 1:
				printf("\n\tEnter the value to be added in the list : ");
				scanf("%d", &value); //value contains the value to be inserted at the beginning
				head = insertAtBeginning(head, value); 
				break;
				
			case 2:
				printf("\n\tEnter the value to be added in the list : ");
				scanf("%d", &value); //value contains the value to be inserted at the end
				head = insertAtLast(head, value); 
				break;
				
			case 3:
				head = deleteFirstNode(head);
				break;
				
			case 4:
				head = deleteLastNode(head);
				break;
				
			case 5:
				printf("\n\tEnter the value to be deleted from the list : ");
				scanf("%d", &value); //value contains the value to be deleted
				head = deleteByValue(head, value);
				break;
				
			case 6: 
				head = display(head);
				break;
			
			case 7: break;
			
			default: printf("\n\tINVALID CHOICE INPUT!!!\n");
		}
	}while(option != 7);
	return 0;
}

List* insertAtBeginning(List* listHead, int value)
{
	/*
		Create a new node. 
		Assign value to the node.
		Assign head->next = new node 
	*/
	
	List* newNode;
	newNode = (List*)malloc(sizeof(List));
	
	newNode -> value = value;
	newNode -> next = listHead;
	listHead = newNode;
	
	return listHead;
}

List* insertAtLast(List* listHead, int value)
{
	/*
		Create a new node. 
		Assign value to the node.
		Check if the list is empty.
		If true, make the new node the first node and assign head pointer to it
		Else, traverse to the last node and set ptr->next - new node
	*/
	List* ptr = listHead;
	List* newNode;
	newNode = (List*)malloc(sizeof(List));
	
	newNode -> value = value;
	newNode -> next = NULL;
	
	if(ptr==NULL)
		listHead = newNode;

	else
	{
		while(ptr->next != NULL)
			ptr = ptr->next;
		
		ptr->next = newNode;
	}
	return listHead;
}

List* deleteFirstNode(List* listHead)
{
	/*
		First check for empty list.
		If not empty, set a new pointer ptr to the head node.
		Shift the head to next node.
		Free ptr.
		
		Shifting the head pointer to next node handles the problem of deleted node being the first node
		as it allocates NULL to the head node.
	*/
	List* ptr = listHead;
	if(ptr == NULL)
		printf("\n\tEMPTY LIST!\n");
	else
	{
		listHead = listHead -> next;
		printf("\n\tThe value being deleted is: %d\n", ptr -> value);
		free(ptr);
	}
	return listHead;
}

List* deleteLastNode(List* listHead)
{
	/*
		First check for empty list.
		If not empty, set a new pointer ptr to the head node.
		Traverse to the last node. 
		If head node is the last node, set head node = NULL
		Free ptr

	*/
	List* ptr = listHead;
	if(ptr == NULL)
		printf("\n\tEMPTY LIST!\n");
	else
	{
		while(ptr->next != NULL)
			ptr = ptr->next;
			
		printf("\n\tThe value being deleted is: %d\n", ptr -> value);
		if(ptr==listHead)
			listHead = NULL;
		free(ptr);
	}
	return listHead;
	
}

List* deleteByValue(List* listHead, int value)
{
	/*
		First check for empty list.
		If not empty, set new pointers ptr and temp to the head node.
		
		Check if value to be deleted is at the head node, 
		If true, follow the steps of deleting first node
		Else, traverse temp to the node containing the value and ptr to the prev node
			Check if temp is NULL, if true, display ELEMENT ABSENT
			Else, set ptr->next = temp->next and free temp

	*/
	List* ptr = listHead;
	List* temp = listHead; 
	
	if(ptr==NULL)
		printf("\n\tEMPTY LIST!\n");
	
	else if(ptr != NULL && listHead->value == value)
	{
		printf("\n\tThe value being deleted is: %d\n", ptr->value);
		listHead = listHead->next;
		free(ptr);
	}

	else
	{
		while (temp != NULL && temp->value != value) 
		{
	        ptr = temp;
	        temp = temp->next;
    	}
    	if(temp==NULL)
    		printf("\n\tVALUE %d ABSENT FROM LIST!\n", value);
    	else
    	{
			printf("\n\tThe value being deleted is: %d\n", temp->value);
			ptr->next = temp->next;
			free(temp);		
		}
		
	}
	return listHead;
}

List* display(List* listHead)
{
		/* 
		To display, first check for empty list, 
		If not empty, traverse sequentially until ptr = NULL and display the values sequentially.
	*/
	
	List *ptr = listHead;
	if(ptr == NULL) 
		printf("\n\tEMPTY LIST!\n");
	
	else
	{
		printf("\n");
		while(ptr != NULL)
		{
			printf("\t%d", ptr -> value);
			ptr = ptr -> next;
		}
	}
	return listHead;
}

