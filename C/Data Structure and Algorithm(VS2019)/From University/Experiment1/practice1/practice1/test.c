#include "fun.h"
#include "sum.h"

void test_fun();
void test_sum();

int main(void)
{
	test_fun();
	test_sum();
}

void test_fun()
{
	int number_a, number_b;
	int* p_1, p_2;
	p_1 = &number_a;
	p_2 = &number_b;
	number_a = 1;
	number_b = -1;
	printf("%d\n", fun(p_1, p_2));
}

void test_sum()
{
	int array[30] = { 2, 234, 1334, 33, 45, 3 };
	int* array_pointer = &array;
	int size = 6;
	int* odd, * even;
	int i_odd = 0, i_even = 0;
	odd = &i_odd;
	even = &i_even;

	sum(array_pointer, size, odd, even);
}
