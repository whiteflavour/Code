#include "linked_list.h"

void run_application();
void insert_element();
void delete_element();

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

void insert_element()
{
	insert_after_head(3);
	insert_after_tail(5);
	print_linked_list();
	printf("%d\n", get_size());
}

void delete_element()
{
	printf("%d\n", delete_node(head->next));
	print_linked_list();
	printf("%d\n", get_size());
}