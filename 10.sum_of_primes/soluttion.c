#include<stdio.h>
#include<stdlib.h>

int main(){
	unsigned long limit=2000000;
	int val1=0;
	int val2=0;
	int itr=1;
	int flag,i;
        long ptr[200000];
	int count = 0;
	ptr[count]=2;
	count = 1;
	ptr[count]=3;
        unsigned long long sum_final=5;

	while(1){

		flag =0;
		val1=(6*itr)-1;
		if(val1 > limit){
			break;
		}
		for(i=0;i<=count;i++){
			if(val1%ptr[i] == 0){
				flag++;
			}
		}
		if(flag == 0){
			sum_final=sum_final+val1;
			count++;
			ptr[count]=val1;
		}

		flag =0;
		val2=(6*itr)+1;
		if(val2 >limit){
			break;
		}
		for(i=0;i<=count;i++){
			if(val2%ptr[i] == 0){
				flag++;
			}
		}
		if(flag == 0){
			sum_final+=val2;
			count++;
			ptr[count]=val2;
		}
		itr++;
	}

	printf("The sum of primes below %lu is : %llu\n",limit,sum_final);
        return 0; 
}

