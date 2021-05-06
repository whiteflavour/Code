#pragma once

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 50

typedef int elem_type;

/**
 * 改进的顺序队列，可以将元素删除后的位置填补好。
 *
 * @author Liao
 * @date 2021-4-22
 */
struct t_queue_imp
{
	int front;
	int rear;

	elem_type elements[MAX_SIZE];
};

struct t_queue_imp* create_queue()
{
	struct t_queue_imp* queue_imp = (struct t_queue_imp*)malloc(sizeof(struct t_queue_imp));
}
