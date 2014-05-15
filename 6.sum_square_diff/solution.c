#include<stdio.h>
#include<stdlib.h>

int main(){

	int number =100;
	int sum_square = 0;
	int square_sum = 0;
	int diff=0;
	int i;

	for(i=1;i<=number;i++){

		sum_square += i*i;
	}

	for(i=1;i<=number;i++){

		square_sum += i;
	}

	printf("The sum of squares is : %d\n",sum_square);
	printf("The sum is : %d\n",square_sum);

	square_sum = square_sum*square_sum;

	if(square_sum > sum_square){

		diff = square_sum - sum_square;
	}

	else{
		diff = sum_square - square_sum;
	}

	printf("The difference is : %d\n",diff);
}
