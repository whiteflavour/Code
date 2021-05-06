#pragma once

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 50

typedef int element_type;

/**
 * 普通顺序队列，已经删除的元素的空间不能重复利用。
 * 
 * @author Liao
 * @date 2021-4-15
 */
struct t_queue
{
	element_type elements[MAX_SIZE];
	int front;
	int rear;
};

/**
 * 初始化队列：创建空间并初始化头索引和尾索引。
 * 
 * @return 指向该块已初始化队列的内存的指针。
 */
struct t_queue* init_queue()
{
	struct t_queue* queue = (struct t_queue*)malloc(sizeof(struct t_queue));

	queue->front = 0;
	queue->rear = 0;

	return queue;
}

/**
 * 返回该队列元素的大小
 * 
 * @param queue 目标队列
 * @return 目标对列的大小
 */
int get_size(struct t_queue* queue)
{
	int size = queue->rear - queue->front;
	return size;
}

/**
 * 插入元素
 *
 * @param queue target queue
 * @param element 要插入的元素
 * @return true if insert success
 */
bool insert(struct t_queue* queue, element_type element)
{
	/**
	 * 如果 queue 已经初始化，并且队列未满，则插入
	 */
	if (queue > 0 && queue->rear < MAX_SIZE)
	{
		queue->elements[queue->front] = element;
		// 将首索引后移
		++(queue->front);
		return true;
	}
	printf("Queue not initialized or is overflow ... ");
	return false;
}

/**
 * 删除元素
 *
 * @param queue target queue
 * @param element element that needed to remove
 * @return 被删除的元素，NULL if no such element 
 */
element_type remove(struct t_queue* queue, element_type element)
{
	if (queue > 0 && queue->front != queue->rear)
	{
		element_type elem = queue->elements[queue->front];
		++(queue->front);
		return elem;
	}
	printf("No such element ... ");
	return NULL;
}

/**
 * 替换某索引的元素
 *
 * @param queue target queue
 * @param index 要替换元素的索引
 * @param element 替换后的元素
 */
void replace(struct t_queue* queue, int index, element_type element)
{
	if (index >= queue->front && index < queue->rear)
	{
		queue->elements[index] = element;
		printf("Insert success! ");
	}
	else
	{
		printf("Insert failed, check your index ... ");
	}
}
