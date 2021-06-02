#pragma once

#include <stdio.h> 
#include <stdlib.h> 
#include <stdbool.h> 

typedef int element_type;

/**
 * Linked Stack. 
 * 
 * @author Liao
 * @date 2021-4-8
 */
struct t_linked_stack
{
	element_type data;
	struct t_linked_stack* next;
	struct t_linked_stack* head;
	struct t_linked_stack* tail;
};

// 链栈元素数目。
static int SIZE = 0;

/**
 * 创建一个链栈（分配空间，使其成为头节点）。
 * 
 * <b>NOTE: </b> 在使用下面方法之前必须要先调用该方法。
 * 
 * @return 创建好的（分配了空间的）栈
 */
struct t_linked_stack* create_stack()
{
	struct t_linked_stack* stack = (struct t_linked_stack*)malloc(sizeof(struct t_linked_stack));
	stack->data = NULL;
	stack->head = stack->tail = stack;
	stack->next = NULL;

	return stack;
}

/**
 * 获取栈的大小。
 * 
 * @param linked_stack 需要获取大小的链栈
 * @return 栈的大小
 */
int get_size(struct t_linked_stack* linked_stack)
{
	if (SIZE >= 0)
	{
		return SIZE;
	}
	printf("Create first ... ");
	return NULL;
}

/**
 * 将元素压入栈底。
 * 
 * @param linked_stack 需要压入的元素的栈
 * @param element 需要压入的元素
 * @return true if push success
 */
bool push(struct t_linked_stack* linked_stack, element_type element)
{
	if (SIZE == 0)
	{
		linked_stack->data = element;
		++SIZE;
		return true;
	}
	else if (SIZE > 0)
	{
		struct t_linked_stack* new_node = (struct t_linked_stack*)malloc(sizeof(struct t_linked_stack));
		new_node->data = element;
		linked_stack->tail->next = new_node;
		linked_stack->tail = linked_stack->tail->next;
		new_node->next = NULL;
		++SIZE;
		return true;
	}
	printf("Please create first... ");
	return false;
}

/**
 * 将栈顶元素弹栈
 * 
 * @param linked_stack 目标栈
 * @return 弹出的元素，若不存在，则返回 NULL 。
 */
element_type pop(struct t_linked_stack* linked_stack)
{
	if (SIZE > 0)
	{
		element_type returned_element = linked_stack->tail->data;
		--SIZE;
		linked_stack->tail = linked_stack->head;
		for (int i = 0; i < SIZE - 1; ++i)
		{
			linked_stack->tail = linked_stack->tail->next;
		}
		return returned_element;
	}
	printf("No such element ... ");
	return NULL;
}

void print_all_elements(struct t_linked_stack* linked_stack)
{
	if (SIZE > 0)
	{
		for (int i = 0; i < SIZE; ++i)
		{
			printf("%d ", linked_stack->data);
			linked_stack = linked_stack->next;
		}
		printf("\n");
	}
}
