#include "linked_list.h"

void run_application();
void insert_element();
void delete_element();

/*
  链表测试

  @author Liao
  @date 2021-3-25
*/
int main(void)
{
	run_application();
}

void run_application()
{
	init_linked_list();
	insert_element();
	delete_element();
}

/*
  插入测试
*/
void insert_element()
{
	insert_after_head(3);
	insert_after_tail(5);
	print_linked_list();
	printf("%d\n", get_size());
}

/*
  删除测试
*/
void delete_element()
{
	printf("%d\n", delete_node(head->next));
	print_linked_list();
	printf("%d\n", get_size());
}