#include<stdio.h>
#include<stdlib.h>


int main(){

int value1 = 0;
int value2 = 1;
int add_value = 0;
int final_count = 0;
int count = 0;
while(add_value < 4000000){

add_value = value1 + value2;

if(add_value % 2 == 0){
final_count += add_value;
}
value1=value2;
value2=add_value;
/*printf("value[%d] =%d\n",count+1,add_value);*/
count++;
}

printf("The Count is : %d\n", count);
printf("The sum is : %d\n", final_count);

}


 
