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

// ��ջԪ����Ŀ��
static int SIZE = 0;

/**
 * ����һ����ջ������ռ䣬ʹ���Ϊͷ�ڵ㣩��
 * 
 * <b>NOTE: </b> ��ʹ�����淽��֮ǰ����Ҫ�ȵ��ø÷�����
 * 
 * @return �����õģ������˿ռ�ģ�ջ
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
 * ��ȡջ�Ĵ�С��
 * 
 * @param linked_stack ��Ҫ��ȡ��С����ջ
 * @return ջ�Ĵ�С
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
 * ��Ԫ��ѹ��ջ�ס�
 * 
 * @param linked_stack ��Ҫѹ���Ԫ�ص�ջ
 * @param element ��Ҫѹ���Ԫ��
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
 * ��ջ��Ԫ�ص�ջ
 * 
 * @param linked_stack Ŀ��ջ
 * @return ������Ԫ�أ��������ڣ��򷵻� NULL ��
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
