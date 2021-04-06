#pragma once

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

/*
  链表。

  @author Liao
  @date 2021-3-25
*/
typedef int element_type;

// 全局变量：表示链表的大小。
static int SIZE = 0;

/*
  链表的节点。

  @arg head 指向头节点的指针
  @arg tail 指向尾节点的指针
*/
struct Linked_list
{
	element_type data;
	struct Linked_list* next;
} *head, *tail;

/*
  初始化链表，创建头节点和初始化尾指针。
*/
void init_linked_list()
{
	head = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	head->data = NULL;
	head->next = NULL;
	tail = head;
}

/*
  获取链表的大小。
*/
int get_size()
{
	return SIZE;
}

/*
  头插法创建链表。

  @parm element 要插入的元素。
*/
void insert_after_head(element_type element)
{
	struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	new_node->data = element;
	new_node->next = head->next;
	head->next = new_node;
	tail = tail->next;
	++SIZE;
}

/*
  尾插法创建链表

  @parm element 要插入的元素。
*/
void insert_after_tail(element_type element)
{
	struct Linked_list* new_node = (struct Linked_list*)malloc(sizeof(struct Linked_list));
	new_node->data = element;
	new_node->next = NULL;
	tail->next = new_node;
	tail = tail->next;
	++SIZE;
}

/*
  在指定索引插入元素。

  @parm index 要插入位置的索引。
  @parm element 要插入的元素。
*/
bool insert_by_index(int index, element_type element)
{
	struct Linked_list* traversal_pointer = head;

	/*
	  只能在指定索引范围内插入，不能乱插，只能挨着来，或者在中间插入。
	*/
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

/*
  在给定节点的后面插入。

  @param node 指向新节点的指针。
  @param element 要插入的元素。
*/
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

/*
  删除给定节点。

  @param node 指向要删除的节点的前一个节点的指针
*/
element_type delete_node(struct Linked_list* node)
{
	/*
	  若该节点为尾节点，则下一个节点不存在，无法删除。
	*/
	if (node->next == NULL)
	{
		printf("No such node ... ");
		return NULL;
	}

	/*
	  若该节点为尾节点的前一个节点，则将删除尾节点，此时应将指向尾节点的指针往前移动。
	*/
	if (node->next->next == NULL)
	{
		/*
		  移动尾指针
		*/
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

	/*
	  另一种移动尾指针的方法
	*/
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

/*
  打印所有节点的元素
*/
void print_linked_list()
{
	// 遍历指针，遍历所有节点。
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