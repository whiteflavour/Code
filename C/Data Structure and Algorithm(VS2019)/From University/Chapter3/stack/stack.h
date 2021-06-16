#pragma once

#include <stdio.h> 
#include <stdlib.h> 
#include <stdbool.h> 

#define MAX_SIZE 50
typedef int element_type;


/**
 * Stack. 
 * 
 * @author Liao
 * @date 2021-4-8
 */
struct sequencial_stack
{
	element_type element[MAX_SIZE];
	int top;
};

/**
 * ��ʼ����������ջ
 */
struct sequencial_stack* init_stack()
{
	struct sequencial_stack* stack = (struct sequencial_stack*)malloc(sizeof(struct sequencial_stack));
	stack->top = 0;

	return stack;
}


/**
 * ��ȡջ�Ĵ�С��
 * 
 * @param stack ��Ҫ��ȡ��С����ջ
 * @return ջ�Ĵ�С
 */
int get_size(struct sequencial_stack* stack)
{
	if (stack->top >= 0)
	{
		return stack->top;
	}
	printf("Init first ... ");
	return NULL;
}


/**
 * ��Ԫ��ѹ��ջ�ס�
 * 
 * @param stack ��Ҫѹ���Ԫ�ص�ջ
 * @param element ��Ҫѹ���Ԫ��
 * @return true if push success
 */
bool push(struct sequencial_stack* stack, element_type element)
{
	if (stack->top >= 0 && stack->top < MAX_SIZE)
	{
		stack->element[stack->top] = element;
		++(stack->top);
		return true;
	}
	return false;
}


/**
 * ��ջ��Ԫ�ص�ջ
 * 
 * @param stack Ŀ��ջ
 * @param element Ŀ��Ԫ��
 * @return ������Ԫ�أ��������ڣ��򷵻� NULL ��
 */
element_type pop(struct sequencial_stack* stack)
{
	if (stack->top > 0)
	{
		--(stack->top);
		return stack->element[stack->top];
	}
	return NULL;
}

/**
  ���ջ�����е�Ԫ�ء�

 */
void print_all_elements(struct sequencial_stack* stack) 
{
	for (int i = 0; i < stack->top; ++i)
	{
		printf("%d ", stack->element[i]);
	}
	printf("\n");
}