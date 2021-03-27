#pragma once

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

typedef int element_type;
static int SIZE = 0;

struct Linked_list
{
	element_type data;
	struct Linked_list* next;
} *head, *tail;

void init_linked_list()
{
	head = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	head->data = NULL;
	head->next = NULL;
	tail = head;
}

int get_size()
{
	return SIZE;
}

void insert_after_head(element_type element)
{
	struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	new_node->data = element;
	new_node->next = head->next;
	head->next = new_node;
	tail = tail->next;
	++SIZE;
}

void insert_after_tail(element_type element)
{
	struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	new_node->data = element;
	new_node->next = NULL;
	tail->next = new_node;
	tail = tail->next;
	++SIZE;
}

bool insert_by_index(int index, element_type element)
{
	struct Linked_list* traversal_pointer = head;
	if (index >= 0 && index <= SIZE)
	{
		int i = 0;
		for (i; i < index; ++i)
		{
			traversal_pointer = traversal_pointer->next;
		}

		// 新分配一块内存，接下来插入新结点。
		struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
		new_node->data = element;
		new_node->next = traversal_pointer->next;
		traversal_pointer->next = new_node;
		++SIZE;
		return true;
	}
	printf("Can not insert here ... Check your index! ");
	return false;
}

void insert_after_node(struct Linked_list* node, element_type element)
{
	struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	new_node->data = element;
	new_node->next = node->next;
	node->next = new_node;
	++SIZE;
	if (new_node->next == NULL)
	{
		tail = tail->next;
	}
}

element_type delete_node(struct Linked_list* node)
{
	if (node->next == NULL)
	{
		printf("No such node ... ");
		return NULL;
	}

	if (node->next->next == NULL)
	{
		tail = head;
		for (int i = 0; i < SIZE - 1; ++i)
		{
			tail = tail->next;
		}
	}

	element_type element = node->next->data;
	node->next = node->next->next;
	free(node->next);
	--SIZE;

//	if (node->next == NULL)
//	{
//		tail = head;
//		for (int i = 0; i < SIZE; ++i)
//		{
//			tail = tail->next;
//		}
//	}

	return element;
}

void print_linked_list()
{
	struct Linked_list* traversal_pointer = head;
	if (SIZE > 0)
	{
		for (int i = 0; i < SIZE; ++i)
		{
			traversal_pointer = traversal_pointer->next;
			printf("%d ", traversal_pointer->data);
		}
		printf("\n");
	}
	else
	{
		printf("No elements in this linked list ... \n");
	}
}