#include<stdio.h>
#include<stdlib.h>

void main(){

long long  number = 600851475143ULL;
int prime_number1 = 2;
int prime_number2 = 3;
int largest_factor = 1;
int count = 1;
if(number % prime_number1 == 0 && prime_number1 > largest_factor){

	     largest_factor = prime_number1;
	     number=number/prime_number1;
}
if(number % prime_number2 == 0 && prime_number2 > largest_factor){

             largest_factor = prime_number2;
	     number = number/prime_number2;
}
while (number != 1){
	
	prime_number1=(6*count)-1;
	prime_number2=(6*count)+1;
        /*printf("the values are %d , %d\n",prime_number1,prime_number2);*/
	if(number % prime_number1 == 0 && prime_number1 > largest_factor){

		             largest_factor = prime_number1;
			     number=number/prime_number1;
	}
	if(number % prime_number2 == 0 && prime_number2 > largest_factor){

		             largest_factor = prime_number2;
			     number = number/prime_number2;
	}
	count +=1;
}

printf("The largest factor is : %d\n",largest_factor);
}

