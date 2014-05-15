#include<stdio.h>
#include<stdlib.h>


int main(){

	FILE *fp;
	char ch;
	int count=0,numbers[100][50],i=0,j;
        int value=0,final[200];
	fp=fopen("test.txt","r");
	while( ( ch = fgetc(fp) ) != EOF ){
		if(count == 50){
			i++;
			count=0;
		}	
                j=ch - '0';
                if(j != -38){  
                numbers[i][count]=j; 
		count++; 
                 }
	}
	count=0;
	fclose(fp);
	j=49;
	while(j>=0){
		for(i=0;i<100;i++)
			value=value+numbers[i][j];
		final[count]=value%10;
		count++;
		value = value/10;
		j--;
        }

	while(value >0 ){
		final[count]=value%10;
		count++;
		value=value/10;
	}

	for(i=0;i<10;i++){

		printf("%d",final[(count-1)-i]);
	}
       printf("\n");
}



