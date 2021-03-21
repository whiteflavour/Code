#pragma once

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

typedef int element_type;

struct Linked_list
{
	element_type data;
	struct Linked_list* next;
	int size = 0;
} *linked_list, *head;

struct Linked_list* get_head_node()
{
	head->data = NULL;
	head->next = linked_list;
	return head;
}

void insert_after_head(element_type element)
{
	struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	int size = linked_list->size;
	if (size == 0)
	{
		linked_list->data = element;
		linked_list->next = NULL;
		++linked_list->size;
	}
	else
	{
		++linked_list->size;
		new_node = linked_list;
		new_node->data = element;
		new_node->next = head->next;
		head->next = new_node;
	}
}

void insert_after_tail(element_type element)
{
	struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	int size =  linked_list->size;
	if (size == 0)
	{
		++linked_list->size;
		linked_list->data = element;
		linked_list->next = NULL;
	}
	else
	{
		++linked_list->size;
		new_node->data = element;
		new_node->next = NULL;
		linked_list->next = new_node;
	}
}