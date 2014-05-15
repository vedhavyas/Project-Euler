#include<stdio.h>
#include<stdlib.h>


int main(){

	int count = 2;
	int itr = 1;
	int limit = 10001;
	int var1=0,var2=0;
	int flag;
	int check=0;
	int i;
	while(1){

		check = 0;
		var1=(6*itr)-1;
		for (i=2;i<var1;i++){
			if(var1%i == 0){
				check++;
			}
		}
		if(check == 0){
			count+=1;
		}

		if(count == limit){
			flag=0;
			break;
		}
		check = 0;
		var2=(6*itr)+1;
		for (i=2;i<var2;i++){
			if(var2 % i == 0){
				check++;
			}
		}
		if(check == 0){
			count+=1;
		}

		if(count == limit){
			flag=1;
			break;
		}
		itr++;
	}
	if (flag == 0){
		printf("The %d prime number is : %d\n",count,var1);
	}
	else{
		printf("The %d prime number is : %d\n",count,var2);
	}
}
