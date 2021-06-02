#include "stack.h"
// #include "linked_stack.h"

#include <stdio.h>
#include <stdbool.h>

int main() 
{
	/*
	  linked stack test

	 */

// 	struct t_linked_stack* linked_stack = create_stack();
// 	printf("%d\n", push(linked_stack, 1));
//  	printf("%d\n", push(linked_stack, 5));
//  	printf("%d\n", push(linked_stack, 0));
//  	printf("%d\n", push(linked_stack, 9));
//  	printf("%d\n", push(linked_stack, 2));
//  	print_all_elements(linked_stack);
// 
// 	printf("%d\n", get_size(linked_stack));
// 
// 	printf("\n");
// 
//  	printf("%d\n", pop(linked_stack));
//  	printf("%d\n", pop(linked_stack));
//  	printf("%d\n", pop(linked_stack));
//  	printf("%d\n", pop(linked_stack));
//  	print_all_elements(linked_stack);
// 
// 	printf("\n");
// 
// 	printf("%d\n", get_size(linked_stack));

	/*
	  stack test

	 */

 	struct sequencial_stack* stack = init_stack();
 	printf("%d\n", push(stack, 1));
 	printf("%d\n", push(stack, 0));
 	printf("%d\n", push(stack, 2));
 	printf("%d\n", push(stack, 9));
 	printf("%d\n", push(stack, 3));
 	print_all_elements(stack);

    printf("%d\n", get_size(stack));
 
 	printf("\n");
 
 	printf("%d\n", pop(stack));
 	printf("%d\n", pop(stack));
 	printf("%d\n", pop(stack));
 	print_all_elements(stack);

    printf("%d\n", get_size(stack));
}