#include<stdio.h>
#include<stdlib.h>

int main(){

	int i,count=1,temp,pre_temp,factors[1000],divisor;
	long triangle=0;
	int limit = 500;
	while(1){

		triangle += count;
		temp=0;
		divisor = 1;
		while(1){
			if(divisor<=triangle){
				if(triangle % divisor ==0){
					for(i=0;i<temp;i++){
						if(factors[i] == divisor){
							if(temp > limit)
								goto finish;
							else
								goto next;
						}
					}
					factors[temp]= divisor;
					temp++;
					if(triangle/divisor != divisor){
						factors[temp]=triangle/divisor;
						temp++;
					}
				}
				divisor += 1;
			}
			else
				break;
		}

next: count++;
	}
finish : printf("The triangle value with %d divisors is : %d\n",temp,triangle);
}
