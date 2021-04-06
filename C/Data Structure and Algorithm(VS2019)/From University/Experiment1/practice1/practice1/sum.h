#pragma once

#include<stdio.h>

void sum(int* array, int size, int* odd, int* even)
{
	for (int i = 0; i < size; ++i)
	{
		if ((array[i] & 1) == 1)
		{
			*odd += array[i];
		}

		if ((array[i] & 1) == 0)
		{
			*even += array[i];
		}
	}

	printf("奇数之和：%d, ", *odd);
	printf("偶数之和：%d\n", *even);
}
