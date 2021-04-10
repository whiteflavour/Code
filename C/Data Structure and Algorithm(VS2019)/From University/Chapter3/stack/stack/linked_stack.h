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
	int size;
	element_type data;
	struct t_linked_stack* next;
	struct t_linked_stack* head;
	struct t_linked_stack* tail;
};

/**
 * 创建一个链栈（分配空间，使其成为头节点）。
 * 
 * <b>NOTE: </b> 在使用下面方法之前必须要先调用该方法。
 * 
 * @param stack 需要创建的栈
 * @return 创建好的（分配了空间的）栈
 */
struct t_linked_stack* create_stack(struct t_linked_stack* stack)
{
	stack = (struct t_linked_stack*)malloc(sizeof(struct t_linked_stack));
	return stack;
}

/**
 * 初始化头节点。
 * 
 * <b>NOTE: </b>在调用该方法之前必须调用 create_stack() 方法；在调用该方法以下方法之前必须调用该方法。
 * 
 * @param lined_stack 需要初始化的链栈。
 */
void init_stack(struct t_linked_stack* linked_stack)
{
	if (linked_stack > 0)
	{
		linked_stack->size = 0;
		linked_stack->data = NULL;
		linked_stack->next = NULL;
		linked_stack->head = linked_stack;
		linked_stack->tail = linked_stack;
	}
	else
	{
		printf("Please create first ... ");
	}
}

/**
 * 获取栈的大小。
 * 
 * @param linked_stack 需要获取大小的链栈
 * @return 栈的大小
 */
int get_size(struct t_linked_stack* linked_stack)
{
	if (linked_stack->size >= 0)
	{
		return linked_stack->size;
	}
	printf("Create and init first ... ");
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
	if (linked_stack > 0 && linked_stack->head > 0)
	{
		struct t_linked_stack* new_node = (struct t_linked_stack*)malloc(sizeof(struct t_linked_stack));
		new_node->data = element;
		linked_stack->tail->next = new_node;
		linked_stack->tail = linked_stack->tail->next;
		new_node->next = NULL;
		++linked_stack->size;
		return true;
	}
	printf("Please create first and then init ... ");
	return false;
}

/**
 * 将栈顶元素弹栈
 * 
 * @param linked_stack 目标栈
 * @param element 目标元素
 * @return 弹出的元素，若不存在，则返回 NULL 。
 */
element_type pop(struct t_linked_stack* linked_stack, element_type element)
{
	if (linked_stack > 0 && linked_stack->head > 0 && linked_stack->size > 0)
	{
		element_type returned_element = linked_stack->tail->data;
		--(linked_stack->size);
		linked_stack->tail = linked_stack->head;
		for (int i = 0; i < linked_stack->size; ++i)
		{
			linked_stack->tail = linked_stack->tail->next;
		}
		return returned_element;
	}
	printf("No such element ... ");
	return NULL;
}
