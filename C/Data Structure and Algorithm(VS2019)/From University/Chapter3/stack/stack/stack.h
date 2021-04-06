#pragma once

#include <stdio.h> 
#include <stdlib.h> 
#include <stdbool.h> 

#define MAX_SIZE 50
typedef int element_type;

struct sequencial_stack
{
	element_type elements[MAX_SIZE];
	int top;
};

void init_stack()
{
	struct sequencial_stack* stack = (struct sequencial_stack*)malloc(sizeof(struct sequencial_stack));
	stack->top = 0;
}

bool push(struct sequencial_stack* stack, element_type element)
{
	if (stack->top >= 0 && stack->top < MAX_SIZE)
	{
		stack->elements[stack->top] = element;
		++(stack->top);
		return true;
	}
	return false;
}

element_type pop(struct sequencial_stack* stack)
{
	if (stack->top > 0)
	{
		--(stack->top);
		return stack->elements[stack->top];
	}
	return NULL;
}
