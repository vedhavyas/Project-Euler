#include<stdio.h>
#include<stdlib.h>

int main(){
	int limit=20;
	long long arr[limit+1][limit+1];

       /*for(int i=0;i<limit+1;i++){
		for(int j=0;j<limit+1;j++){
			arr[i][j]=0;
			}
	}*/
	for(int i=0;i<limit+1;i++){
		for(int j=i;j<limit+1;j++){
			if(i==0 || j==0){
				arr[i][j]=1;
				arr[j][i]=1;
			}
			else{
				arr[i][j]=arr[i-1][j]+arr[i][j-1];
				arr[j][i]=arr[j-1][i]+arr[j][i-1];
			}
		}
	}

	/*for(int i=0;i<limit+1;i++){
		for(int j=0;j<limit+1;j++)
			printf("%lld  \t",arr[i][j]);
		printf("\n");
	}*/
	printf("The Total number of lattice paths for the grid %d * %d are : %lld\n",limit,limit,arr[limit][limit]);
        return 0;
}

