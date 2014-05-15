#include<stdio.h>
#include<stdlib.h>

int main(){

        int uLimit=1000000,maxNum =0,lLimit=2,count=0,arr[1500000];
        long long  maxValue=0,i,j;
        for (i=lLimit;i<uLimit;i++){
                j=i;
                count=0;
                count++;
                while(j!=1){
                        if(j%2 == 0){
                                j=j/2;
                                count++;
                        }

                        else{
                                j=(3*j)+1;
                                count++;
                        }
        /*                printf("%lld\n",j);*/
			if(j < i && j!=1){
				count=count+arr[j]-1;
				goto finish;
			}
                }

finish:         arr[i]=count;
                if(count > maxValue){
                        maxValue=count;
                        maxNum=i;
                }
        }
        printf("The Value %d has the highest chain number :%lld\n",maxNum,maxValue);
        return 0;
}

