
package com.projecteuler;

import java.util.ArrayList;

public class PrimeNumbers{
	public static ArrayList<Integer> getPrimes(int limit){
		int count=2,p1,p2,index=1;
		ArrayList<Integer> prime_numbers = new ArrayList<Integer>();
		prime_numbers.add(0, 2);
		prime_numbers.add(1, 3);
		while(true){
			p1 = (6*index-1);
			p2 = (6*index+1);
			int status=0;
			for(int i=0;i<count;i++){
				if(p1 % prime_numbers.get(i) == 0){
					status=1;
					break;
				}
			}
			if(status == 0){
				if(p1 > limit){
					return prime_numbers;
				}else{
					prime_numbers.add(count, p1);
					count++;
				}
			}
			status = 0;
			for(int i=0;i<count;i++){
				if(p2 % prime_numbers.get(i) == 0){
					status=1;
					break;
				}
			}
			if(status == 0){
				if(p2 > limit){
					return prime_numbers;
				}else{
                    prime_numbers.add(count,p2);
					count++;
				}

			}
			index++;
		}
	}


	public static boolean isPrime(int number){
		boolean status = true;
		for(int i=2;i<number;i++){
			if(number % i == 0){
				status = false;
				break;
			}
		}

		if(status){
			return true;
		}else{
			return false;
		}
	}
}