#include<stdio.h>
#include<stdlib.h>
#include<math.h>


main(){
	int limit=20;
	int val1=0;
	int val2=0;
	int itr=1;
	int i,j,flag,count=0,count_2=0,final_multiple=1,temp;
	int *ptr=(int*)malloc(sizeof(int));
	*(ptr+count)=2;
	count++;
	*(ptr+count)=3;
	count++;

	while(1){
		
		flag =0;
		val1=(6*itr)-1;
                if(val1 > limit){
                    break;
                }     
		for(i=2;i<val1;i++){
			if(val1%i == 0){
				flag++;
			}
		}
		if(flag == 0){
			*(ptr+count)=val1;
			count++;
		}

		flag =0;
		val2=(6*itr)+1;
                if(val2 >limit){
                       break;
                }
		for(i=2;i<val2;i++){
			if(val2%i == 0){
				flag++;
			}
		}
		if(flag == 0){
			*(ptr+count) = val2;
			count++;
		}
		itr++;
	}
	for(i=0;i<count;i++){
		printf("The factor is :%u\n",*(ptr+i));
		count_2=0;
		for(j=2;j<=limit;j++){
			int num = j;
			temp = 0;
			while(1){
				if(num%*(ptr+i) == 0){
					num=num/(*(ptr+i));
					temp++;
				}
				else{
					break;
				}
			}
			if(count_2 < temp){
				count_2 += (temp - count_2);
			}
		}
		printf("The number of %u's required are :%d\n",*(ptr+i),count_2);
		final_multiple=final_multiple * pow(*(ptr+i),count_2);
	}

	printf("The final multiple is : %d\n",final_multiple);
}

			
