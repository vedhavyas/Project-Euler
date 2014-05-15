#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(){

	char unitPlace[9][9]={"one","two","three","four","five","six","seven","eight","nine"};
	char tenPlace[9][10]={"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	char hundredPlace[10][15]={"onehundred","twohundred","threehundred","fourhundred","fivehundred","sixhundred","sevenhundred","eighthundred","ninehundred","onethousand"};
	char tenRange[9][15]={"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	int limit=1000,i,j,totCount=0,flag=0;
	char str[500],temp1[100],temp2[100],temp3[100];

	for(i=1;i<=limit;i++){
		j=i;
		flag=1;
		strcpy(str,"");
		strcpy(temp1,"");
		strcpy(temp2,"");
		strcpy(temp3,"");
		while(j>0){
			if(flag == 1){
				if(j%10!=0)
					strcpy(temp1,unitPlace[(j%10)-1]);
				else
					strcpy(temp1,"");
				j=j/10;
				flag++;
			}
			else if(flag == 2){
				if(j%10!=0&&j%10!=1)
					strcpy(temp2,tenPlace[(j%10)-1]);
				else if(j%10 == 1){
					if(i%10==0){
						strcpy(temp1,"");
						strcpy(temp2,tenPlace[0]);
					}
					else{
						strcpy(temp1,"");
						strcpy(temp2,tenRange[(i%10)-1]);
					}
				}
				else if(j%10==0)
					strcpy(temp2,"");  
				j=j/10;
				flag++;
			}
			else if(flag == 3){
				if(j%10!=0)
					strcpy(temp3,hundredPlace[(j%10)-1]);
				else {
					strcpy(str,hundredPlace[9]);
					flag=5;
                                        break;
				}
				j=j/10;
				flag++;
			}
		}
		j=i;
		if(flag>=4){
			if(j%10==0&&(j/10)%10==0){
				if(flag==4)
					strcpy(str,temp3);
			}
			else{
				strcpy(str,temp3);
				strcat(str,"and");
				strcat(str,temp2);
				strcat(str,temp1);
			}

		}
		else if(flag>=3){
			strcpy(str,temp2);
			strcat(str,temp1);
		}
		else if(flag>=2){
			strcpy(str,temp1);
		}
                totCount+=strlen(str);   
	}
	printf("no of letters use from 1 to %d is : %d\n",limit,totCount);
}

