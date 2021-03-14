#include<stdio.h>
#define max_size 50;
typedef int element_type;

struct
{
	int size;
	element_type elements[];
} squence_list;