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
	element_type elements[MAX_SIZE];
	int top;
};

/**
 * 初始化（创建）栈
 */
void init_stack()
{
	struct sequencial_stack* stack = (struct sequencial_stack*)malloc(sizeof(struct sequencial_stack));
	stack->top = 0;
}


/**
 * 获取栈的大小。
 * 
 * @param stack 需要获取大小的链栈
 * @return 栈的大小
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
 * 将元素压入栈底。
 * 
 * @param stack 需要压入的元素的栈
 * @param element 需要压入的元素
 * @return true if push success
 */
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


/**
 * 将栈顶元素弹栈
 * 
 * @param stack 目标栈
 * @param element 目标元素
 * @return 弹出的元素，若不存在，则返回 NULL 。
 */
element_type pop(struct sequencial_stack* stack)
{
	if (stack->top > 0)
	{
		--(stack->top);
		return stack->elements[stack->top];
	}
	return NULL;
}
