package com.projecteuler;

import java.util.*;


public class Problem_37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] primeNumbers = generatePrimeNumbers(100000);
		int count=0,index=4,primeNumber=0,sum=0;
		while(true){
			primeNumber = primeNumbers[index];
			if(rightToLeft(primeNumbers,primeNumber)){
				if(leftToRight(primeNumbers,primeNumber)){
					sum+=primeNumber;
					count++;
					if(count == 11){
						System.out.println("Total sum is : "+sum);
						System.exit(0);
					}
				}
			}
			index++;
			
		}
	}
	public static int[] generatePrimeNumbers(int size){
        int count=2,p1,p2,index=1;
        int [] prime_numbers = new int[size];
        prime_numbers[0] = 2;
        prime_numbers[1] = 3;
        while(true){
                p1 = (6*index-1);
                p2 = (6*index+1);
                int status=0;
                for(int i=0;i<count;i++){
                        if(p1 % prime_numbers[i] == 0){
                                status=1;
                                break;
                        }
                }
                if(status == 0){
                        if(count+1 > size){
                                return prime_numbers;
                        }else{
                                prime_numbers[count]=p1;
                                count++;
                        }
                }
                status = 0;
                for(int i=0;i<count;i++){
                        if(p2 % prime_numbers[i] == 0){
                                status=1;
                                break;
                        }
                }
                if(status == 0){
                        if(count+1 > size){
                                return prime_numbers;
                        }else{
                                prime_numbers[count]=p2;
                                count++;
                        }

                }
                index++;
        }
}
	
	public static boolean rightToLeft(int [] primeNumbers, int number){
		while(number > 0){
			if(Arrays.binarySearch(primeNumbers, number) >= 0){
				
				number/=10;
			}else{
				return false;
			}
		}
		return true;
	}

	public static boolean leftToRight(int [] primeNumbers, int number){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int tempNumber=0;
		while(number > 0){
			temp.add(number % 10);
			number/=10;
		}
		for(int i=0;i<temp.size();i++){
			for(int j=(temp.size()-1-i);j>=0;j--){
				tempNumber = tempNumber*10+temp.get(j);
			}
			if(Arrays.binarySearch(primeNumbers, tempNumber) < 0){
				return false;
			}
			tempNumber=0;
		}
		return true;
	}

}
