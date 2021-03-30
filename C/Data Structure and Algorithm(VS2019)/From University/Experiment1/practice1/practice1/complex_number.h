#pragma once

#include <stdio.h>
#include <stdlib.h>

struct complex_number
{
	int real_part;
	int imaginary_part;
};

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

void create_complex_number()
{
	int input_number_a;
	int input_number_b;

	printf("Enter the real part first, and then enter the imaginary part, and press blank space to divide them: \n");
	scanf("%d %d", &input_number_a, &input_number_b);

	struct complex_number created_complex_number;
	created_complex_number.real_part = input_number_a;
	created_complex_number.imaginary_part = input_number_b;

	printf("The complex number is : %d% + di\n", input_number_a, input_number_b);
}

void sum()
{
	int input_number_a1;
	int input_number_a2;
	int input_number_b1;
	int input_number_b2;
	int real_part_sum;
	int imaginary_part_sum;

	printf("先输入一个实部和一个虚部，再输入另一个实部和虚部，分别用空格隔开：\n");
	scanf("%d %d %d %d", &input_number_a1, &input_number_a2, &input_number_b1, &input_number_b2);

	real_part_sum = input_number_a1 + input_number_b1;
	imaginary_part_sum = input_number_a2 + input_number_b2;

	printf("\(%d + %di\) + \(%d + %di\) = %d + %di\n", input_number_a1, input_number_a2, input_number_b1, input_number_b2, real_part_sum, imaginary_part_sum);
}
