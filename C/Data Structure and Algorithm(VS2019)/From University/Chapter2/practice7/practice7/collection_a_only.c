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

	// �µļ��ϣ������� A �� B ���ظ���Ԫ�ط������С�
	struct Sequence_list* both_containing_elements = (struct Sequence_list*) malloc(sizeof(struct Sequence_list));
	create_sq_list(both_containing_elements);

	int i = 0;
	int j = -1;

	// ��¼ j �ڼ��� B �е�λ�á�
	int j_position = 0;

	if (collection_a->element[0] > collection_b->element[size_b - 1])
	{
		return collection_a;
	}

	while (i < size_a)
	{
		while (j < size_b)
		{
			// ֱ�Ӵ��ϴ��� B ���ҵ� A �е�Ԫ�ص���һ��λ�ÿ�ʼѰ��
			j = j_position;

			/*
			  �� A �� i λ�õ�Ԫ�ش��� B �е�Ԫ�ر��������󣻷��򣬱��� A ������ A �� i λ�õ�Ԫ��
			 */
			while (collection_a->element[i] >= collection_b->element[j])
			{
				/*
				  ���ҵ���ȵ�Ԫ�أ���� A ��ɾ����Ԫ�ء�
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
		  ������� B ������ϣ�����ѭ��
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