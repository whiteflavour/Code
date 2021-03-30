#include <stdlib.h>
#include "sq_list.h"

void run_application();
struct Sequence_list* init_collection(int number_array[], int size);
struct Sequence_list* get_absolute_complement(struct Sequence_list* collection_a, struct Sequence_list* collection_b);

struct Sequence_list* init_collection(int number_array[], int size);

int main()
{
	run_application();
}

void run_application()
{
	int array_a[20] = { 1, 3, 5, 8, 18 };
	int array_b[20] = { 3, 6, 7, 8, 18 };
	struct Sequence_list* collection_a = init_collection(array_a, 5);
	struct Sequence_list* collection_b = init_collection(array_b, 5);

	struct Sequence_list* both_containing_elements = get_absolute_complement(collection_a, collection_b);

	print_sq_list(collection_a);
}

struct Sequence_list* init_collection(int number_array[], int size)
{
	struct Sequence_list* sequence_list = (struct Sequence_list*) malloc(sizeof(struct Sequence_list));
	create_sq_list(sequence_list);
	for (int i = 0; i < size; ++i)
	{
		insert_element(sequence_list, number_array[i]);
	}
	return sequence_list;
}

struct Sequence_list* get_absolute_complement(struct Sequence_list* collection_a, struct Sequence_list* collection_b)
{
	int size_a = collection_a->size;
	int size_b = collection_b->size;

	// 新的集合，将集合 A 与 B 中重复的元素放入其中。
	struct Sequence_list* both_containing_elements = (struct Sequence_list*) malloc(sizeof(struct Sequence_list));
	create_sq_list(both_containing_elements);

	int i = 0;
	int j = -1;

	// 记录 j 在集合 B 中的位置。
	int j_position = 0;

	if (collection_a->element[0] > collection_b->element[size_b - 1])
	{
		return collection_a;
	}

	while (i < size_a)
	{
		while (j < size_b)
		{
			// 直接从上次在 B 中找到 A 中的元素的下一个位置开始寻找
			j = j_position;

			/*
			  若 A 中 i 位置的元素大，则将 B 中的元素遍历以增大；否则，遍历 A 以增大 A 中 i 位置的元素
			 */
			while (collection_a->element[i] >= collection_b->element[j])
			{
				/*
				  若找到相等的元素，则从 A 中删除该元素。
				*/
				if (collection_a->element[i] == collection_b->element[j])
				{
					insert_element(both_containing_elements, collection_a->element[i]);
					j_position = j + 1;
					break;
				}
				++j;
			}
			break;
		}

		/*
		  如果集合 B 遍历完毕，跳出循环
		*/
		if (j >= size_b)
		{
			break;
		}
		++i;
	}
	return both_containing_elements;
}

void get_uniq_elements(struct Sequence_list* collection_a, struct Sequence_list* both_containing_elements)
{
	int i = 0;
	int j = 0;

	int size = collection_a->size;

	for (i; i < size; ++i)
	{
		for (j = i; j < both_containing_elements->size; ++j)
		{
			// TODO
		}
	}
}