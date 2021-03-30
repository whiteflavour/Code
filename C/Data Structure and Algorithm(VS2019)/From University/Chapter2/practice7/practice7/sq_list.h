#pragma once

#include<stdio.h>
#include<stdbool.h>

#define MAX_SIZE 50
typedef int element_type;

void create_sq_list(struct Sequence_list*);
int get_size(struct Sequence_list*);
void print_sq_list(struct Sequence_list*);
element_type get(struct Sequence_list*, int);
bool insert_element(struct Sequence_list*, element_type);
bool insert_by_index(struct Sequence_list*, int, element_type);
element_type delete_element(struct Sequence_list*, int);

/*
  ˳���ͷ�ļ�

  @author Liao
  @date 2021-3-15
*/
struct Sequence_list
{
	int size;
	element_type element[MAX_SIZE];
} sq_list;

/*
  �ȵ��ô˺�������˳���� size ����ֵ��
*/
void create_sq_list(struct Sequence_list* sequence_list)
{
	sequence_list->size = 0;
}

/*
  ��ȡ˳����е�Ԫ��ֵ������

  @return Ԫ��ֵ����
*/
int get_size(struct Sequence_list* sequence_list)
{
	return sequence_list->size;
}

void print_sq_list(struct Sequence_list* sequence_list)
{
	int size = sequence_list->size;
	for (int i = 0; i < size; ++i)
	{
		printf("%d ", sequence_list->element[i]);
	}
	printf("\n");
}

/*
  ��ȡָ��������Ԫ��

  @param *sequence_list Ҫ��ȡԪ�صĽṹ��
  @param index Ҫ��ȡԪ�ص�����
  @return Ҫ��ȡ��Ԫ��
*/
element_type get(struct Sequence_list* sequence_list, int index)
{
	if (index >= 0 && index < get_size(sequence_list))
	{
		return sequence_list->element[index];
	}
	printf("No such element ... ");
	return NULL;
}

bool insert_element(struct Sequence_list* sequence_list, element_type element)
{
	int size = get_size(sequence_list);
	if (size <= 50)
	{
		sequence_list->element[size] = element;
		++(sequence_list->size);
		return element;
	}
	printf("Index out of bounds ... \n");
	return false;
}

/*
  �ڸ�������λ�����Ԫ�ء�

  @param *sequence_list Ҫ���Ԫ�صĽṹ��
  @param index Ҫ��ӵ�Ԫ�ص�����
  @param element Ҫ��ӵ�Ԫ��
  @return true if insert success.
*/
bool insert_by_index(struct Sequence_list* sequence_list, int index, element_type element)
{
	int size = get_size(sequence_list);

	/*
	  ��������������ӵ��Ԫ�أ��򽫸�λ�ü�������Ԫ�����κ���һ��λ�ã���Ԫ�ز����λ�ã����� size �� 1 ��
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
  ����������λ�õ�Ԫ��ɾ����

  @param *sequence_list Ҫɾ��Ԫ�صĽṹ��
  @param index Ҫɾ����Ԫ�ص�����
  @return ɾ����Ԫ�ء���ɾ��ʧ�ܣ��򷵻� NULL ��
*/
element_type delete_element(struct Sequence_list* sequence_list, int index)
{
	int size = get_size(sequence_list);

	/*
	  ��������������ӵ��Ԫ�أ���Ԫ��ɾ����������λ�ú����Ԫ������ǰ��һ��λ�ã����� size �� 1 ��
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
