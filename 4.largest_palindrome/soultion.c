#include<stdio.h>
#include<stdlib.h>


int main(){
long number=0;
long new_number=0;
long palendrome=0;
int i,j;
for(i=100;i<=999;i++){
     for(j=100;j<=999;j++){
       number=i*j;
       while(number > 0){
	       new_number = new_number*10 + (number%10);
               number = number/10;
       }
       if(i*j == new_number){
          if(new_number > palendrome){
               palendrome = new_number;
           }
        } 
       new_number = 0;
      }
 }
printf("The number is : %d\n", palendrome);
}
