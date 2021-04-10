#pragma once

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 50

typedef int element_type;

struct t_queue
{
	element_type elements[MAX_SIZE];
	int front;
	int rear;
};

struct t_queue* init_queue()
{
	struct t_queue* queue = (struct t_queue*)malloc(sizeof(struct t_queue));
	queue->front = 0;
	queue->rear = 0;
}

bool insert(struct t_queue* queue, element_type element)
{
	if ()
}
