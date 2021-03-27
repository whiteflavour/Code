#pragma once

#include <stdio.h>
#include <stdlib.h>

void select_function()
{
	printf("---------------------Welcome to complex number computing program------------------------\n\n");
	printf("Functions: \n");
	printf("1 -- ����һ��ʵ����һ���鲿��������������һ������\n");
	printf("2 -- ���\n");
	printf("3 -- ���\n");
	printf("4 -- ���\n");
	printf("5 -- ����֪�����з����ʵ��\n");
	printf("6 -- ����֪�����з�����鲿\n");
	printf("q -- �˳�\n");
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
