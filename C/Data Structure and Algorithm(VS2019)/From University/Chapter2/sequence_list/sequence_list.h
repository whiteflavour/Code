#pragma once

#include<stdio.h>
#include<stdbool.h>

#define MAX_SIZE 50
typedef int element_type;

void create_sq_list(struct Sequence_list*);
int get_size();
element_type get(struct Sequence_list*, int);
bool insert_element(struct Sequence_list*, int, element_type);
element_type delete_element(struct Sequence_list*, int);

/*
  顺序表头文件

  @author Liao
  @date 2021-3-15
*/
struct Sequence_list
{
	int size;
	element_type element[MAX_SIZE];
} sq_list;

/*
  先调用此函数，给顺序表的 size 赋初值。
*/
void create_sq_list(struct Sequence_list* sequence_list)
{
	int size = sequence_list->size;
	size = 0;
}

/*
  获取顺序表含有的元素值数量。

  @return 元素值数量
*/
int get_size()
{
	struct Sequence_list* sequence_list = &sq_list;
	return sequence_list->size;
}


/*
  获取指定索引的元素

  @param *sequence_list 要获取元素的结构体
  @param index 要获取元素的索引
  @return 要获取的元素
*/
element_type get(struct Sequence_list* sequence_list, int index)
{
	if (index >= 0 && index < get_size())
	{
		return sequence_list->element[index];
	}
	printf("No such element ... ");
	return NULL;
}

/*
  在给定索引位置添加元素。

  @param *sequence_list 要添加元素的结构体
  @param index 要添加的元素的索引
  @param element 要添加的元素
  @return true if insert success.
*/
bool insert_element(struct Sequence_list* sequence_list, int index, element_type element)
{
	int size = get_size();

	/*
	  若给出的索引上拥有元素，则将该位置及其后面的元素依次后移一个位置，将元素插入该位置，并将 size 加 1 。
	*/
	if (index >= 0 && index <= size)
	{
		for (int i = size - 1; i >= index; --i)
		{
			sequence_list->element[i + 1] = sequence_list->element[i];
		}
		sequence_list->element[index] = element;
		++(sequence_list->size);
		return true;
	}
	printf("Can not insert here ... \n");
	return false;
}

/*
  将给定索引位置的元素删除。

  @param *sequence_list 要删除元素的结构体
  @param index 要删除的元素的索引
  @return 删除的元素。若删除失败，则返回 NULL 。
*/
element_type delete_element(struct Sequence_list* sequence_list, int index)
{
	int size = get_size();

	/*
	  若给出的索引上拥有元素，则将元素删除，并将该位置后面的元素依次前移一个位置，并将 size 减 1 。
	*/
	if (index >= 0 && index < size) {
		element_type removed_element = sequence_list->element[index];
		for (int i = index; i < size - 1; ++i)
		{
			sequence_list->element[i] = sequence_list->element[i + 1];
		}
		--(sequence_list->size);
		return removed_element;
	}
	printf("No such element ... \n");
	return NULL;
}