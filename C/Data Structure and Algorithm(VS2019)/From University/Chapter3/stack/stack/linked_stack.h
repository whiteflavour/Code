#pragma once

#include <stdio.h> 
#include <stdlib.h> 
#include <stdbool.h> 

typedef int element_type;

static int SIZE = 0;

struct t_linked_stack
{
	element_type data;
	struct t_linked_stack* next;
} *head, *tail;

struct t_linked_stack* create_stack(struct t_linked_stack* stack)
{
	stack = (struct t_linked_stack*)malloc(sizeof(struct t_linked_stack));
	return stack;
}

void init_stack(struct t_linked_stack* linked_stack)
{
	if (linked_stack > 0)
	{
		linked_stack->data = NULL;
		linked_stack->next = NULL;
		head = linked_stack;
		tail = linked_stack;
	}
	else
	{
		printf("Please create first ... ");
	}
}

bool push(struct t_linked_stack* linked_stack, element_type element)
{
	if (linked_stack > 0 && head > 0)
	{
		struct t_linked_stack* new_node = (struct t_linked_stack*)malloc(sizeof(struct t_linked_stack));
		new_node->data = element;
		tail->next = new_node;
		tail = tail->next;
		new_node->next = NULL;
		++SIZE;
		return true;
	}
	printf("Please create first and then init ... ");
	return false;
}


