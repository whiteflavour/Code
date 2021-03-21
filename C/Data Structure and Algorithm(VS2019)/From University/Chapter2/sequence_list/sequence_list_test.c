#include<stdio.h>
#include "sequence_list.h"

void run_application();
struct Sequence_list* get_sq_list();
void create_list();
void insert_into_list();
void delete_from_list();

/*
  顺序表测试

  @author Liao
  @date 2021-3-16
*/
int main(void)
{
	run_application();
}

void run_application()
{
	create_list();
	insert_into_list();
	delete_from_list();
}

/*
  获取指向顺序表的指针

  @return 指向顺序表的指针
*/
struct Sequence_list* get_sq_list()
{
	struct Sequence_list* sequence_list = &sq_list;
	return sequence_list;
}

/*
  打印顺序表中拥有的元素
*/
void print_elements()
{
	struct Sequence_list* sequence_list = get_sq_list();
	for (int i = 0; i < get_size(); ++i)
	{
		printf("%d ", get(sequence_list, i));
	}
}

/*
  创建一个包含 0 个元素的顺序表
*/
void create_list()
{
	struct Sequence_list* sequence_list = get_sq_list();
	create_sq_list(sequence_list);
	printf("Primary size: ");
	printf("%d\n\n", get_size());
}

/*
  向顺序表中插入数据
*/
void insert_into_list()
{
	struct Sequence_list* sequence_list = get_sq_list();
	insert_element(sequence_list, 0, 3);
	insert_element(sequence_list, 1, 2);
	insert_element(sequence_list, 5, 2);

	printf("Size after inserting: ");
	printf("%d\n", get_size());

	printf("Elements: ");
	print_elements();
	printf("\n\n");
}

/*
  从顺序表中删除数据
*/
void delete_from_list()
{
	struct Sequence_list* sequence_list = get_sq_list();
	printf("The deleted element: ");
	printf("%d\n", delete_element(sequence_list, 0));
	printf("Size after deleting: ");
	printf("%d\n", get_size());
	printf("Elements: ");
	print_elements();
	printf("\n\n");
}