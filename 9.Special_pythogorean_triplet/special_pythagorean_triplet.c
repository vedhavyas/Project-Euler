#include<stdio.h>
#include<stdlib.h>
#include<math.h>

main(){

	int a,b,c=1,ab,diff_ab,sum_ab,i,j;
	while(1){

		if(((1000*1000)-2000*c)%2 == 0){
			ab=((1000*1000)-2000*c)/2;
			sum_ab=1000-c;
			for(i=1;i<c;i++){
				b=i;
				for(j=1;j<i;j++){
					a=j;
					if((a+b+c)== 1000 && (a*a+b*b)==c*c){
						printf("The values are : %d, %d, %d\n",a,b,c);
                                                printf("The Product is : %d\n",a*b*c);
						return;
					}
				}
			}
		}
		c++;
	}
}
