#pragma once

#include <stdio.h>
#include <stdlib.h>

void select_function()
{
	printf("---------------------Welcome to complex number computing program------------------------\n\n");
	printf("Functions: \n");
	printf("1 -- 输入一个实部和一个虚部，并用它们生成一个复数\n");
	printf("2 -- 求和\n");
	printf("3 -- 求差\n");
	printf("4 -- 求积\n");
	printf("5 -- 从已知复数中分离出实部\n");
	printf("6 -- 从已知复数中分离出虚部\n");
	printf("q -- 退出\n");
	printf("Choose a number to use the upper functions, then press enter: ");
}

int input_number()
{
	int number_input;
	int char_input;
	while (true)
	{
		if ((char_input = getchar()) == 'q')
		{
			return;
		}

		scanf("%d", &number_input);
		if (number_input < 1 || number_input >6)
		{
			printf("Input errors, check your input number ...\n");
			printf("Try it again: \n");
			select_function();
		}
		else
		{
			return number_input;
		}
	}
}

void init()
{
	switch(input_number())
	{
		case 1:
			create_complex_number();
		case 2:
			sum();
		case 3:
			minus();
		case 4:
			multiply();
		case 5:
			depart_real_part();
		case 6:
			depart_imaginary_part();
	}
}
