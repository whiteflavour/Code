#pragma once

#include<stdio.h>

int fun(int* pointer_a, int* pointer_b)
{
	if (*pointer_a == 0 || *pointer_b == 0)
	{
		printf("Check the value ... They can not be zero ... \n");
		return -1;
	}
	if ((*pointer_a) * (*pointer_b) > 0)
	{
		return 1;
	}
	return 0;
}
