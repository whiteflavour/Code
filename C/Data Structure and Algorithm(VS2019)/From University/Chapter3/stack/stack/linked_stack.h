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
 * ����һ����ջ������ռ䣬ʹ���Ϊͷ�ڵ㣩��
 * 
 * <b>NOTE: </b> ��ʹ�����淽��֮ǰ����Ҫ�ȵ��ø÷�����
 * 
 * @param stack ��Ҫ������ջ
 * @return �����õģ������˿ռ�ģ�ջ
 */
struct t_linked_stack* create_stack(struct t_linked_stack* stack)
{
	stack = (struct t_linked_stack*)malloc(sizeof(struct t_linked_stack));
	return stack;
}

/**
 * ��ʼ��ͷ�ڵ㡣
 * 
 * <b>NOTE: </b>�ڵ��ø÷���֮ǰ������� create_stack() �������ڵ��ø÷������·���֮ǰ������ø÷�����
 * 
 * @param lined_stack ��Ҫ��ʼ������ջ��
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
 * ��ȡջ�Ĵ�С��
 * 
 * @param linked_stack ��Ҫ��ȡ��С����ջ
 * @return ջ�Ĵ�С
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
 * ��Ԫ��ѹ��ջ�ס�
 * 
 * @param linked_stack ��Ҫѹ���Ԫ�ص�ջ
 * @param element ��Ҫѹ���Ԫ��
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
 * ��ջ��Ԫ�ص�ջ
 * 
 * @param linked_stack Ŀ��ջ
 * @param element Ŀ��Ԫ��
 * @return ������Ԫ�أ��������ڣ��򷵻� NULL ��
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
