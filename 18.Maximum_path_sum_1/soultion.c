#include<stdio.h>
#include<stdlib.h>

int main(){
	FILE *fp;
	char ch;
        int i,j=0,k=0,count=0,inc=1,arr[20][20];
	fp=fopen("test.txt","r");
	while (!feof(fp)){
                fscanf(fp,"%d",&i);
		arr[j][k]=i;
		k++;
		count++;
		if(count==inc){
			j++;
			k=0;
			inc++;
			count=0;
		}


	}

	fclose(fp);
	for(i=0;i<j;i++){
		for(k=0;k<=i;k++)
			printf("%d  ",arr[i][k]);
		printf("\n");
        } 
}
