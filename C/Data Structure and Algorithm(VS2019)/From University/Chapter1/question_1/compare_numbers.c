#include<stdio.h>

/*
	输入三个数字，并从大到小输出在屏幕上。

	@author Liao
	@date 2021-3-7
*/
void input_numbers();
void compare_numbers(int numbers[], int);

int main(void)
{
	input_numbers();
}

/*
	输入三个数字
*/
void input_numbers()
{
	int number_a = 0;
	int number_b = 0;
	int number_c = 0;
	int numbers[3];

	printf("Enter three int nubmers, and use blankspace during them and finally place enter: \n");
	scanf_s("%d %d %d", &number_a, &number_b, &number_c);

	numbers[0] = number_a;
	numbers[1] = number_b;
	numbers[2] = number_c;

	compare_numbers(numbers, 3);
}

/*
	比较数字
*/
void compare_numbers(int numbers[], int length)
{
	int i = 0;
	int j = 0;

	for (i; i < length; ++i)
	{
		for (j = i + 1; j < length; ++j)
		{
			if (numbers[j] > numbers[i])
			{
				int t;
				t = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = t;
			}
		}
	}

	printf("From max to min: ");
	for (int e = 0; e < length; ++e)
	{
		printf("%d ", numbers[e]);
	}
}